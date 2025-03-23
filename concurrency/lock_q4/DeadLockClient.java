package concurrency.lock_q4;

public class DeadLockClient {

    public static void main(String[] args) {
        DeadLockExample demo = new DeadLockExample();

        Thread t1 = new Thread(demo::method1,"Thread 1");
        Thread t2 = new Thread(demo::method2,"Thread 2");
        t1.start();
        t2.start();
    }
}
