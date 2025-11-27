package Week_1_Java_Foundation.Day_3_Loops;

import java.util.Scanner;

public class Fibonacci {
    static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many Fibonacci numbers do you want to print? ");
        int n = sc.nextInt();

        int num1 = 0;
        int num2 = 1;

        System.out.println("Fibonacci Series of " + n + " numbers:");
        for (int i = 1; i <= n; i++) {
            System.out.print(num1 + " ");
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }

        sc.close();

    }
}
