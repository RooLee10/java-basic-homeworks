package ru.li.homeworks.homework17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        System.out.println("------------------------------------------------------");
        int[] unsorted = {5, 2, 3, 1, 8, 3, 6, 9, 1, 2, 4, 7, 1};
        System.out.println("unsorted: " + Arrays.toString(unsorted));

        System.out.println("bubbleSort: " + Arrays.toString(bubbleSort(unsorted)));
        System.out.println("quickSort: " + Arrays.toString(quickSort(unsorted)));
        System.out.println("mergeSort: " + Arrays.toString(mergeSort(unsorted)));
    }

    private static int[] bubbleSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length; i++) {
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
        return result;
    }

    private static int[] quickSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        int pivot = array[0];
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> middleArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                leftArray.add(array[i]);
            } else if (array[i] == pivot) {
                middleArray.add(array[i]);
            } else {
                rightArray.add(array[i]);
            }
        }
        int[] leftSorted = quickSort(leftArray.stream().mapToInt(i -> i).toArray());
        int[] rightSorted = quickSort(rightArray.stream().mapToInt(i -> i).toArray());
        List<Integer> result = new ArrayList<>();

        for (int number : leftSorted) {
            result.add(number);
        }
        for (int number : middleArray) {
            result.add(number);
        }
        for (int number : rightSorted) {
            result.add(number);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int start = 0;
        int middle = array.length / 2;
        int end = array.length;
        int[] a = new int[middle];
        int[] b = new int[end - middle];
        System.arraycopy(array, start, a, 0, middle);
        System.arraycopy(array, middle, b, 0, end - middle);

        int[] aSorted = mergeSort(a);
        int[] bSorted = mergeSort(b);

        int aElementsCount = aSorted.length;
        int bElementsCount = bSorted.length;
        int aPointer = 0;
        int bPointer = 0;

        List<Integer> result = new ArrayList<>();
        while (Math.min(aElementsCount, bElementsCount) > 0) {
            if (aSorted[aPointer] < bSorted[bPointer]) {
                result.add(aSorted[aPointer]);
                aPointer++;
                aElementsCount--;
            } else {
                result.add(bSorted[bPointer]);
                bPointer++;
                bElementsCount--;
            }
        }

        while (aElementsCount > 0) {
            result.add(aSorted[aPointer]);
            aPointer++;
            aElementsCount--;
        }
        while (bElementsCount> 0) {
            result.add(bSorted[bPointer]);
            bPointer++;
            bElementsCount--;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
