package ru.li.homeworks.homework14;

public class MainApp {
    public static void main(String[] args) {
        String[][] stringArray = getStringArray();
        try {
            int result = sumStringArray(stringArray);
            System.out.println("Сумма: " + result);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e + " " + e.getMessage());
        }
    }

    private static int sumStringArray(String[][] array) {
        if (array.length != 4) {
            throw new AppArraySizeException("Массив должен быть 4х4");
        }
        for (String[] element : array) {
            if (element.length != 4) {
                throw new AppArraySizeException("Массив должен быть 4х4");
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result += getIntFromString(array, i, j);
            }
        }
        return result;
    }

    private static int getIntFromString(String[][] array, int i, int j) {
        try {
            return Integer.parseInt(array[i][j]);
        } catch (NumberFormatException e) {
            String info = "array[" + i + "][" + j + "]";
            throw new AppArrayDataException(e.getMessage() + " " + info);
        }
    }

    private static String[][] getStringArray() {
        return new String[][]{
                {"0", "1", "3", "4"},
                {"5", "6", "7", "8"},
                {"0", "1", "3", "4"},
                {"5", "6", "7", "8"}
        };
    }
}
