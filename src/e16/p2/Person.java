package e16.p2;

public class Person {

    private String name;
    private Car cars;

    public Person(String name) {
        this.name = name;
        cars = null;
    }
    public Person buys(String make, int price) {
        cars = new Car(make, price, cars);
        return this;
    }

    public String getName() { return name; }
    public void showCars() { cars.showCars(); }
    public void showCarsRev() { cars.showCarsRev(); }

    public int getTotalPrice() {
        int sum = cars.getPrice();
        Car tmp = cars.getNext();
        while(tmp != null) {
            sum += tmp.getPrice();
            tmp = tmp.getNext();
        }
        return sum;
    }
    public boolean hasCar(String make) {
        if(make.equalsIgnoreCase(cars.getMake()))
            return true;
        Car tmp = cars.getNext();
        while(tmp != null) {
            if(make.equalsIgnoreCase(tmp.getMake()))
                return true;
            tmp = tmp.getNext();
        }
        return false;
    }
    public Car mostExpensive() {
        if(cars == null) return null;
        Car mostE = cars;
        int p = cars.getPrice();
        Car tmp = cars.getNext();
        while(tmp != null) {
            if(p < tmp.getPrice()){
                mostE = tmp;
                p = tmp.getPrice();
            }
            tmp = tmp.getNext();
        }
        return mostE;
    }

}
