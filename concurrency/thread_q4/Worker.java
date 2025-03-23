package concurrency.thread_q4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final int id;
    private final long sleepTime;

    public Worker(CyclicBarrier cyclicBarrier, int id, long sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("Worker "+id+" is working ...");
        try {
        Thread.sleep(sleepTime);
        System.out.println("Worker "+id+" readched barrier ... ");
        cyclicBarrier.await();
        System.out.println("Worker "+id+" process further ...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
