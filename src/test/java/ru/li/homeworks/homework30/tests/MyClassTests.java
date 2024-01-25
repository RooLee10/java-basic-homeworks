package ru.li.homeworks.homework30.tests;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.li.homeworks.homework30.MyClass;

import java.util.Arrays;


public class MyClassTests {
    private MyClass myClass;

    @BeforeEach
    public void init() {
        myClass = new MyClass();
    }

    @Test
    public void testGetArrayFromLastOne() {
        int[] expected = {2, 2};
        int[] actual = {1, 2, 1, 2, 2};
        Assertions.assertArrayEquals(expected, myClass.getArrayFromLastOne(actual));
    }

    @Test
    public void testArrayContainsOnlyOneAndTwo() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(myClass.arrayContainsOnlyOneAndTwo(Arrays.asList(1, 2))),
                () -> Assertions.assertFalse(myClass.arrayContainsOnlyOneAndTwo(Arrays.asList(1, 1))),
                () -> Assertions.assertFalse(myClass.arrayContainsOnlyOneAndTwo(Arrays.asList(1, 3))),
                () -> Assertions.assertTrue(myClass.arrayContainsOnlyOneAndTwo(Arrays.asList(1, 2, 2, 1)))
        );
    }
}
