package ru.li.homeworks.homework16;

public class MainApp {
    public static void main(String[] args) {
        PhoneBook book = getPhoneBook();
        System.out.println("метод find: " + book.find("fio3"));
        System.out.println("метод containsPhoneNumber: " + book.containsPhoneNumber("2222222"));
    }

    private static PhoneBook getPhoneBook() {
        PhoneBook book = new PhoneBook();
        book.add("fio1", "1111111");
        book.add("fio1", "2222222");
        book.add("fio1", "3333333");
        book.add("fio2", "4444444");
        book.add("fio3", "5555555");
        return book;
    }
}
