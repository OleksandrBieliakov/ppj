package e11.p2;

public class Account {

    private double balance;
    private static double rate;

    public double getBalance() {
        return balance;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        balance -= sum;
    }

    public void transfer (Account account, double sum) {
        this.withdraw(sum);
        account.deposit(sum);
    }

    public static void setInterestRate(double r) {
        rate = r;
    }

    public void addInterest() {
        balance *= (1 + rate/100);
    }




}
