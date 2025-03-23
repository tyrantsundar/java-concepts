package concurrency.semaphore_q2;

import java.util.concurrent.Semaphore;

public class SharedResource {
    Semaphore semaphore = new Semaphore(3);

    public void accessResource(String threadName) {
        try {
            semaphore.acquire();
            System.out.println("Thread name "+threadName+" accessing the resource");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }

    }
}
