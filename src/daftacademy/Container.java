package daftacademy;

import java.util.Objects;

public class Container {

    private String from_country;
    private String to_country;
    private String id;
    private int weight;
    private String cargo_type;
    private String firm;
    private String firmName;
    private String firmCounty;
    private double price;

    public Container(String from_country, String to_country, String id, int weight, String cargo_type,
                     String firm, String firmName, String firmCounty, double price) {
        this.from_country = from_country;
        this.to_country = to_country;
        this.id = id;
        this.weight = weight;
        this.cargo_type = cargo_type;
        this.firm = firm;
        this.firmName = firmName;
        this.firmCounty = firmCounty;
        this.price = price;
    }

    public String getFrom_country() {
        return from_country;
    }

    public String getTo_country() {
        return to_country;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getCargo_type() {
        return cargo_type;
    }

    public String getFirm() {
        return firm;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getFirmCounty() {
        return firmCounty;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;
        Container container = (Container) o;
        return getWeight() == container.getWeight() &&
                Double.compare(container.getPrice(), getPrice()) == 0 &&
                Objects.equals(getFrom_country(), container.getFrom_country()) &&
                Objects.equals(getTo_country(), container.getTo_country()) &&
                Objects.equals(getId(), container.getId()) &&
                Objects.equals(getCargo_type(), container.getCargo_type()) &&
                Objects.equals(getFirm(), container.getFirm()) &&
                Objects.equals(getFirmName(), container.getFirmName()) &&
                Objects.equals(getFirmCounty(), container.getFirmCounty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom_country(), getTo_country(), getId(), getWeight(), getCargo_type(),
                getFirm(), getFirmName(), getFirmCounty(), getPrice());
    }

    @Override
    public String toString() {
        return "Container{" +
                "from_country='" + from_country + '\'' +
                ", to_country='" + to_country + '\'' +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                ", cargo_type='" + cargo_type + '\'' +
                ", firm='" + firm + '\'' +
                ", firmName='" + firmName + '\'' +
                ", firmCounty='" + firmCounty + '\'' +
                ", price=" + price +
                '}';
    }

}
