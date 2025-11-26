package Module1.IntroToSynchronization.ProducerConsumerWithSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerConsumerWithSemaphore{

    public static void main(String[] args) {
        Store store = new Store(5);  // Max 5 items

        Semaphore producerSemaphore = new Semaphore(5); // Producers can produce 5 items max at a time
        Semaphore consumerSemaphore = new Semaphore(0); // No consumers allowed initially

        // Start 8 producers
        for (int i = 0; i < 8; i++) {
            Thread producerThread = new Thread(new Producer(store, producerSemaphore, consumerSemaphore), "Producer-" + i);
            producerThread.start();
        }

        // Start 20 consumers
        for (int i = 0; i < 20; i++) {
            Thread consumerThread = new Thread(new Consumer(store, producerSemaphore, consumerSemaphore), "Consumer-" + i);
            consumerThread.start();
        }
    }
}

// 🔄 Shared Store
class Store {
    private final int maxSize;
    private final List<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public synchronized void addItem(Object item) {
        items.add(item);
        System.out.println(Thread.currentThread().getName() + " ➕ [Produced] | Store size: " + items.size());
    }

    public synchronized void removeItem() {
        if (!items.isEmpty()) {
            items.remove(0);
            System.out.println(Thread.currentThread().getName() + " 🗑️ [Consumed] | Store size: " + items.size());
        }
    }
}

// 👷 Producer
class Producer implements Runnable {
    private final Store store;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                logStatus("🛑 Waiting to produce...");
                producerSemaphore.acquire(); // Wait if store is full

                logStatus("✅ Acquired permit to produce");
                store.addItem(new Object());

                consumerSemaphore.release(); // Signal to consumer
                logStatus("📢 Released permit to consumer");

                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void logStatus(String message) {
        System.out.println(Thread.currentThread().getName() + " " + message);
    }
}

// 🙋 Consumer
class Consumer implements Runnable {
    private final Store store;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                logStatus("🛑 Waiting to consume...");
                consumerSemaphore.acquire(); // Wait if store is empty

                logStatus("✅ Acquired permit to consume");
                store.removeItem();

                producerSemaphore.release(); // Signal to producer
                logStatus("📢 Released permit to producer");

                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void logStatus(String message) {
        System.out.println(Thread.currentThread().getName() + " " + message);
    }
}