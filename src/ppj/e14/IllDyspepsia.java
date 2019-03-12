package ppj.e14;

public class IllDyspepsia extends Patient{

    public IllDyspepsia (String name) {
        super(name);
    }

    @Override
    public String illness() {
        return "Dyspepsia";
    }

    @Override
    public String treatment() {
        return "coal";
    }

}
