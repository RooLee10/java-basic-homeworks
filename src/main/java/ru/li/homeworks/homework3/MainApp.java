package ru.li.homeworks.homework3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        makeChoice();
    }

    private static void makeChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Введите число от 1 до 5");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 5);
        processSelection(choice);
    }

    private static void processSelection(int choice) {
        if (choice == 1) {
            greetings();
        } else if (choice == 2) {
            int a = getRandomInt();
            int b = getRandomInt();
            int c = getRandomInt();
            checkSign(a, b, c);
        } else if (choice == 3) {
            selectColor();
        } else if (choice == 4) {
            compareNumbers();
        } else if (choice == 5) {
            int initValue = getRandomInt();
            int delta = getRandomInt();
            boolean increment = getRandomBoolean();
            addOrSubtractAndPrint(initValue, delta, increment);
        }
    }

    private static boolean getRandomBoolean() {
        int rnd = (int) (Math.random() * 2);
        return rnd == 1;
    }

    private static int getRandomInt() {
        int rnd = (int) (Math.random() * 11);
        boolean negative = getRandomBoolean();
        if (negative) {
            rnd *= -1;
        }
        return rnd;
    }

    private static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result;
        char operator;
        if (increment) {
            result = initValue + delta;
            operator = '+';
        } else {
            result = initValue - delta;
            operator = '-';
        }
        System.out.println("(incriment = " + increment + ") " + initValue + " " + operator + " " + delta + " = " + result);
    }

    private static void compareNumbers() {
        int a = 15;
        int b = 7;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void selectColor() {
        int data = 215;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void checkSign(int a, int b, int c) {
        int result = a + b + c;
        System.out.println(a + " + " + b + " + " + c + " = " + result);
        if (result > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }
}
