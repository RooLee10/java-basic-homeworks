package ru.li.homeworks.homework29;

public class MainApp {
    public static void main(String[] args) {
        MultiThreading multiThreading = new MultiThreading();
        new Thread(() -> multiThreading.printA()).start();
        new Thread(() -> multiThreading.printB()).start();
        new Thread(() -> multiThreading.printC()).start();
    }
}
