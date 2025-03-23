package concurrency.mutex_q2;

public class MutexCounterClient {
    public static void main(String[] args) throws InterruptedException {
        MutexCounter mutexCounter = new MutexCounter();
        Thread thread1 = new Thread(mutexCounter::incrementCount);
        Thread thread2 = new Thread(mutexCounter::incrementCount);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final Count :: "+mutexCounter.getCount());
    }
}
