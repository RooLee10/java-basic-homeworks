package ru.li.homeworks.homework27;

public class MainApp {
    public static void main(String[] args) {
        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();

        boxApple1.add(new Apple());
        boxApple1.add(new Apple());

        System.out.println("Коробка яблок 1: " + boxApple1.getFruits());
        System.out.println("Коробка яблок 2: " + boxApple2.getFruits());

        System.out.println("Пересыпали яблоки из коробки 1 в коробку 2");
        boxApple1.transfer(boxApple2);

        System.out.println("Коробка яблок 1: " + boxApple1.getFruits());
        System.out.println("Коробка яблок 2: " + boxApple2.getFruits());

        Box<Orange> boxOrange = new Box<>();

        boxOrange.add(new Orange());
        boxOrange.add(new Orange());
        System.out.println("Коробка апельсинов: " + boxOrange.getFruits());

        System.out.println("Сравнение коробки яблок 2 с апельсинами. Коробки равны по весу: " + boxApple2.compare(boxOrange));

        Box<Fruit> boxFruit = new Box<>();
        System.out.println("Коробка фруктов: " + boxFruit.getFruits());

        System.out.println("Пересыпали апельсины в коробку фруктов");
        boxOrange.transfer(boxFruit);

        System.out.println("Пересыпали яблоки из коробки 2 в коробку фруктов");
        boxApple2.transfer(boxFruit);

        System.out.println("Коробка яблок 2: " + boxApple2.getFruits());
        System.out.println("Коробка апельсинов: " + boxOrange.getFruits());
        System.out.println("Коробка фруктов: " + boxFruit.getFruits());
    }
}
