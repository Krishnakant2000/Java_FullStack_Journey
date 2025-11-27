package Week_2_OOP_Deep_Dive.Day_8_Inheritance;

public class InheritanceDemo {

    static void main() {

        SavingsAccount mySavings = new SavingsAccount("Steve Rogers", 5000, 5.0);


        System.out.println("--- Inheritance in Action ---");

        mySavings.showBalance();
        mySavings.deposit(5000);

        mySavings.addInterest();

        mySavings.showBalance();


        CurrentAccount myCurrentAccount = new CurrentAccount("Tony Stark", 5000, 500);

        myCurrentAccount.showBalance();
        myCurrentAccount.deposit(1000);
        myCurrentAccount.showBalance();
        myCurrentAccount.overdraftLimit = 100;
        myCurrentAccount.checkOverdraftLimit(50);
    }
}
