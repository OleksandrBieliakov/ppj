package e16.p1;

public class Box {

    private String id;
    private Product[] prods;

    public Box (String id, Product[] prods) {
        this.id = id;
        this.prods = prods;
    }

    public String getBoxId() {
        return id;
    }

    public Product[] getProds() {
        return prods;
    }

}
