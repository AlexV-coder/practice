package threadpools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable {

    AtomicBoolean allElementsConsumed;
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue, AtomicBoolean allElementsConsumed) {
        this.queue = queue;
        this.allElementsConsumed = allElementsConsumed;
    }

    @Override
    public void run() {
        Integer nr = 0;
        while(!allElementsConsumed.get()) {
            try {
                nr = queue.poll(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            if (nr == null) {
                System.out.println("No more elements for " + Thread.currentThread().getName());
            } else {
                System.out.println(Thread.currentThread().getName() + " has consumed " + nr);
                if (nr == 1_000_000) {
                    allElementsConsumed.set(true);
                    System.out.println(Thread.currentThread().getName() + " has consumed the last element.");
                }
            }
        }
    }
}
