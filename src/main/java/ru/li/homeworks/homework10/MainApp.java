package ru.li.homeworks.homework10;

public class MainApp {
    public static void main(String[] args) {
        User[] users = getUsers();
        int currentYear = 2023;
        for (User user : users) {
            if (user.getCurrentAge(currentYear) > 40) {
                user.printInfo();
            }
        }
    }

    private static User[] getUsers() {
        User[] users = new User[10];
        users[0] = new User("Кабанов", "Леонид", "Куприянович", 1980, "CharlesSanchez@example.com");
        users[1] = new User("Архипова", "Гертруда", "Филатовна", 1980, "DavidLloyd@example.com");
        users[2] = new User("Никонов", "Максим", "Агафонович", 1991, "KennethAustin@example.com");
        users[3] = new User("Кириллова", "Милена", "Никитевна", 1985, "HaroldMorris@example.com");
        users[4] = new User("Баранов", "Влас", "Давидович", 1977, "JamesFord@example.com");
        users[5] = new User("Фомичёва", "Франсуаза", "Эдуардовна", 1965, "GaryTaylor@example.com");
        users[6] = new User("Русакова", "Сусанна", "Мэлоровна", 1999, "RobertCain@example.com");
        users[7] = new User("Михеев", "Даниил", "Тимурович", 2001, "StephenBrady@example.com");
        users[8] = new User("Калашников", "Роберт", "Германнович", 1952, "NelsonJohnson@example.com");
        users[9] = new User("Рябова", "Альвина", "Алексеевна", 1996, "CoryMurphy@example.com");
        return users;
    }


}
