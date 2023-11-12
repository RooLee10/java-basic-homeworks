package ru.li.homeworks.homework12;

public class MainApp {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Leopold", 10),
                new Cat("Matilda", 5),
                new Cat("Pushok", 20),
        };
        Plate plate = new Plate(20);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
            System.out.println("-----------------");
        }
        plate.addFood(15);

    }
}
