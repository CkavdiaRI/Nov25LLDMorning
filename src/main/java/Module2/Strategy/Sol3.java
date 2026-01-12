package Module2.Strategy;

class Navigation3{
    private RouteStrategy routeStrategy;

    Navigation3(RouteStrategy routeStrategy) {
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

interface RouteStrategy {
    void calculate();
}

class FastestRoute implements RouteStrategy {
    public void calculate() {
        System.out.println("Calculating the fastest route...");
    }
}
class ShortestRoute implements RouteStrategy {
    public void calculate() {
        System.out.println("Calculating the shortest route...");
    }
}
class AvoidTollsRoute implements RouteStrategy {
    public void calculate() {
        System.out.println("Calculating the avoid tolls route...");
    }
}
class ScenicRoute implements RouteStrategy {
    public void calculate() {
        System.out.println("Calculating the scenic route...");
    }
}

public class Sol3 {
    public static void main(String[] args) {
        Navigation3 navigation = new Navigation3(new FastestRoute());
        navigation.navigate();

        Navigation3 navigation2 = new Navigation3(new ShortestRoute());
        navigation2.navigate();

        Navigation3 navigation3 = new Navigation3(new AvoidTollsRoute());
        navigation3.navigate();

        Navigation3 navigation4 = new Navigation3(new ScenicRoute());
        navigation4.navigate();
    }
}

// Pros :
// Adheres to Open/Closed Principle
// No if-else statements
// Follows Single Responsibility Principle
// Loose coupling between Navigation and route types
// Follows Dependency Inversion Principle
// No string based route type selection
// Easy to extend with new route types
// Easier to maintain
// Easier to test individual route strategies
// Easy to change route strategy at runtime
// Easy to read and understand

// Cons :
// Client must be aware of different route strategy classes
// Route selection logic not present