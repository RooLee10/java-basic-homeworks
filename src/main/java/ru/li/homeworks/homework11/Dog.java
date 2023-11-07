package ru.li.homeworks.homework11;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        this.runningSpeed = 5;
        this.swimmingSpeed = 1;
        this.swimmingStaminaCost = 2;
        this.stamina = 70;
    }
}
