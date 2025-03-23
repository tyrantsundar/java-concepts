package concurrency.thread_q2;

public class Client {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                try {
                    printNumbers.printOdd(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Odd");

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    printNumbers.printEven(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Even");

        t1.start();
        t2.start();
    }
}
