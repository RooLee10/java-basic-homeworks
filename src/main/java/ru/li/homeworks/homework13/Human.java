package ru.li.homeworks.homework13;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public boolean move(int distance, Terrain terrain) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrain);
        }
        System.out.println(name + " прошел пешком расстояние " + distance + " по местности " + terrain);
        return true;
    }

    public void grabTransport(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже вледеет транспортом: " + currentTransport);
            return;
        }
        this.currentTransport = transport;
        System.out.println(name + " завладел транспортом: " + transport);
    }

    public void getRidOfTransport() {
        if (currentTransport == null) {
            System.out.println(name + " и так идет пешком..");
            return;
        }
        System.out.println(name + " избавился от транспорта: " + currentTransport);
        this.currentTransport = null;
    }

}
