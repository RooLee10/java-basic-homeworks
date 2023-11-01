package ru.li.homeworks.homework5;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        printNTimes(3, "Hello");
        printSumArray(new int[]{1, 7, 8, 3, 2, 15});
        fillArrayWithNumber(7, new int[10]);
        encreaseArrayValues(1, new int[]{1, 1, 1, 1, 1});
        compareSumsHalvesOfArray(new int[]{1, 1, 2, 1, 1, 3});

    }

    private static void compareSumsHalvesOfArray(int[] array) {
        int sum1 = 0;
        int sum2 = 0;
        int half = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 <= half) {
                sum1 += array[i];
            } else {
                sum2 += array[i];
            }
        }
        if (sum1 > sum2) {
            System.out.println("Сумма элементов левой половины больше");
        } else if (sum1 < sum2) {
            System.out.println("Сумма элементов правой половины больше");
        } else {
            System.out.println("Суммs элементов обеих половин равны");
        }
        System.out.println(sum1 + " " + sum2);
    }

    private static void encreaseArrayValues(int nubmer, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += nubmer;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void fillArrayWithNumber(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void printSumArray(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number > 5) {
                sum += number;
            }
        }
        System.out.println("Сумма чисел (которые больше 5-ти): " + sum);
    }

    private static void printNTimes(int times, String word) {
        for (int i = 0; i < times; i++){
            System.out.println(word);
        }
    }
}
