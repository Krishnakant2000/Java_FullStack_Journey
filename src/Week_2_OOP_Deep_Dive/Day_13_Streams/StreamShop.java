package Week_2_OOP_Deep_Dive.Day_13_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamShop {
    public static void main(String[] args) {

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Laptop", 1200.00));
        catalog.add(new Product("Mouse", 25.00));
        catalog.add(new Product("Keyboard", 75.00));
        catalog.add(new Product("HDMI Cable", 10.00));
        catalog.add(new Product("Monitor", 300.00));

        System.out.println("---Full Catalog---");
        // .forEach() is a stream terminal operation to print everything
        catalog.forEach(product ->  System.out.println(product));

        // ---------------------------------------------------------
        // TASK 1: FILTERING
        // Goal: Find all products cheaper than $100 (Budget Friendly)
        // ---------------------------------------------------------
        System.out.println("\n--- Cheap Products (< $100) ---");
        List<Product> cheapProducts = catalog.stream()
                                            .filter(product -> product.price < 100)
                                            .collect(Collectors.toList());
        cheapProducts.forEach(System.out::println);
        // Note: System.out::println is a shortcut for p -> System.out.println(p)

        // ---------------------------------------------------------
        // TASK 2: TRANSFORMATION (MAPPING)
        // Goal: Get a list of ONLY the NAMES of expensive items, in UPPERCASE
        // ---------------------------------------------------------
        System.out.println("\n--- Expensive Item Names (UPPERCASE) ---");
        List<String> premiumProducts = catalog.stream().filter(product -> product.price >= 100)// 1. Filter high prices
                .map(p -> p.name.toUpperCase())   // 2. Extract Name & Uppercase it
                .sorted()                         // 3. Sort Alphabetically
                .collect(Collectors.toList());    // 4. Collect

        premiumProducts.forEach(System.out::println);

        // ---------------------------------------------------------
        // TASK 3: AGGREGATION
        // Goal: Calculate total cost of all items
        // ---------------------------------------------------------
        double totalValue = catalog.stream().mapToDouble(p -> p.price) // Convert stream to numbers
                .sum();                    // Sum them up

        System.out.println("\nTotal Inventory Value: $" + totalValue);
    }
}
