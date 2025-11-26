package Module1.IntroToSynchronization.SyncProducerConsumerDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shared resource (the store/shelf)
 */
class SyncStore {
    private int maxSize;
    private List<Object> items;

    public SyncStore(int maxSize) {
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
 * Producer Thread (Now uses synchronized block)
 */
class SyncProducer implements Runnable {
    private SyncStore syncStore;
    private String name;

    public SyncProducer(SyncStore syncStore, String name) {
        this.syncStore = syncStore;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (syncStore) {
                if (syncStore.getItems().size() < syncStore.getMaxSize()) {
                    syncStore.addItem(name);
                }
            }

            // Sleep to simulate time taken to produce
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

/**
 * Consumer Thread (Now uses synchronized block)
 */
class SyncConsumer implements Runnable {
    private SyncStore syncStore;
    private String name;

    public SyncConsumer(SyncStore syncStore, String name) {
        this.syncStore = syncStore;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (syncStore) {
                if (syncStore.getItems().size() > 0) {
                    syncStore.removeItem(name);
                }
            }

            // Sleep to simulate time taken to consume
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

/**
 * Entry point for demo
 */
public class SyncProducerConsumerDemo {
    public static void main(String[] args) {
        SyncStore syncStore = new SyncStore(5); // Shelf with 5 slots

        // Starting 5 producer threads
        for (int i = 1; i <= 5; i++) {
            Thread producer = new Thread(new SyncProducer(syncStore, "Producer-" + i));
            producer.start();
        }

        // Starting 5 consumer threads
        for (int i = 1; i <= 5; i++) {
            Thread consumer = new Thread(new SyncConsumer(syncStore, "Consumer-" + i));
            consumer.start();
        }
    }
}

// Race Condition     Multiple threads accessing shared data without coordination.
// Critical Section   Code block that must be accessed by one thread at a time.
// synchronized       Java keyword to prevent concurrent access to critical section.
