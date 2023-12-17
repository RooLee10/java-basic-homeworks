package ru.li.homeworks.homework19;

import java.io.*;
import java.util.Scanner;

public class MainApp {
    private static File file;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        file = new File("." + File.separator);
        printTheFileOrDirectory();

        while (true) {
            String userInput = getNavigation();
            processUserInput(userInput);
            printTheFileOrDirectory();
        }
    }

    private static void processUserInput(String userInput) {
        File newFile = new File(file. getPath() + File.separator + userInput);
        if (!newFile.exists()) {
            System.out.println("Указано неверное имя каталога/файла. Вот список:");
            return;
        }
        file = newFile;
        if (file.isFile()) {
            printTheFileOrDirectory();
            System.out.println("Введите текст добавления в файл. Для выхода из файла введите '#close': ");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath(), true))) {

                String text;
                while (true) {
                    text = SCANNER.nextLine();
                    if (text.equals("#close")) {
                        break;
                    }
                    bw.write(text + "\n");
                }

                file = file.getParentFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String getNavigation() {
        System.out.print("Введите имя каталога или файла. Для перехода на уровень выше используйте '..': ");
        return SCANNER.nextLine();
    }

    private static void printTheFileOrDirectory() {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String fileName : list) {
                System.out.println(fileName);
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
