package ru.li.homeworks.homework13;

import java.util.Arrays;

public class Bicycle implements Transport {
    private Terrain[] stopList;
    public Bicycle() {
        this.stopList = new Terrain[] {
                Terrain.SWAMP
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
        return "Bicycle{" +
                "stopList=" + Arrays.toString(stopList) +
                '}';
    }
}
