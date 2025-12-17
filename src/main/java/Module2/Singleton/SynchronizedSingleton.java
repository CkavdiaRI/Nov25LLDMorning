package Module2.Singleton;

public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){}

    public static synchronized SynchronizedSingleton getInstance() {
        if(instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}

class Client2 {
    public static void main(String[] args) {
        SynchronizedSingleton singleton1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton singleton2 = SynchronizedSingleton.getInstance();

        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
}

// Pros:
// - Thread-safe
// - Simple to implement
// - Lazy initialization

// Cons:
// - Synchronization overhead can lead to performance issues in high-concurrency scenarios