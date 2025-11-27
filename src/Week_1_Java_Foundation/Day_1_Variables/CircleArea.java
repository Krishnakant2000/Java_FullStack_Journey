package Week_1_Java_Foundation.Day_1_Variables;
import java.util.Scanner; // Import the Scanner class to read input

public class CircleArea {
    public static void main(String[] args) {

        // 1. Setup the "Scanner" to read from the keyboard (System.in)
        Scanner scanner = new Scanner(System.in);

        // 2. Ask the user for input
        System.out.print("Enter the radius of the circle: ");

        // 3. Store the input in a double (because radius can be decimal, e.g., 5.5)
        double radius = scanner.nextDouble();

        // 4. The Logic: Area = Pi * r * r
        // Math.PI is a built-in constant in Java
        double area = Math.PI * radius * radius;

        // 5. Output the result
        System.out.println("--- Results ---");
        System.out.println("Radius: " + radius);
        System.out.println("Calculated Area: " + area);

        // 6. Good practice: Close the scanner
        scanner.close();
    }
}
