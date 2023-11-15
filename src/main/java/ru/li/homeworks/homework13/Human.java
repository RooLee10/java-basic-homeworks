package ru.li.homeworks.homework13;

public class Human {
    private final String name;
    private Transport currentTransport;
    private int stamina;

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public Human(String name) {
        this.name = name;
        this.stamina = 100;
    }

    public boolean move(int distance, Terrain terrain) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrain);
        }
        int cost = calculateEnergyCost(distance);
        if (cost > stamina) {
            System.out.println("Не хватило выносливости");
            return false;
        }
        System.out.println(name + " прошел пешком расстояние " + distance + " по местности " + terrain + " затратив " + cost + " в.");
        stamina -= cost;
        return true;
    }

    private int calculateEnergyCost(int distance) {
        // 100 в/25 км
        return distance * 4;
    }

    public void grabTransport(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже вледеет транспортом: " + currentTransport);
            return;
        }
        this.currentTransport = transport;
        if (transport instanceof Bicycle) {
            ((Bicycle) transport).setWheelman(this); // для траты силы водителя
        }
        System.out.println(name + " завладел транспортом: " + transport);
    }

    public void getRidOfTransport() {
        if (currentTransport == null) {
            System.out.println(name + " и так идет пешком..");
            return;
        }
        System.out.println(name + " избавился от транспорта: " + currentTransport);
        if (currentTransport instanceof Bicycle) {
            ((Bicycle) currentTransport).setWheelman(null); // удаляем водителя
        }
        this.currentTransport = null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " (name='" + name + '\'' +
                ", currentTransport=" + currentTransport +
                ", stamina=" + stamina + ")";
    }
}
