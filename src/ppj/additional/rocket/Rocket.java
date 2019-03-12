package ppj.additional.rocket;

public class Rocket {
    private Computer computer1;
    private Computer computer2;

    public Rocket() {
        computer1 = new Computer(1);
        computer2 = new Computer(10);
    }

    public void start() throws ComputerErrorException {
        System.out.println("Start");
        int attitude1 = 0;
        int attitude2 = 0;
        while (attitude1 < 10000 && attitude2 < 10000) {
            attitude1 = computer1.getAttitude();
            attitude2 = computer2.getAttitude();
            System.out.println();
        }
            if(attitude1 != attitude2)
                throw new ComputerErrorException();
        System.out.println("Stopped");
    }

}
