package Module2.Observer;

interface stockListener {
    void stockUpdated(int stock);
}

class Website implements stockListener{
    @Override
    public void stockUpdated(int stock) {
        System.out.println("Website : Burger stock updated to " + stock);
    }
}

class App implements stockListener{
    @Override
    public void stockUpdated(int stock) {
        System.out.println("App : Burger stock updated to " + stock);
    }
}

class BurgerStock2 {
    private int stock = 0;
    stockListener website = new Website();
    stockListener app = new App();

    void setStock(int stock) {
        this.stock = stock;
        website.stockUpdated(stock);
        app.stockUpdated(stock);
    }
}

public class Sol2 {
    public static void main(String[] args) {
        BurgerStock2 burgerStock = new BurgerStock2();
        burgerStock.setStock(10);
        burgerStock.setStock(20);
        burgerStock.setStock(30);
    }
}

// Pros :
// - Better separation of concerns
// - Modular design

// Cons :
// - Still hardcoded dependencies on website and app
// Tight coupling between BurgerStock2 and its listeners
// Voilates the Open/Closed Principle
// Voilates the Dependency Inversion Principle
// No runtime flexibility to add/remove listeners
