package Week_1.Day_7_ATM_Project;

import java.util.Scanner;

public class ATM {
    static void main() {
        Scanner input = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000.00, "Iron Man");
        boolean running = true;

        System.out.println("Welcome to the Console ATM!");
        System.out.println("User: Iron Man | ID: 998877");
        System.out.println("---------------------------");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Enter deposit amount: $");
                    double depAmount = input.nextDouble();
                    userAccount.deposit(depAmount);
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount: $");
                    double withdrawAmount = input.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using Console ATM. Goodbye!");
                    running = false;
                    break;
               default:
                    System.out.println("Invalid choice. Try again");
                    break;
            }
        }

        input.close();
    }
}
