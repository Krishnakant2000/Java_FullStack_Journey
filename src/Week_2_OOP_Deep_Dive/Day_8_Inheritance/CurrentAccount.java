package Week_2_OOP_Deep_Dive.Day_8_Inheritance;

public class CurrentAccount extends BankAccount {

    protected double overdraftLimit;

    public CurrentAccount(String name, double balance, double overdraftLimit) {
        super(name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void checkOverdraftLimit(double limit) {
        if (overdraftLimit > limit) {
            System.out.println("Overdraft available. Limit upto $ " + overdraftLimit);
        }  else  {
            System.out.println("Overdraft is unavailable.");
        }
    }
}
