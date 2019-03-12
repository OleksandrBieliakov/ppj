package ppj.werner.e16.p1;

public class Product {

    private String name;
    private int quantity;

    public Product (String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getPrName() {
        return name;
    }

    public int getPrQ() {
        return quantity;
    }

}
