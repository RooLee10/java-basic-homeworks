package ru.li.homeworks.homework13;

public class Car extends Transport {

    public Car() {
        this.name = "Машина";
        this.energy = 100;
        this.stopList = new Terrain[] {
                new Forest(),
                new Swamp(),
        };
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrainInStopList(terrain)) {
            System.out.println("Эта местность мне не по зубам.. (" + terrain + ")");
            return false;
        }
        System.out.println("Успешно преодолел местность (" + terrain + ")");
        return true;
    }

    @Override
    public String toString() {
        return name + " " + energy;
    }
}
