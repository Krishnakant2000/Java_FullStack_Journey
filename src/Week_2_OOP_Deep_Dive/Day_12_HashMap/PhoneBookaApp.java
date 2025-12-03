package Week_2_OOP_Deep_Dive.Day_12_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookaApp {
    public static void main(String[] args) {

        HashMap<String, Long> phoneBook = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        // Pre-load some data
        phoneBook.put("Emergency", 112L);
        phoneBook.put("Service", 1800555L);

        boolean running = true;
        System.out.println("--- Digital Phonebook ---");

        while (running) {
            System.out.println("\n1. Add Contact | 2. Search Contact | 3. View All | 4. Exit");
            System.out.print("Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Phone Number: ");
                    Long phoneNumber = scan.nextLong();
                    phoneBook.put(name, phoneNumber);
                    System.out.println("Contact has been saved.");
                    break;
                case 2:
                    System.out.print("Who are you looking for? ");
                    String search = scan.nextLine();
                    if(phoneBook.containsKey(search)) {
                        System.out.println("Number : " + phoneBook.get(search));
                    }else  {
                        System.out.println("Contact doesn't exist.");
                    }
                    break;
                case 3:
                    System.out.println("---All Contacts ---");
                    for (Map.Entry<String, Long> entry : phoneBook.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }
        scan.close();
    }
}
