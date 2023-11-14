package ru.li.homeworks.homework13;

public interface Transport {

    boolean move(int distance, Terrain terrain);

    default boolean terrainInStopList(Terrain terrain, Terrain[] stopList) {
        for (Terrain t : stopList) {
            if (t.equals(terrain)) {
                return true;
            }
        }
        return false;
    }
}
