package ru.li.homeworks.homework27;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public List<?> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        this.fruits.add(fruit);
    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public int weight() {
        return fruits.size() * 150; // среднее вес в граммах
    }


    public boolean compare(Box<?> box) {
        // Не стал ограничивать метасимвол так как создание коробки и так ограничено
        // и не может прилететь коробка с несовместимым типом
        return this.weight() == box.weight();
    }

    public void transfer(Box<? super T> anotherBox) {
        for (T fruit : fruits) {
            anotherBox.add(fruit);
        }
        fruits.clear(); // Раз пересыпали, значит коробка стала пустой
    }
}
