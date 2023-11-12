package ru.li.homeworks.homework12;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            satiety = true;
            System.out.println(name + " поел.");
            return;
        }
        System.out.println(name + " не смог поесть, не хватило еды.");
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\nАппетит: " + appetite + "\nСытость: " + satiety;
    }
}
