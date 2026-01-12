package Module2.Strategy;

// Strategy design pattern :
// It is a behavioral design pattern that enables selecting an algorithm's behavior at runtime.
// It defines a family of algorithms, encapsulates each one, and makes them interchangeable within that family.

// Components of Strategy Pattern:
// 1. Strategy: An interface that defines a common method for all supported algorithms.
// 2. Concrete Strategies: Classes that implement the Strategy interface, each providing a different algorithm.
// 3. Context: A class that uses a Strategy to execute the algorithm. It maintains a reference to a Strategy object and can change it at runtime.

// When to use Strategy Pattern ?
// - When you have multiple algorithms for a specific task and want to switch between them dynamically.
// - When you want to avoid conditional statements for selecting algorithms.

// Context
class Navigation4{
    private RouteStrategy2 routeStrategy;

//    Navigation4(RouteStrategy routeStrategy) {
//        this.routeStrategy = routeStrategy;
//    }

    public void setRouteStrategy(RouteStrategy2 routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void navigate() {
        if (routeStrategy != null) {
            routeStrategy.calculate();
        } else {
            System.out.println("Please choose a valid route type.");
        }
    }
}

// Abstract Strategy
interface RouteStrategy2 {
    void calculate();
}

// Concrete Strategies
class FastestRoute2 implements RouteStrategy2 {
    public void calculate() {
        System.out.println("Calculating the fastest route...");
    }
}

class ShortestRoute2 implements RouteStrategy2 {
    public void calculate() {
        System.out.println("Calculating the shortest route...");
    }
}

class AvoidTollsRoute2 implements RouteStrategy2 {
    public void calculate() {
        System.out.println("Calculating the avoid tolls route...");
    }
}

class ScenicRoute2 implements RouteStrategy2 {
    public void calculate() {
        System.out.println("Calculating the scenic route...");
    }
}

public class Sol4 {
    public static void main(String[] args) {
        Navigation4 navigation = new Navigation4();

        navigation.setRouteStrategy(new FastestRoute2());
        navigation.navigate();

        navigation.setRouteStrategy(new ShortestRoute2());
        navigation.navigate();

        navigation.setRouteStrategy(new AvoidTollsRoute2());
        navigation.navigate();

        navigation.setRouteStrategy(new ScenicRoute2());
        navigation.navigate();
    }
}

// Cons :
// Client must be aware of different strategies to choose from ( can be mitigated with a factory pattern )