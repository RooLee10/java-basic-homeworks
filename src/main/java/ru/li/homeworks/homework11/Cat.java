package ru.li.homeworks.homework11;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.runningSpeed = 10;
        this.stamina = 50;
    }

    @Override
    public int swim(int distance) {
        System.out.println("Похоже " + name + " тонет (meow..)");
        return -1;
    }
}
