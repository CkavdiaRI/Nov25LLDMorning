package Module2.Strategy;

class Navigation{
    public void navigate(String routeType) {
        if(routeType.equalsIgnoreCase("fastest")){
            System.out.println("Calculating the fastest route...");
        } else if(routeType.equalsIgnoreCase("shortest")) {
            System.out.println("Calculating the shortest route...");
        } else if(routeType.equalsIgnoreCase("avoid tolls")) {
            System.out.println("Calculating the avoid tolls route...");
        } else if(routeType.equalsIgnoreCase("scenic")) {
            System.out.println("Calculating the scenic route...");
        } else {
            System.out.println("Please choose a valid route type.");
        }
    }
}

public class Sol1 {
    public static void main(String[] args) {
        Navigation navigation = new Navigation();
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
// Too many if-else statements ( Scalability issues )
// String based route type selection ( error-prone )
// Difficult to test individual route
// Difficult to extend with new route types
// Difficult to maintain