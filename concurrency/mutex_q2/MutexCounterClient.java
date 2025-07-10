package concurrency.mutex_q2;

public class MutexCounterClient {
    public static void main(String[] args) throws InterruptedException {
        MutexCounter mutexCounter = new MutexCounter();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    mutexCounter.incrementCount();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final Count :: "+mutexCounter.getCount());
    }
}
