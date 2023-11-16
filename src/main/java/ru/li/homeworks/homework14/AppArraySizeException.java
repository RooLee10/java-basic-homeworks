package ru.li.homeworks.homework14;

public class AppArraySizeException extends RuntimeException {

    public AppArraySizeException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Неверный размер массива.";
    }
}
