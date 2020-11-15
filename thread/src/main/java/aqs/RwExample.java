package aqs;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RwExample {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Integer data = 0;


    public void get(){
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"ready r");
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"读到数据 w");
        readWriteLock.readLock().unlock();
    }
}
