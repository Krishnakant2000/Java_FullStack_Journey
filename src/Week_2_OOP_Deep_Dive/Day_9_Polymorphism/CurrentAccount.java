package Week_2_OOP_Deep_Dive.Day_9_Polymorphism;

public class CurrentAccount extends BankAccount {

    protected double overdraftLimit;

    public CurrentAccount(String name, double balance, double overdraftLimit) {
        super(name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // @Override ensures we are actually replacing the Parent's method
    // If we made a typo (e.g., "withDraw"), Java would warn us!
    @Override
    public void withdraw(double amount) {
        // Logic: You can withdraw if (Balance + Overdraft) covers the amount
        if (balance + overdraftLimit >= amount) {
            balance -= amount; // Balance can go negative!
            System.out.println(accountHolderName + " withdrew $" + amount + " (Overdraft used)");
        } else {
            System.out.println("Failed: Overdraft limit exceeded for " + accountHolderName);
        }
    }
}
