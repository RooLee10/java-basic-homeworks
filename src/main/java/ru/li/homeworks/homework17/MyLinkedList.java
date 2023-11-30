package ru.li.homeworks.homework17;

import java.util.NoSuchElementException;

public class MyLinkedList {
    private int size = 0;
    private Node first;
    private Node last;

    public int getSize() {
        return size;
    }

    public String getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public String getlast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    public void addFirst(String data) {
        Node newNode = new Node();
        newNode.item = data;
        if (first != null) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        } else {
            first = newNode;
            last = newNode;
        }
        size++;
    }

    public void addLast(String data) {
        Node newNode = new Node();
        newNode.item = data;
        if (last != null) {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        } else {
            first = newNode;
            last = newNode;
        }
        size++;
    }

    public void add(int position, String data) {
        if (position == 0) {
            addFirst(data);
            return;
        }
        Node currentNode = getNode(position);
        Node newNode = new Node();
        newNode.item = data;
        Node prevNode = currentNode.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = currentNode;
        currentNode.prev = newNode;
        size++;
    }

    public void remove(int position) {
        Node currentNode = getNode(position);
        Node prevNode = currentNode.prev;
        Node nextNode = currentNode.next;
        if (prevNode == null) {
            first = nextNode;
        }
        if (nextNode == null) {
            last = prevNode;
        }
        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        currentNode.prev = null;
        currentNode.next = null;
        size--;
    }

    public String get(int position) {
        Node currentNode = getNode(position);
        return currentNode.item;
    }

    private Node getNode(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == size - 1) {
            return last; // Для быстрого поиска последней ноды
        }
        Node currentNode = first;
        int currentPosition = 0;
        while (currentPosition != position) {
            currentNode = currentNode.next;
            currentPosition++;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        Node currentNode = first;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (currentNode != null) {
            sb.append(currentNode.item);
            if (currentNode.next != null) {
                sb.append(", ");
            }
            currentNode = currentNode.next;
        }
        sb.append("]");

        return sb.toString();
    }

    private static class Node {
        String item;
        Node next;
        Node prev;
    }
}
