package Module2.Singleton;

public class DoubleCheckLockingSingleton {
    private static volatile DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton(){}

    public static DoubleCheckLockingSingleton getInstance() {
        if(instance == null) { // First check (no locking)
            synchronized (DoubleCheckLockingSingleton.class) {
                if(instance == null){ // Second check (inside lock)
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
}

class Client3 {
    public static void main(String[] args) {
        DoubleCheckLockingSingleton s1 = DoubleCheckLockingSingleton.getInstance();
        DoubleCheckLockingSingleton s2 = DoubleCheckLockingSingleton.getInstance();

        System.out.println(s1 == s2);  // true
    }
}


// Pros :
// - Thread-safe
// - Lazy initialization
// - Better performance than synchronized method
// - Reduces synchronization overhead by locking only during the first creation


// Cons :
// - More complex implementation
// - Requires careful handling of the volatile keyword to ensure visibility
