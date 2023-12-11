package ru.li.homeworks.homework17;

public class MyStack extends MyLinkedList {
    public void push(String data) {
        addFirst(data);
    }

    public String pop() {
        String result = getFirst();
        remove(0);
        return result;
    }
}
