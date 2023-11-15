package ru.li.homeworks.homework13;

public class AllTerrainVehicle implements Transport {
    private int fuel;

    public AllTerrainVehicle() {
        this.fuel = 100;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        int cost = calculateEnergyCosts(distance);
        if (cost > fuel) {
            System.out.println("Не хватило топлива");
            return false;
        }
        System.out.println("Успешно преодолел местность " + terrain + " затратив " + cost + " л.");
        fuel -= cost;
        return true;
    }

    private int calculateEnergyCosts(int distance) {
        // 20 л/100 км
        return (int) (distance * 0.2);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (fuel=" + fuel + ")";
    }
}
