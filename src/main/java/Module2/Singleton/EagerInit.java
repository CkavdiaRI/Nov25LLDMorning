package Module2.Singleton;

// Eager Initialization Singleton Pattern
// Instance is created at the time of class loading

public class EagerInit {
    private static EagerInit instance = new EagerInit();

    private EagerInit() {}

    public static EagerInit getInstance(){
        return instance;
    }

    public static void displayMessage(){
        System.out.println("Testing eager init");
    }
}

class Client1 {
    public static void main(String[] args) {
        EagerInit instance1 = EagerInit.getInstance();
        EagerInit instance2 = EagerInit.getInstance();
        System.out.println("Are both instances same? " + (instance1 == instance2));
    }
}

// Pros:
// Very simple to implement
// Thread-safe without synchronization overhead

// Cons:
// Instance is created at class loading time, even if not needed
// Cannot be used in scenarios where instance creation is expensive and not always needed
// Parameters cannot be passed to the constructor during runtime