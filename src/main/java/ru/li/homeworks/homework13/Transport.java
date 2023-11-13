package ru.li.homeworks.homework13;

public abstract class Transport {
    protected String name;
    protected int energy;
    protected Terrain[] stopList;

    public abstract boolean move(int distance, Terrain terrain);

    public boolean terrainInStopList(Terrain terrain) {
        return false; //Arrays.contains(stopList, terrain);
    }
}
