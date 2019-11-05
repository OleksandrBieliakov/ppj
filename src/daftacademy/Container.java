package daftacademy;

import java.util.Objects;

public class Container {

    private String fromCountry;
    private String toCountry;
    private String id;
    private int weight;
    private String cargoType;
    private String firm;
    private String firmName;
    private String firmCounty;
    private double price;

    public Container(String from_country, String to_country, String id, int weight, String cargo_type,
                     String firm, String firmName, String firmCounty, double price) {
        this.fromCountry = from_country;
        this.toCountry = to_country;
        this.id = id;
        this.weight = weight;
        this.cargoType = cargo_type;
        this.firm = firm;
        this.firmName = firmName;
        this.firmCounty = firmCounty;
        this.price = price;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getCargoType() {
        return cargoType;
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
                Objects.equals(getFromCountry(), container.getFromCountry()) &&
                Objects.equals(getToCountry(), container.getToCountry()) &&
                Objects.equals(getId(), container.getId()) &&
                Objects.equals(getCargoType(), container.getCargoType()) &&
                Objects.equals(getFirm(), container.getFirm()) &&
                Objects.equals(getFirmName(), container.getFirmName()) &&
                Objects.equals(getFirmCounty(), container.getFirmCounty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFromCountry(), getToCountry(), getId(), getWeight(), getCargoType(),
                getFirm(), getFirmName(), getFirmCounty(), getPrice());
    }

    @Override
    public String toString() {
        return "Container{" +
                "from_country='" + fromCountry + '\'' +
                ", to_country='" + toCountry + '\'' +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                ", cargo_type='" + cargoType + '\'' +
                ", firm='" + firm + '\'' +
                ", firmName='" + firmName + '\'' +
                ", firmCounty='" + firmCounty + '\'' +
                ", price=" + price +
                '}';
    }

}
