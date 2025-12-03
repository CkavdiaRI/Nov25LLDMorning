package Module1.Generics.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        items.add(new Book("1", "Java", 100, 10, "<NAME>"));
        items.add(new Electronics("2", "Laptop", 1000, 5, 24));
        items.add(new Clothing("3", "T-Shirt", 20, 50, "L"));

        // Before sorting
        System.out.println("Before sorting:");
        for (Item item : items) {
            System.out.println(item);
        }

        // Sort items by price
        Collections.sort(items);

        // After sorting
        System.out.println("\nAfter sorting by price:");
        for (Item item : items) {
            System.out.println(item);
        }

        // Comparator
        Comparator<Item> sortByPrice = (item1, item2) -> Double.compare(item1.getPrice(), item2.getPrice());
        Collections.sort(items, sortByPrice);
        System.out.println("\nAfter sorting by comparator:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
