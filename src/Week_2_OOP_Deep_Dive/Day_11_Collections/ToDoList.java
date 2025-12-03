package Week_2_OOP_Deep_Dive.Day_11_Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    static void main() {

        ArrayList<String> toDoLists = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Task | 2. View Tasks | 3. Remove Task | 4. Exit");
            System.out.print("Action: ");
            int choice = input.nextInt();
            input.nextLine(); // Fix the "newline bug" after reading int

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = input.nextLine();
                    // .add() puts it at the end
                    toDoLists.add(task);
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.println("--- Your Tasks ---");
                    // .size() tells you how many items are currently in the list
                    if (toDoLists.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        for (int i = 0; i < toDoLists.size(); i++) {
                            // .get(i) retrieves the item at index i
                            System.out.println((i + 1) + ". " + toDoLists.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter task to remove: ");
                    int taskNum = input.nextInt();
                    if (taskNum > 0 && taskNum <= toDoLists.size()) {
                        toDoLists.remove(taskNum-1);
                        System.out.println("Task removed!");
                    }else {
                        System.out.println("Invalid task number.");
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
        input.close();
    }
}
