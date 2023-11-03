package ru.li.homeworks.homework11;

public abstract class Animal {
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
        int timeSpent;
        int lostStamina = distance * runningStaminaCost;
        if (lostStamina > stamina) {
            int distanceCovered = stamina / runningStaminaCost;
            timeSpent = distanceCovered / runningSpeed;
            System.out.println(name + " пробежал " + distanceCovered + " из " + distance + " за " + timeSpent + " сек. и устал");
            stamina = 0;
            return -1;
        }
        timeSpent = distance / runningSpeed;
        stamina -= lostStamina;
        System.out.println(name + " пробежал " + distance + " метров за " + timeSpent + " сек.");
        return timeSpent;
    }

    public int swim(int distance) {
        int timeSpent;
        int lostStamina = distance * swimmingStaminaCost;
        if (lostStamina > stamina) {
            int distanceCovered = stamina / swimmingStaminaCost;
            timeSpent = distanceCovered / swimmingSpeed;
            System.out.println(name + " проплыл " + distanceCovered + " из " + distance + " за " + timeSpent + " сек. и устал");
            stamina = 0;
            return -1;
        }
        timeSpent = distance / swimmingSpeed;
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
