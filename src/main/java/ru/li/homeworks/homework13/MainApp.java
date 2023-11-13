package ru.li.homeworks.homework13;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human("Boris");
        Transport[] transports = {
                new Car(),
        };

        Terrain[] terrains = {
                new Forest(),
                new Swamp(),
                new Flatland(),
        };

        for (Terrain terrain : terrains) {
            for (Transport transport: transports) {
                human.grabTransport(transport);
                if (!human.move(10, terrain)) {
                    human.getRidOfTransport();
                }
//                human.move()
            }

        }

    }
}
