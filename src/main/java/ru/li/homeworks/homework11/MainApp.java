package ru.li.homeworks.homework11;

public class MainApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        cat.info();
        cat.run(55);
        cat.swim(5);

        Dog dog = new Dog("Laika");
        dog.info();
        dog.run(55);
        dog.swim(10);
        dog.info();
    }
}
