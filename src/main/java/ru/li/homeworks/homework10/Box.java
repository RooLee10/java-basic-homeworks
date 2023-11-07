package ru.li.homeworks.homework10;

public class Box {
    private final int height;
    private final int length;
    private final int width;
    private String color;
    private String item;
    private boolean isOpen;

    public void setColor(String color) {
        System.out.println("Вы перекрасили коробку в '" + color + "' цвет");
        this.color = color;
    }

    public Box(int height, int length, int width, String color) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.color = color;
        this.item = "";
    }

    public void putItemIn(String item) {
        if (!isOpen) {
            System.out.println("Сначала нужно открыть коробку..");
            return;
        }
        if (!this.item.isEmpty()) {
            System.out.println("Коробка уже полная, там лежит: " + this.item);
            return;
        }
        System.out.println("Вы положили предмет '" + item + "' в коробку");
        this.item = item;
    }

    public void takeItemOut() {
        if (!isOpen) {
            System.out.println("Сначала нужно открыть коробку..");
            return;
        }
        if (item.isEmpty()) {
            System.out.println("В коробке и так ничего нет..");
            return;
        }
        System.out.println("Предмет '" + item + "' покинул коробку");
        item = "";
    }


    public void open() {
        if (isOpen) {
            System.out.println("Коробка уже открыта..");
            return;
        }
        System.out.println("Вы открыли коробку");
        isOpen = true;
    }

    public void close() {
        if (!isOpen) {
            System.out.println("Коробка уже закрыта..");
            return;
        }
        System.out.println("Вы закрыли коробку");
        isOpen = false;
    }

    public void printInfo() {
        System.out.println("Коробка");
        System.out.println("Цвет: " + color);
        System.out.println("Размеры: " + height + "x" + length + "x" + width);
        System.out.println("Открыта: " + isOpen);
        System.out.println("Предмет: " + item);
    }
}
