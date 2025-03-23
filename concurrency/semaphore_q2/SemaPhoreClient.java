package concurrency.semaphore_q2;

public class SemaPhoreClient {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        for (int i=1;i<10;i++){
            String threadName = "thread "+i;
            new Thread(()->sharedResource.accessResource(threadName)).start();
        }
    }
}
