package ru.li.homeworks.homework13;

import java.util.Arrays;

public class Horse implements Transport {
    private final Terrain[] stopList;
    private int stamina;
    private Human wheelman;

    public Horse() {
        this.stamina = 100;
        this.stopList = new Terrain[]{
                Terrain.SWAMP
        };
    }

    @Override
    public void setWheelman(Human wheelman) {
        this.wheelman = wheelman;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrainInStopList(terrain)) {
            System.out.println("Эта местность мне не по зубам.. (" + terrain + ")");
            return false;
        }
        int cost = calculateEnergyCost(distance);
        if (cost > stamina) {
            System.out.println("Не хватает выносливости");
            return false;
        }
        System.out.println("Успешно преодолел местность " + terrain + " затратив " + cost + " в.");
        stamina -= cost;
        return true;
    }

    private int calculateEnergyCost(int distance) {
        // 100 в/50 км
        return distance * 2;
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
        return getClass().getSimpleName() + " (stopList=" + Arrays.toString(stopList) + ", stamina=" + stamina + ")";
    }
}
