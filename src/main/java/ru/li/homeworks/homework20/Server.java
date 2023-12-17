package ru.li.homeworks.homework20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8090)) {
            while (true) { // для повторного запуска клиента без перезапуска сервера
                Socket clientSocket = serverSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String response;
                while (true) { // для обработки всех запросов от одного клиента
                    String message = in.readLine();

                    if (message.equals("getAvailableOperations")) {
                        response = "Доступные операции: + - / *\n";
                    } else if (message.equals("close")) {
                        clientSocket.close();
                        in.close();
                        out.close();
                        break;
                    } else {
                        response = calculate(message);
                    }
                    out.write(response);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String calculate(String message) {
        String[] data = message.split(" ");
        if (data.length != 3) {
            return "Unknown request\n";
        }
        try {
            int firstNumber = Integer.parseInt(data[0]);
            String operation = data[1];
            int secondNumber = Integer.parseInt(data[2]);

            int result;
            if (operation.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operation.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (operation.equals("/")) {
                result = firstNumber / secondNumber;
            } else if (operation.equals("*")) {
                result = firstNumber * secondNumber;
            } else {
                throw new RuntimeException();
            }
            return "Результат: " + result + "\n";
        } catch (RuntimeException e) {
            return "Unknown request\n";
        }
    }
}
