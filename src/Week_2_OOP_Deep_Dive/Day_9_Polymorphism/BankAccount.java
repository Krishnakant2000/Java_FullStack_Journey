package Week_2_OOP_Deep_Dive.Day_9_Polymorphism;

public class BankAccount {

    protected  String accountHolderName;
    protected double balance;

    public BankAccount(String name, double balance) {
        this.accountHolderName = name;
        this.balance = balance;
    }

    public void showBalance() {
        System.out.println(accountHolderName + "'s Balance: $" + balance);
    }

    // STANDARD WITHDRAWAL (No Overdraft)
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolderName + " withdrew $" + amount);
        } else {
            System.out.println("Failed: Insufficient funds for " + accountHolderName);
        }
    }

}
