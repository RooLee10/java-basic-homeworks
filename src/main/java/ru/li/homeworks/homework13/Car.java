package ru.li.homeworks.homework13;

import java.util.Arrays;

public class Car implements Transport {
    private int fuel;
    private Terrain[] stopList;
    public Car() {
        this.fuel = 100;
        this.stopList = new Terrain[] {
                Terrain.FOREST,
                Terrain.SWAMP,
        };
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrainInStopList(terrain, stopList)) {
            System.out.println("Эта местность мне не по зубам.. (" + terrain + ")");
            return false;
        }
        System.out.println("Успешно преодолел местность (" + terrain + ")");
        return true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuel=" + fuel +
                ", stopList=" + Arrays.toString(stopList) +
                '}';
    }
}
