package ru.li.homeworks.homework29;

public class MultiThreading {
    private final Object mon;
    private String letter;

    public MultiThreading() {
        this.mon = new Object();
        this.letter = "";
    }

    public void printA() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (!(letter.isEmpty() || letter.equals("C"))) {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                letter = "A";
                System.out.print(letter);
                mon.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (!letter.equals("A")) {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                letter = "B";
                System.out.print(letter);
                mon.notifyAll();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (!letter.equals("B")) {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                letter = "C";
                System.out.print(letter);
                mon.notifyAll();
            }
        }
    }
}
