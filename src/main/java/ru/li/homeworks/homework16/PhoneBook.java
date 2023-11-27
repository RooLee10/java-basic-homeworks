package ru.li.homeworks.homework16;

import java.util.*;

public class PhoneBook {
    private HashMap<String, HashSet<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void add(String fio, String number) {
        if (!book.containsKey(fio)) {
            book.put(fio, new HashSet<>(Arrays.asList(number)));
            return;
        }
        book.get(fio).add(number);
    }

    public HashSet<String> find(String fio) {
        return book.get(fio);
    }

    public boolean containsPhoneNumber(String number) {
        Collection<HashSet<String>> values = book.values();
        for (HashSet<String> value : values) {
            if (value.contains(number)) {
                return true;
            }
        }
        return false;
    }
}
