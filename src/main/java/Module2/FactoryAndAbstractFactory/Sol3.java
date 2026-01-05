package Module2.FactoryAndAbstractFactory;

interface Burger3 {
    void prepare();
}

class VegBurger3 implements Burger3 {
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Burger");
    }
}

class CheeseBurger3 implements Burger3 {
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Burger");
    }
}

class MexicanBurger3 implements Burger3 {
    @Override
    public void prepare() {
        System.out.println("Preparing Mexican Burger");
    }
}

// Factory selector can be implemented here if needed

// Abstract Factory
abstract class BurgerFactory3 {
    abstract Burger3 createBurger();

    public void orderBurger(){
        Burger3 burger = createBurger();
        burger.prepare();
        System.out.println("Burger ordered successfully!");
    }
}

// Concrete factory classes
class VegBurgerFactory3 extends BurgerFactory3 {
    @Override
    Burger3 createBurger() {
        return new VegBurger3();
    }
}

// Concrete factory classes
class CheeseBurgerFactory3 extends BurgerFactory3 {
    @Override
    Burger3 createBurger() {
        return new CheeseBurger3();
    }
}

// Concrete factory classes
class MexicanBurgerFactory3 extends BurgerFactory3 {
    @Override
    Burger3 createBurger() {
        return new MexicanBurger3();
    }
}


public class Sol3 {
    public static void main(String[] args) {
        BurgerFactory3 vegFactory = new VegBurgerFactory3();
        vegFactory.orderBurger();
    }
}


// Pros :
// 1. Adheres to the Open/Closed Principle - new burger types can be added without modifying existing code.
// 2. Encapsulates the burger creation logic within factory classes, promoting single responsibility.
// 3. Client code is decoupled from the concrete burger implementations, relying on abstractions.
// 4. Cleaner interface for creating burgers, as the client only interacts with the factory and burger interfaces.
// 5. Easy to extend and maintain

// Cons :
// Client still needs to be aware of which factory to use for which burger type. -> Soln ->  Factory selector class