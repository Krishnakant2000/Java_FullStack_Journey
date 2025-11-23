package Week_1.Day_3_Loops;

import java.util.Scanner;

public class PasswordCheck {
    static void main() {

        Scanner sc = new Scanner(System.in);
        String key = "";
        boolean flag;

        do {
            System.out.print("Set your password: ");
            String password = sc.nextLine();
            System.out.print("Confirm your password: ");
            String confirmPassword = sc.nextLine();
            if (!password.equals(confirmPassword)){
                System.out.println("Passwords do not match.. Please try again");
                flag = false;
            }else {
                System.out.println("Passwords match! Your password is: " + password);
                key = password;
                flag = true;
            }
        } while (!flag);

        System.out.print("Enter Your Password to enter the System: ");

        while (!sc.nextLine().equals(key)){
            System.out.println("Incorrect password.. Please try again");
            System.out.print("Re-enter your password: ");
        }


        System.out.print("You've successfully entered into the System");
        sc.close();

    }
}
