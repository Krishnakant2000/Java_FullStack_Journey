package Week_2_OOP_Deep_Dive.Day_8_Inheritance;

// "extends" means SavingsAccount IS A BankAccount
public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String name, double balance, double interestRate) {
        // "super" calls the Parent's constructor
        super(name, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        this.balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}
