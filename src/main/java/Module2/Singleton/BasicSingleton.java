package Module2.Singleton;

// Singleton Design Pattern
// Singleton ensures a class has only one instance and provides a global point of access to it.

/// Steps to create a singleton class:
/// 1. Make the constructor private to prevent instantiation from outside the class.
/// 2. Create a static variable to hold the single instance of the class.
/// 3. Provide a public static method that returns the instance, creating it if it doesn't exist.



public class BasicSingleton {
    private static BasicSingleton instance;

    private BasicSingleton(){
    }

    public static BasicSingleton getInstance(){
        if(instance == null){
            instance = new BasicSingleton();
        }
        return instance;
    }
}

class Client {
    public static void main(String[] args) {
        BasicSingleton singleton1 = BasicSingleton.getInstance();

        BasicSingleton singleton2 = BasicSingleton.getInstance();

        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
}

// Pros :
// - Simple to implement
// - Lazy initialization (instance is created only when needed)

// Cons :
// - Not thread-safe; if multiple threads access getInstance() simultaneously, it may create multiple instances