package e11.p2;

public class Account {

    private double balance;
    private static double rate;

    public double getBalance() {
        return balance;
    }

    public void doDeposit(double sum) {
        if(sum < 0)
            throw new IllegalArgumentException("The sum of a deposit cannot be negative.");
        balance += sum;
    }

    public void doWithdraw(double sum) {
        if(sum < 0)
            throw new IllegalArgumentException("The sum of a withdraw cannot be negative.");
        if(sum > balance)
            throw new IllegalArgumentException("The requested sum exceeds the available funds.");
        balance -= sum;
    }

    public void deposit(double sum) {
        try {
            doDeposit(sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double sum) {
        try {
            doWithdraw(sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transfer (Account account, double sum) {
        try {
            this.doWithdraw(sum);
            account.doDeposit(sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setInterestRate(double r) {
        rate = r;
    }

    public void addInterest() {
        balance *= (1 + rate/100);
    }

}
