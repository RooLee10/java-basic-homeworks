package ru.li.homeworks.homework13;

import java.util.Arrays;

public class Bicycle implements Transport {
    private final Terrain[] stopList;
    private Human wheelman;

    public Bicycle() {
        this.stopList = new Terrain[] {
                Terrain.SWAMP
        };
    }

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
        if (cost > wheelman.getStamina()) {
            System.out.println("Не хватило выносливости");
            return false;
        }
        System.out.println("Успешно преодолел местность " + terrain + " затратив " + cost + " в.");
        wheelman.setStamina(wheelman.getStamina() - cost);
        return true;
    }

    public boolean terrainInStopList(Terrain terrain) {
        for (Terrain t : stopList) {
            if (t.equals(terrain)) {
                return true;
            }
        }
        return false;
    }

    private int calculateEnergyCost(int distance) {
        // 100 в/100 км
        return distance;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (stopList=" + Arrays.toString(stopList) + ")";
    }
}
