package ru.li.homeworks.homework17;

public class MyQueue extends MyLinkedList {
    public void offer(String data) {
        addLast(data);
    }

    public String poll() {
        String result = getFirst();
        remove(0);
        return result;
    }
}
