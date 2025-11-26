package Module1.IntroToSynchronization.NaiveProducerConsumerDemo;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a shared resource (the store/shelf)
 */
class Store {
    private int maxSize;
    private List<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public List<Object> getItems() {
        return items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    // Producer adds item
    public void addItem(String producerName) {
        items.add(new Object());
        System.out.println("✅ " + producerName + " produced. Current size = " + items.size());
    }

    // Consumer removes item
    public void removeItem(String consumerName) {
        items.remove(items.size() - 1);
        System.out.println("🗑️ " + consumerName + " consumed. Current size = " + items.size());
    }
}

/**
 * Producer Thread (Naive: No Synchronization)
 */
class Producer implements Runnable {
    private Store store;
    private String name;

    public Producer(Store store, String name) {
        this.store = store;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            // No synchronization! Multiple producers can enter here at the same time.
            if (store.getItems().size() < store.getMaxSize()) {
                store.addItem(name);
            }

            // Sleep to simulate time taken to produce
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

/**
 * Consumer Thread (Naive: No Synchronization)
 */
class Consumer implements Runnable {
    private Store store;
    private String name;

    public Consumer(Store store, String name) {
        this.store = store;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            // No synchronization! Multiple consumers may pass this check together.
            if (store.getItems().size() > 0) {
                store.removeItem(name);
            }

            // Sleep to simulate time taken to consume
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

/**
 * Entry point for demo
 */
public class NaiveProducerConsumerDemo {
    public static void main(String[] args) {
        Store store = new Store(5); // Shelf with 5 slots]

        // Starting 5 producer threads
        for (int i = 1; i <= 5; i++) {
            Thread producer = new Thread(new Producer(store, "Producer-" + i));
            producer.start();
        }

        // Starting 5 consumer threads
        for (int i = 1; i <= 5; i++) {
            Thread consumer = new Thread(new Consumer(store, "Consumer-" + i));
            consumer.start();
        }

        // 🔴 This version may cause IndexOutOfBoundsException
        // Because multiple consumers might check size > 0 at the same time,
        // and try to remove even if nothing is left
    }
}


// Threads continuously running
//Sometimes, IndexOutOfBoundsException appears
//Logically looks correct, but breaks under concurrency

//if (size > 0) is not atomic
//Multiple consumers might read size = 1 and both try to remove
//Leads to race condition and data inconsistency

//Race Condition	Multiple threads accessing shared data without coordination.
//Critical Section	Code block that must be accessed by one thread at a time.
//synchronized	Java keyword to prevent concurrent access to critical section.
