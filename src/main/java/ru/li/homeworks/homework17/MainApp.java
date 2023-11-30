package ru.li.homeworks.homework17;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst("Java");
        myList.addFirst("Hello");
        myList.add(1, "from");
        System.out.println(myList.getSize());
        System.out.println(myList.getFirst());
        System.out.println(myList.getlast());

        System.out.println("------------------------------------------------------");

        MyQueue myQueue = new MyQueue();
        myQueue.offer("Hello");
        myQueue.offer("from");
        myQueue.offer("Java");
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue);

        System.out.println("------------------------------------------------------");

        MyStack myStack = new MyStack();
        myStack.push("Hello");
        myStack.push("from");
        myStack.push("Java");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack);

        int[] unsorted = {5, 2, 3, 1, 8, 3, 6, 9, 1, 2, 4};

        System.out.println(Arrays.toString(bubbleSort(unsorted)));
    }

    private static int[] bubbleSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            count++;
            boolean wasChanged = false;
            for (int j = 0; j < result.length - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int tmp = result[j + 1];
                    result[j + 1] = result[j];
                    result[j] = tmp;
                    wasChanged = true;
                }
            }
            if (!wasChanged) {
                break;
            }
        }
        System.out.println(count);
        return result;
    }
}
