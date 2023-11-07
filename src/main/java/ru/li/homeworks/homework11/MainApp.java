package ru.li.homeworks.homework11;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat("Garfield"), new Dog("Hachiko"), new Horse("Spirit")};
        for (Animal animal : animals) {
            System.out.println("--------------------------------------");
            animal.run(40);
            animal.swim(5);
            animal.info();
        }
    }
}
