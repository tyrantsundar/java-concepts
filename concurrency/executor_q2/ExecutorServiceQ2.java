package concurrency.executor_q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceQ2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=1;i<=10;i++){
            final int taskId = i;
            executorService.submit(()->{
                System.out.println("Task Id "+taskId+" submitted by thread "+Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
