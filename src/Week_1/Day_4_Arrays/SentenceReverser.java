package Week_1.Day_4_Arrays;

import java.util.Scanner;

public class SentenceReverser {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence to be reversed: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");

        System.out.println("--- Reversed Sentence ---");

        for(int i=words.length-1;i>=0;i--) {
            System.out.print(words[i]+" ");
        }

        System.out.println();
        sc.close();

    }
}
