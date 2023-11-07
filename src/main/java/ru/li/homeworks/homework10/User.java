package ru.li.homeworks.homework10;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private int yearBirth;
    private String email;


    public User(String surname, String name, String patronymic, int yearBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public void printInfo() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic);
        System.out.println("Год рождения: " + yearBirth);
        System.out.println("email: " + email);
    }

    public int getCurrentAge(int currentYear) {
        return currentYear - yearBirth;
    }
}
