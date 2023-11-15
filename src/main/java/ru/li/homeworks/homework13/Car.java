package ru.li.homeworks.homework13;

import java.util.Arrays;

public class Car implements Transport {
    private int fuel;
    private final Terrain[] stopList;
    public Car() {
        this.fuel = 100;
        this.stopList = new Terrain[] {
                Terrain.FOREST,
                Terrain.SWAMP,
        };
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrainInStopList(terrain)) {
            System.out.println("Эта местность мне не по зубам.. (" + terrain + ")");
            return false;
        }
        int cost = calculateEnergyCost(distance);
        if (cost > fuel) {
            System.out.println("Не хватило топлива");
            return false;
        }
        System.out.println("Успешно преодолел местность " + terrain + " затритив " + cost + " л.");
        fuel -= cost;
        return true;
    }

    private int calculateEnergyCost(int distance) {
        // 10 л/100 км
        return (int) (distance * 0.1);
    }

    public boolean terrainInStopList(Terrain terrain) {
        for (Terrain t : stopList) {
            if (t.equals(terrain)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (fuel=" + fuel +", stopList=" + Arrays.toString(stopList) + ")";
    }
}
