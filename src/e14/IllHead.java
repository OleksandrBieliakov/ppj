package e14;

public class IllHead extends Patient {

    public IllHead (String name) {
        super(name);
    }

    @Override
    public String illness() {
        return "head";
    }

    @Override
    public String treatment() {
        return "aspirin";
    }

}
