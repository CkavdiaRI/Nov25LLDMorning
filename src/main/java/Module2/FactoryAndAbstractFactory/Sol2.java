package Module2.FactoryAndAbstractFactory;

enum BurgerType {
    Veg,
    Cheese
}

interface Burger2 {
    void prepare();
}

class VegBurger2 implements Burger2{
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Burger");
    }
}

class CheeseBurger2 implements Burger2{
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Burger");
    }
}

class BurgerFactory2 {
    public static Burger2 createBurger(String burgerType) {
        if (burgerType.equals("Veg")) {
            return new VegBurger2();
        } else if (burgerType.equals("Cheese")) {
            return new CheeseBurger2();
        } else {
            throw new IllegalArgumentException("Unknown Burger Type");
        }
    }
}

public class Sol2 {
    public static void main(String[] args) {
        String burgerType = BurgerType.Veg.toString();
        Burger2 burger = BurgerFactory2.createBurger(burgerType);
    }
}

// pros :
// 1. Moved the burger creation logic to a separate factory class and decoupled it from the client code.

// cons :
// 1. Still requires modification of the factory class to add new burger types, which violates the Open/Closed Principle.
// 2. Still has if-else statements, which can lead to code that is hard to maintain and extend.
