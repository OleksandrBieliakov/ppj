package ppj.additional.harrypotter;

public class Class16_ {

    public static void main(String[] args) {

        int amountOfHorcruxes = 8;
        Voldemort youKnowWho = new Voldemort(amountOfHorcruxes);

        String name = "Harry";
        String familiName = "Potter";
        RegularPerson harry = youKnowWho.killLily();

        Dumbledore albus = new Dumbledore();
        Wizard harryWizard = albus.youAreWizard(harry);

        while (youKnowWho.isAlive()) {
            harryWizard.destroyHorcrux(youKnowWho);
            harryWizard.tryToDefeat(youKnowWho);
        }

        System.out.println("Happy ending");

    }

}
