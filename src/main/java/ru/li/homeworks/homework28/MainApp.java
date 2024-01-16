package ru.li.homeworks.homework28;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {
    private final static File RESOURCES = new File("src/main/resources");
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("---------------------------");
            System.out.println("Выберите файл:");
            printResources();

            String userInput = SCANNER.nextLine();
            File selectedFile = new File(RESOURCES.getPath() + File.separator + userInput);
            if (!selectedFile.exists()) {
                System.out.println("Файл не найден");
                continue;
            }

            String selectedSequence = requestSequence();

            countTheNumberOfOccurrences(selectedFile, selectedSequence);
        }
    }

    private static void countTheNumberOfOccurrences(File file, String sequence) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Map<String, Integer> result = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                // Не стал обрабатывать строки (удалять точки, запятые и т.д.), так как нужно только показать основную идею
                String[] words = line.split(" ");
                for (String word : words) {
                    result.put(word, result.getOrDefault(word, 1) + 1);
                }
            }
            System.out.printf("Последовательность символов '%s' встречается %d раз\n", sequence, result.getOrDefault(sequence, 0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String requestSequence() {
        while (true){
            System.out.println("Укажите последовательность символов для поиска вхождений:");
            String sequence = SCANNER.nextLine();
            sequence = sequence.trim();
            if (sequence.isEmpty()) {
                continue;
            }
            if (sequence.split(" ").length > 1) {
                System.out.println("Последовательность символов должна быть одним словом");
                continue;
            }
            return sequence;
        }
    }

    private static void printResources() {
        File[] list = RESOURCES.listFiles((dir, name) -> name.endsWith(".txt"));
        for (File file : list) {
            System.out.println(file.getName());
        }
    }
}
