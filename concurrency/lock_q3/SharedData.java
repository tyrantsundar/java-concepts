package concurrency.lock_q3;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private int data = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void writeDate(int data){
        try {
            lock.writeLock().lock();
            this.data = data;
            System.out.println("System data :: "+this.data);
        }finally {
            lock.writeLock().unlock();
        }
    }

    public int readData(){
        try {
            lock.readLock().lock();
            return this.data;
        }finally {
            lock.readLock().unlock();
        }
    }
}
