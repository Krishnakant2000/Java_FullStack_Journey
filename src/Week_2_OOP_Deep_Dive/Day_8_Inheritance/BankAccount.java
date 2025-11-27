package Week_2_OOP_Deep_Dive.Day_8_Inheritance;

public class BankAccount {

    protected  String accountHolderName;
    protected double balance;

    public BankAccount(String name, double balance) {
        this.accountHolderName = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(accountHolderName + " deposited $" + amount);
        }
    }

    public void showBalance() {
        System.out.println(accountHolderName + "'s Balance: $" + balance);
    }

}
