package Week_2_OOP_Deep_Dive.Day_10_Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivision {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Division Calculator ---");

        try {
            // RISKY ZONE STARTS
            System.out.print("Enter number A: ");
            int a = sc.nextInt(); // Risk 1: User types "abc"

            System.out.print("Enter number B: ");
            int b = sc.nextInt(); // Risk 1 again

            // Risk 2: Division by Zero
            int result = a / b;

            System.out.println("Result: " + result);
            // RISKY ZONE ENDS
        } catch (ArithmeticException e) {
            // Specific Handler for Math Errors
            System.out.println("Error: You cannot divide by Zero!");
        } catch (InputMismatchException e) {
            // Specific Handler for Input Errors
            System.out.println("Error: Please enter WHOLE NUMBERS only.");

        } catch (Exception e) {
            // General Handler (Catch-all for anything else)
            System.out.println("Error: Something went wrong. Details: " + e.getMessage());

        } finally {
            // CLEANUP ZONE
            // This runs whether the code succeeded OR failed.
            System.out.println("--- Calculation Cycle Finished ---");
            sc.close();
        }
    }
}
