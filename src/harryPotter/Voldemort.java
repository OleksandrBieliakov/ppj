package harryPotter;

public class Voldemort {

    private int amountOfHorcruxes;
    private boolean alive;

    public Voldemort (int amountOfHorcruxes) {
        this.amountOfHorcruxes = amountOfHorcruxes;
        alive = true;
    }

    public boolean isAlive(){
        return alive;
    }

    public void minusHorcrux(){
        if(amountOfHorcruxes > 0)
            --amountOfHorcruxes;
    }

    public void fight(){
        if(amountOfHorcruxes == 0)
            alive = false;
    }


    public RegularPerson killLily() {
        System.out.println("Sad situation...");
        return new RegularPerson();
    }

}
