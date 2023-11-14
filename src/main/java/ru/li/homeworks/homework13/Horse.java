package ru.li.homeworks.homework13;

import java.util.Arrays;

public class Horse implements Transport {
    private Terrain[] stopList;
    private int stamina;
    public Horse() {
        this.stamina = 100;
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
        return "Horse{" +
                "stopList=" + Arrays.toString(stopList) +
                ", stamina=" + stamina +
                '}';
    }
}
