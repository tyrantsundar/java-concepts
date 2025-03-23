package concurrency.lock_q4;

public class DeadLockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1(){
        synchronized (lock1){
            System.out.println("Thread "+Thread.currentThread().getName()+" took lock 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2){
                System.out.println("Thread "+Thread.currentThread().getName()+" took lock 2");
            }
        }
    }

    public void method2() {
        synchronized (lock2){
            System.out.println("Thread "+Thread.currentThread().getName()+" took lock 2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1){
                System.out.println("Thread "+Thread.currentThread().getName()+" took lock 1");
            }
        }
    }
}
