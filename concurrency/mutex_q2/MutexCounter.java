package concurrency.mutex_q2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexCounter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void incrementCount(){
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}
