package ppj.e14;

abstract public class Patient {

    private String name;

    public Patient (String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    abstract public String illness();

    abstract public String treatment();

}
