package e16.p2;

public class Car {

    private String make;
    private int price;
    private Car next;

    public Car(String m, int p, Car n) {
        make = m;
        price = p;
        next = n;
    }
    public Car(String make, int price) {
        this.make = make;
        this.price = price;
        next = null;
    }

    public String getMake() { return make; }
    public int getPrice() { return price; }
    public Car getNext() { return next; }

    public void showCars() {
        System.out.print(make + "(" + price + ")" + " ");
        Car tmp = next;
        while (tmp != null) {
            System.out.print(tmp.make + "(" + tmp.price + ")" + " ");
            tmp = tmp.next;
        }
    }
    public void showCarsRev() {
        if(next != null) next.showCarsRev();
        System.out.print(make + "(" + price + ")" + " ");
    }
    @Override
    public String toString() {
        return make + "(" + price + ")" + " ";
    }

}
