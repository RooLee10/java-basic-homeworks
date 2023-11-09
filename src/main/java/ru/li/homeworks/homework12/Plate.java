package ru.li.homeworks.homework12;

public class Plate {
    private final int maximumAmountFood;
    private int currentAmountFood;


    public Plate(int maximumAmountFood) {
        this.maximumAmountFood = maximumAmountFood;
        this.currentAmountFood = maximumAmountFood;
    }

    public void addFood(int amount) {
        if (amount == 0) {
            System.out.println("Я сделаю вид что добавил еду..");
            return;
        }
        if (currentAmountFood + amount > maximumAmountFood) {
            System.out.println("Не удалось добавить еды, в тарелке мало места.");
            return;
        }
        currentAmountFood += amount;
        System.out.println("Добавили еды");
    }

    public boolean decreaseFood(int amount) {
        if (currentAmountFood - amount < 0) {
            return false;
        }
        currentAmountFood -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Тарелка: " + currentAmountFood + "/" + maximumAmountFood;
    }
}
