package ru.li.homeworks.homework20;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8090)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            out.write("getAvailableOperations\n");
            out.flush();
            String AvailableOperations = in.readLine();
            System.out.println(AvailableOperations);

            System.out.println("Введите первое число: ");
            int firstNumber = scanner.nextInt();

            System.out.println("Введите операцию: ");
            String operation = scanner.nextLine(); // Почему-то проскакивает при первом вызове
            operation = scanner.nextLine(); // Только при втором вызове дает возможность ввести текст

            System.out.println("Введите второе число: ");
            int secondNumber = scanner.nextInt();

            out.write(firstNumber + " " + operation + " " + secondNumber + "\n");
            out.flush();

            String result = in.readLine();
            System.out.println(result);

            out.write("close\n");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
