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
        int weight = 0;
        for (T f : fruits) {
            weight += f.getWeight();
        }
        return weight;
    }


    public boolean compare(Box<?> box) {
        // Не стал ограничивать метасимвол так как создание коробки и так ограничено
        // и не может прилететь коробка с несовместимым типом
        return this.weight() == box.weight();
    }

    public void transfer(Box<? super T> anotherBox) {
        if (this == anotherBox) {
            System.out.println("Отказ. Попытка пересыпать в ту же коробку. Используйте другую коробку для пересыпания");
            return;
        }
        if (anotherBox == null) {
            System.out.println("Отказ. Попытка пересыпать в неинициализированную коробку.");
            return;
        }
        for (T fruit : fruits) {
            anotherBox.add(fruit);
        }
        fruits.clear(); // Раз пересыпали, значит коробка стала пустой
    }
}
