package aqs;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Example1 {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock(true);
        Thread t1 = new Thread(){
            public void run(){
                reentrantLock.lock();
                //logic();
                //reentrantLock.unlock();
                /*System.out.println("11111111111");
                LockSupport.park();
                System.out.println("2222222222");*/

            }
        };
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t1);
    }
    public static void logic(){
        System.out.println("111111111111");
    }
}
