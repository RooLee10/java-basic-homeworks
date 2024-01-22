package ru.li.homeworks.homework30;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public int[] getArrayFromLastOne(int[] list) {
        // Манипуляции с ArrayList из-за того, что нет перегруженного метода assertArrayEquals для List<Integer>
        // только массивы с примитивами принимает
        List<Integer> resultList = new ArrayList<>();
        List<Integer> searchList = new ArrayList<>();
        for (int n : list) {
            searchList.add(n);
        }
        int index = searchList.lastIndexOf(1);
        if (index < 0) {
            throw new RuntimeException("В массиве чисел нет '1'");
        }
        for (int i = index + 1; i < searchList.size(); i++) {
            resultList.add(searchList.get(i));
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public boolean arrayContainsOnlyOneAndTwo(List<Integer> list) {
        if (list.isEmpty()) {
            return false;
        }
        if (!list.contains(1)) {
            return false; // должен содержать хотя бы одну 1
        }
        if (!list.contains(2)) {
            return false; // должен содержать хотя бы одну 2
        }
        for (int number : list) {
            if (number < 1 || number > 2) {
                return false; // должен содержать только 1 и 2
            }
        }
        return true;
    }
}
