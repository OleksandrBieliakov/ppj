package e14;

public class Patient {

    private String patient;

    public Patient (String name) {
        patient = name;
    }

    public String name() {
        return patient;
    }

    public String illness() {
        return "?";
    }

    public String treatment() {
        return "?";
    }

}
