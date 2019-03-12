package ppj.e11.p2;

public class BankCustomer {

    private Person person;
    private Account account;

    public BankCustomer (Person person) {
        this.person = person;
        account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
      return "Customer: " + person.getName() + ", balance: " + account.getBalance();
    }
}
