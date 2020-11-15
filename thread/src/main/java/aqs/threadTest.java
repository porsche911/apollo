package aqs;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
//阻塞队列是无界的

public class threadTest {
    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(0,1,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        while (true) {
            executor.execute(() -> {
                System.out.println(atomicInteger.getAndAdd(1));
            });
        }
    }
}

