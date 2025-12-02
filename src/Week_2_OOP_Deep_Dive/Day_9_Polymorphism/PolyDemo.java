package Week_2_OOP_Deep_Dive.Day_9_Polymorphism;

public class PolyDemo {

    static void main() {
        // 1. Parent Reference = Child Object
        // "myAccount" is declared as a BankAccount...
        BankAccount myAccount = new CurrentAccount("Tony Stark", 1000, 500);

        // 2. We call .withdraw()
        // Java decides AT RUNTIME which version to run.
        // Since the object is a CurrentAccount, it runs the OVERRIDDEN version.
        System.out.println("--- Scenario 1: Withdrawing within balance ---");
        myAccount.withdraw(500); // Balance becomes 500
        myAccount.showBalance();

        System.out.println("\n--- Scenario 2: Withdrawing into Overdraft ---");
        // Standard BankAccount would fail here (needs 500, has 500).
        // CurrentAccount allows it because of Overdraft (Limit 500).
        myAccount.withdraw(800); // Balance becomes -300
        myAccount.showBalance();

        System.out.println("\n--- Scenario 3: Exceeding Overdraft ---");
        myAccount.withdraw(1000); // Should fail
    }

}
