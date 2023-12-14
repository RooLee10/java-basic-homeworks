package ru.li.homeworks.homework21;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        singleThread();
        System.out.println("singleThread: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        multiThreads();
        System.out.println("multiThreads: " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void multiThreads() throws InterruptedException {
        int numberOfThreads = 4; // управление количеством потоков
        double[] array = getNewArray();
        List<Integer> ranges = new ArrayList<>();
        int amountOfElements = array.length;
        for (int i = 0; i < numberOfThreads; i++) {
            ranges.add(amountOfElements);
            amountOfElements /= 2;
        }
        ranges.add(0);

        List<Thread> threads = new ArrayList<>();
        for (int i = ranges.size() - 1; i > 0; i--) {
            int start = ranges.get(i);
            int end = ranges.get(i - 1);
            threads.add(new Thread(() -> fillArray(array, start, end)));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    private static void singleThread() {
        double[] array = getNewArray();
        fillArray(array, 0, array.length);
    }

    private static void fillArray(double[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    private static double[] getNewArray() {
        return new double[100_000_000];
    }
}
