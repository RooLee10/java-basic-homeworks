package ru.li.homeworks.homework14;

public class AppArrayDataException extends RuntimeException {

    public AppArrayDataException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Неверный формат данных.";
    }
}
