package ru.li.homeworks.homework28;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    private final static File RESOURCES = new File("src/main/resources");
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        File selectedFile = requestFile();
        String selectedSequence = requestSequence();
        countTheNumberOfOccurrences(selectedFile, selectedSequence);
    }

    private static void countTheNumberOfOccurrences(File file, String sequence) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ,.!?");
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    count += (word.length() - word.replaceAll(sequence, "").length()) / sequence.length();
                }
            }
            System.out.printf("Последовательность символов '%s' встречается %d раз(а)\n", sequence, count);
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

    private static File requestFile() {
        while (true) {
            printResources();

            String userInput = SCANNER.nextLine().trim();
            if (userInput.isEmpty()) {
                continue;
            }
            File selectedFile = new File(RESOURCES.getPath() + File.separator + userInput);
            if (!selectedFile.exists()) {
                System.out.println("Файл не найден");
                continue;
            }
            return selectedFile;
        }
    }

    private static void printResources() {
        System.out.println("---------------------------");
        System.out.println("Выберите файл:");
        File[] list = RESOURCES.listFiles((dir, name) -> name.endsWith(".txt"));
        for (File file : list) {
            System.out.println(file.getName());
        }
    }
}
