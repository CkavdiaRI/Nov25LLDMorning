package Module2.Observer;

class BurgerStock{
    private int stock = 0;

    public void setStock(int stock) {
        this.stock = stock;
        System.out.println("Website : Burger stock updated to " + stock);
        System.out.println("App : Burger stock updated to " + stock);
    }
}

public class SOl1 {
    public static void main(String[] args) {
        BurgerStock burgerStock = new BurgerStock();
        burgerStock.setStock(10);
        burgerStock.setStock(20);
        burgerStock.setStock(30);
    }
}

// Cons :
// Voilates the Single Responsibility Principle
// Voilates the Open/Closed Principle
// Tight coupling on the website and app (notification receivers)
// Selective notification not possible
// No easy way to add more notification receivers during runtime

// Pros :
// Simple implementation`