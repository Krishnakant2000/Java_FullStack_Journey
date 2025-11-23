package Week_1.Day_2_ControlWorkflow;
import java.util.Scanner;

public class GradeCalculator {

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your score (0-100): ");
        int score = sc.nextInt();

        // First, we check for "Sanity" - is the number valid?
        if (score < 0 || score > 100) {
            System.out.println("Error: Invalid score. Please enter 0-100.");
        }
        // If valid, check grades from top to bottom
        else if (score >= 90) {
            System.out.println("Excellent! You got an A.");
        }
        else if (score >= 80) {
            System.out.println("Good job. You got a B.");
        }
        else if (score >= 70) {
            System.out.println("You got a C.");
        }
        else {
            System.out.println("You failed. Grade: F");
        }

        sc.close();

    }
}
