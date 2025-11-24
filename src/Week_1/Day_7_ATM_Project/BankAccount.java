package Week_1.Day_7_ATM_Project;

public class BankAccount {

    private double balance;
    private String name;

    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (balance > 0) {
            this.balance += amount;
            System.out.println("Success! Deposited $" + amount);
        }else  {
            System.out.println("Error! Deposited amount must be positive");
        }
    }

    public boolean withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Error: Insufficient Funds. Balance is $" + balance);
            return false;
        } else if (amount <= 0) {
            System.out.println("Error! Invalid Amount");
            return false;
        } else  {
            this.balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            return true;
        }
    }

}
