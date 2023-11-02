package ru.li.homeworks.homework11;

public class Horse extends Animal {
    public Horse(String name) {
        super(name);
        this.runningSpeed = 20;
        this.swimmingSpeed = 1;
        this.swimmingStaminaCost = 4;
        this.stamina = 120;
    }
}
