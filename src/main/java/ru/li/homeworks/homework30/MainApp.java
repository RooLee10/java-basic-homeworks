package ru.li.homeworks.homework30;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(Arrays.toString(myClass.getArrayFromLastOne(new int[]{2, 1, 2, 2})));
        System.out.println(myClass.arrayContainsOnlyOneAndTwo(Arrays.asList(1, 1)));
    }


}
