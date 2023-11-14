package ru.li.homeworks.homework13;

import java.util.Arrays;

public class AllTerrainVehicle implements Transport {
    private int fuel;

    public AllTerrainVehicle() {
        this.fuel = 100;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        System.out.println("Успешно преодолел местность (" + terrain + ")");
        return true;
    }

    @Override
    public String toString() {
        return "AllTerrainVehicle{" +
                "fuel=" + fuel +
                '}';
    }
}
