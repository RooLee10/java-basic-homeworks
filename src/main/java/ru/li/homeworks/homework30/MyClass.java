package ru.li.homeworks.homework30;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {
    public int[] getArrayFromLastOne(int[] list) {
        List<Integer> searchList = Arrays.stream(list).boxed().collect(Collectors.toList());
        int index = searchList.lastIndexOf(1);
        if (index < 0) {
            throw new RuntimeException("В массиве чисел нет '1'");
        }
        List<Integer> resultList = searchList.subList(index + 1, searchList.size());
        return resultList.stream().mapToInt(Integer::intValue).toArray();
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
