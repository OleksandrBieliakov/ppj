package ppj.werner.e14;

public class IllLeg extends Patient {

    public IllLeg (String name) {
        super(name);
    }

    @Override
    public String illness() {
        return "leg";
    }

    @Override
    public String treatment() {
        return "plaster";
    }

}
