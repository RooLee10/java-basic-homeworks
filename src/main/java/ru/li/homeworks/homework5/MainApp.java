package ru.li.homeworks.homework5;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        printNTimes(3, "Hello");
        printSumArray(new int[]{1, 7, 8, 3, 2, 15});
        fillArrayWithNumber(7, new int[10]);
        increaseArrayValues(1, new int[]{1, 1, 1, 1, 1});
        compareSumsHalvesOfArray(new int[]{1, 1, 2, 1, 1, 3});
        // Задания со звёздочкой (*)
        sumAllArrays(new int[]{1, 2, 3}, new int[]{2, 2}, new int[]{1, 1, 1, 1, 1});
        sumOfSidesIsEqual(new int[]{5, 3, 4, -2});
        checkArrayOrder(new int[]{6, 5, 5, 3}, "decr"); // decr, incr
        flipArray(new int[]{1, 2, 3, 4, 5});
    }

    private static void flipArray(int[] array) {
        int[] result = new int[array.length];
        int reverseIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = array[reverseIndex - i];
        }
        System.out.println("flipArray: " + Arrays.toString(result));
    }

    private static void checkArrayOrder(int[] array, String order) {

        if (order.equals("decr")) {
            checkArrayOrderDecrease(array, order);
        } else if (order.equals("incr")) {
            checkArrayOrderIncrease(array, order);

        } else {
            System.out.println("checkArrayOrder: Все сломалось..");
        }
    }

    private static void checkArrayOrderIncrease(int[] array, String order) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("checkArrayOrder: Элементы НЕ соответствуют порядку " + order);
                return;
            }
        }
        System.out.println("checkArrayOrder: Все элементы идут в порядке " + order);
    }

    private static void checkArrayOrderDecrease(int[] array, String order) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                System.out.println("checkArrayOrder: Элементы НЕ соответствуют порядку " + order);
                return;
            }
        }
        System.out.println("checkArrayOrder: Все элементы идут в порядке " + order);
    }

    private static void sumOfSidesIsEqual(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        for (int separator = 0; separator < array.length; separator++) {
            for (int i = 0; i < array.length; i++) {
                if (i > separator) {
                    rightSum += array[i];
                } else {
                    leftSum += array[i];
                }
            }
            if (leftSum == rightSum) {
                System.out.println("sumOfSidesIsEqual: В массиве есть 'точка'. Сумма - " + leftSum);
                return;
            }
            leftSum = 0;
            rightSum = 0;
        }
        System.out.println("sumOfSidesIsEqual: В массиве нет 'точки'");
    }

    private static void sumAllArrays(int[]... arrayList) {
        int maxLength = 0;
        for (int[] array : arrayList) {
            maxLength = Math.max(maxLength, array.length);
        }
        int[] result = new int[maxLength];
        for (int[] array : arrayList) {
            for (int i = 0; i < array.length; i++) {
                result[i] += array[i];
            }
        }
        System.out.println("sumAllArrays: " + Arrays.toString(result));
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
        System.out.print("compareSumsHalvesOfArray: (" + sum1 + ") (" + sum2 + ") - ");
        if (sum1 > sum2) {
            System.out.println("Сумма элементов левой половины больше");
        } else if (sum1 < sum2) {
            System.out.println("Сумма элементов правой половины больше");
        } else {
            System.out.println("Суммs элементов обеих половин равны");
        }
    }

    private static void increaseArrayValues(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += number;
        }
        System.out.println("increaseArrayValues: " + Arrays.toString(array));
    }

    private static void fillArrayWithNumber(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
        System.out.println("fillArrayWithNumber: " + Arrays.toString(array));
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
        for (int i = 0; i < times; i++) {
            System.out.println(word);
        }
    }
}
