package pointedtasks.ppja26.t4and5;

import java.io.Serializable;

public class Fruit implements Serializable {

    private String name;
    private int seedNumber;
    private Fruit next;

    public Fruit(String name, int n, Fruit next) {
        this.name = name;
        seedNumber = n;
        this.next = next;
    }

    public Fruit(String name, int n) {
        this.name = name;
        seedNumber = n;
    }

    public Fruit getNext() {
        return next;
    }

    @Override
    public String toString() {
        return name + " " + seedNumber;
    }

}
