package concurrency.thread_q4;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int workerCount = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(workerCount,
                ()->{System.out.println("All threads reached barrier... we ll resume now");});
        for(int i=1;i<=workerCount;i++){
            new Thread(new Worker(cyclicBarrier,i,i*1000)).start();
        }
    }
}
