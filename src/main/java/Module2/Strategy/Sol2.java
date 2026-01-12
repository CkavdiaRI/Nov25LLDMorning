package Module2.Strategy;

class Navigation2{
    public void navigate(String routeType) {
        if(routeType.equalsIgnoreCase("fastest")){
            new fastestRoute().calculate();
        } else if(routeType.equalsIgnoreCase("shortest")) {
            new shortestRoute().calculate();
        } else if(routeType.equalsIgnoreCase("avoid tolls")) {
            new avoidTollsRoute().calculate();
        } else if(routeType.equalsIgnoreCase("scenic")) {
            new scenicRoute().calculate();
        } else {
            System.out.println("Please choose a valid route type.");
        }
    }
}

class fastestRoute {
    public void calculate() {
        System.out.println("Calculating the fastest route...");
    }
}

class shortestRoute {
    public void calculate() {
        System.out.println("Calculating the shortest route...");
    }
}

class avoidTollsRoute {
    public void calculate() {
        System.out.println("Calculating the avoid tolls route...");
    }
}

class scenicRoute {
    public void calculate() {
        System.out.println("Calculating the scenic route...");
    }
}

public class Sol2 {
    public static void main(String[] args) {
        Navigation2 navigation = new Navigation2();
        navigation.navigate("fastest");
        navigation.navigate("shortest");
        navigation.navigate("avoid tolls");
        navigation.navigate("scenic");
        navigation.navigate("invalid route");
    }
}

// Cons :
// Voilates Open/Closed Principle
// Voilates Single Responsibility Principle
// Tight coupling between Navigation and route types
// Voilates Dependency Inversion Principle
// Too many if-else statements ( Scalability issues )`

// Pros :
// Each route type is encapsulated in its own class
// better modularity
// Easy to maintain each route separately