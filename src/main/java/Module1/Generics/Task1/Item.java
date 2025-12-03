package Module1.Generics.Task1;

//Milestone 1: Item Class Hierarchy
//
//Objective: Create a class hierarchy to represent different item types.
//
//Tasks:
//
//Create Base Class Item:
//
//Define common attributes:
//
    //String id (unique identifier).
    //String name (name of the item).
    //
    //double price (price of the item).
    //
    //int quantity (quantity in stock).
    //
    //Implement constructors and getter/setter methods.

//Create Subclasses for Specific Item Types:
        //
        //Electronics: Add int warranty attribute.
        //
//        Clothing: Add String size attribute.
        //
        //Book: Add String author attribute.
        //
//Implement Comparable<Item> Interface:
//
//Learning Resource: Comparable Interface in Java with Examples - Scaler Topics
//
//Write a compareTo method to sort items alphabetically by price.
//
//Write a Test Program for Subclasses:
//
//Instantiate a few items for each subclass.
//Add them to a list and test sorting by price.


public class Item implements Comparable<Item>{
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Item other) {
//        if(this.price < other.price) {
//            return -1;
//        } else if(this.price > other.price) {
//            return 1;
//        } else {
//            return 0;
//        }
        return 0;
    }

}

// Comparable interface implementation to sort items by price
// CompareTo method compares the price of two items
// Return -1 if this item's price is less than the other item's price
// Return 1 if this item's price is greater than the other item's price
// Return 0 if both prices are equal

// Comparator
// Comparator<Item> sortByPrice = (item1, item2) -> Double.compare(item1.getPrice(), item2.getPrice());
// Comparator compares two items by their price using Double.compare method
// Comparator is better than Comparable as it allows multiple sorting criteria without modifying the Item class
