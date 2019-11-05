package daftacademy;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Ship {

    private int id;
    private String name;
    private String category;
    private List<Container> containers = new LinkedList<>();

    public Ship(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void addContainer(Container container) {
        containers.add(container);
    }

    public int numberOfContainers() {
        return containers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return getId() == ship.getId() &&
                Objects.equals(getName(), ship.getName()) &&
                Objects.equals(getCategory(), ship.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory());
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}
