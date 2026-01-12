package Module2.Observer;

import java.util.ArrayList;
import java.util.List;

// Observer design pattern is used to create a one-to-many dependency between objects so that when one object changes state,
// all its dependents are notified and updated automatically.

// Components of Observer Pattern:
// 1. Subject: The object that holds the state and notifies observers about changes.
// 2. Observer: The object that wants to be notified about changes in the subject's state.
// 3. ConcreteSubject: A concrete implementation of the subject that maintains a list of observers and notifies them.
// 4. ConcreteObserver: A concrete implementation of the observer that reacts to notifications from the subject.

// When to use Observer Pattern ?
// - When an object (subject) needs to notify multiple objects (observers) about changes in its state.

// Abstract Observer
interface stockListener3 {
    void stockUpdated(int stock);
}

// Concrete Observers
class Website3 implements stockListener3{
    @Override
    public void stockUpdated(int stock) {
        System.out.println("Website : Burger stock updated to " + stock);
    }
}

class App3 implements stockListener3{
    @Override
    public void stockUpdated(int stock) {
        System.out.println("App : Burger stock updated to " + stock);
    }
}

// Abstract Subject
interface Subject {
    void addListener(stockListener3 listener) ;
    void removeListener(stockListener3 listener) ;
    void notifyListeners() ;
}

// Concrete Subject
class BurgerStock4 implements Subject {
    private int stock = 0;
    private List<stockListener3> listeners = new ArrayList<>();

    @Override
    public void addListener(stockListener3 listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(stockListener3 listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyListeners() {
        for (stockListener3 listener : listeners) {
            listener.stockUpdated(stock);
        }
    }

    void setStock(int stock) {
        this.stock = stock;
        notifyListeners();
    }
}

public class Sol4 {
    public static void main(String[] args) {
        BurgerStock4 burgerStock = new BurgerStock4();
        // Adding listeners
        burgerStock.addListener(new Website3());
        burgerStock.addListener(new App3());

        // Updating stock
        burgerStock.setStock(10);
        burgerStock.setStock(20);

        // Removing a listener
        burgerStock.removeListener(new App3());
        burgerStock.setStock(30);
    }
}

