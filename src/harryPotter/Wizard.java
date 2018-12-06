package harryPotter;

public class Wizard {
    private RegularPerson person;

    public Wizard(RegularPerson person) {
        this.person = person;
    }

    public void destroyHorcrux(Voldemort youKnowWho) {
        youKnowWho.minusHorcrux();
    }

    public void tryToDefeat(Voldemort youKnowWho) {
        youKnowWho.fight();
    }
}
