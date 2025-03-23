package concurrency.thread_q2;

public class PrintNumbers {
    boolean printOdd = true;

    public synchronized void printOdd(int num) throws InterruptedException {
        while (!printOdd){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " - " + num);
        printOdd = false;
        notify();
    }

    public synchronized void printEven(int num) throws InterruptedException {
        while (printOdd){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " - " + num);
        printOdd = true;
        notify();
    }
}
