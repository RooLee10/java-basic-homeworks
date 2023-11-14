package ru.li.homeworks.homework13;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human("Boris");
        Transport[] transports = {
                new Car(),
                new Horse(),
                new Bicycle(),
                new AllTerrainVehicle()
        };

        Terrain[] terrains = {
                Terrain.FLATLAND,
                Terrain.FOREST,
                Terrain.SWAMP,
        };

        for (Terrain terrain : terrains) {
            for (Transport transport : transports) {
                System.out.println("----------------------------------------");
                if (human.getCurrentTransport() == null) {
                    human.grabTransport(transport);
                }
                if (human.move(10, terrain)) {
                    break;
                }
                human.getRidOfTransport();
            }
        }
    }
}
