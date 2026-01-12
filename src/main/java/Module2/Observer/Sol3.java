package Module2.Observer;

import java.util.ArrayList;
import java.util.List;

interface stockListener1 {
    void stockUpdated(int stock);
}

class Webiste1 implements stockListener1{
    @Override
    public void stockUpdated(int stock) {
        System.out.println("Website : Burger stock updated to " + stock);
    }
}

class App1 implements stockListener1{
    @Override
    public void stockUpdated(int stock) {
        System.out.println("App : Burger stock updated to " + stock);
    }
}

class BurgerStock3 {
    private int stock = 0;
    private List<stockListener1> listeners = new ArrayList<>();

    void addListener(stockListener1 listener) {
        listeners.add(listener);
    }

    void setStock(int stock) {
        this.stock = stock;
        for (stockListener1 listener : listeners) {
            listener.stockUpdated(stock);
        }
    }
}

public class Sol3 {
    public static void main(String[] args) {
        BurgerStock3 burgerStock = new BurgerStock3();

        // Adding listeners
        burgerStock.addListener(new Webiste1());
        burgerStock.addListener(new App1());

        // Updating stock
        burgerStock.setStock(10);
        burgerStock.setStock(20);
        burgerStock.setStock(30);
    }
}

// Pros :
// - Follows Open/Closed Principle: New listeners can be added without modifying existing code.
// - Loose coupling: Listeners are added dynamically, allowing for greater flexibility and extensibility.
// - Easy to extend: New notification receivers can be added without changing the BurgerStock3 class.
// - Follows Dependency Inversion Principle: BurgerStock3 depends on the abstraction (stockListener1) rather than concrete implementations.


// Cons :
// Voilates Single Responsibility Principle: BurgerStock3 still manages both stock and listener management.
// - No built-in mechanism to remove listeners, which could lead to memory leaks if not managed properly.