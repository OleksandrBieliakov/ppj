package e16.p1;

public class Storage {

    private Box[] boxes;

    public Storage (Box[] boxes) {
        this.boxes = boxes;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public int totQuant(String prName) {
        int count = 0;
        for (Box box : boxes) {
            for(Product product : box.getProds()) {
                if(product.getPrName().equals(prName))
                    count += product.getPrQ();
            }

        }
        return count;
    }

}
