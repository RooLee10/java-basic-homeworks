package ru.li.homeworks.homework11;

public class Animal {
    String name;
    int runningSpeed;
    int swimmingSpeed;
    int runningStaminaCost;
    int swimmingStaminaCost;
    int stamina;

    public Animal(String name) {
        this.name = name;
        this.runningStaminaCost = 1;
    }

    public int run(int distance) {
        int timeSpent = distance / runningSpeed;
        int lostStamina = stamina - distance * runningStaminaCost;
        if (lostStamina < 0) {
            System.out.println(name + " пробежал " + stamina / runningStaminaCost + " из " + distance + " и устал");
            stamina = 0;
            return -1;
        }
        stamina -= lostStamina;
        System.out.println(name + " пробежал " + distance + " метров за " + timeSpent + " сек.");
        return timeSpent;
    }

    public int swim(int distance) {
        int timeSpent = distance / swimmingSpeed;
        int lostStamina = stamina - distance * swimmingStaminaCost;
        if (lostStamina < 0) {
            System.out.println(name + " проплыл " + stamina / swimmingStaminaCost + " из " + distance + " и устал");
            stamina = 0;
            return -1;
        }
        stamina -= lostStamina;
        System.out.println(name + " проплыл " + distance + " метров за " + timeSpent + " сек.");
        return timeSpent;
    }

    public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + runningSpeed + " м/с");
        System.out.println("Скорость плавания: " + swimmingSpeed + " м/с");
        System.out.println("Выносливость: " + stamina);
    }
}
