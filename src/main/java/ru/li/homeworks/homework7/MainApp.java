package ru.li.homeworks.homework7;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[][] someArray = new int[][]{
                {-1, 1, 1, -1},
                {2, -2, -2, 2},
                {3, -3, -3, 3},
                {-4, 4, 4, -4}
        };
        sumOfPositiveElements(someArray);
        printSquare(5);
        resetDiagonals(someArray);
        System.out.println("findMax: " + findMax(someArray));
        System.out.println("secondLineSum: " + secondLineSum(someArray));

    }

    private static int secondLineSum(int[][] array) {
        if (array.length < 2) {
            return -1;
        }
        int sum = 0;
        for (int number : array[1]) {
            sum += number;
        }
        return sum;
    }

    private static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] element : array) {
            for (int number : element) {
                max = Math.max(max, number);
            }
        }
        return max;
    }

    private static void resetDiagonals(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 0;
                }
                if (i + j == array.length - 1) {
                    array[i][j] = 0;
                }
            }
        }
        printArray(array);
    }

    private static void printArray(int[][] array) {
        for (int[] element : array) {
            System.out.println(Arrays.toString(element));
        }
    }

    private static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int[] ints : array) {
            for (int number : ints) {
                if (number > 0) {
                    sum += number;
                }
            }
        }
        System.out.println("sumOfPositiveElements: " + sum);
    }

}
