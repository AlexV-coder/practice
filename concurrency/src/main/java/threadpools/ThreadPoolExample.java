package threadpools;

import lock.CustomRunnable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Thread producerThread = new Thread(new Producer(queue));
        producerThread.start();

        AtomicBoolean allElementsConsumed = new AtomicBoolean(false);

        executorService.execute(new Consumer(queue, allElementsConsumed));
        executorService.execute(new Consumer(queue, allElementsConsumed));
        executorService.execute(new Consumer(queue, allElementsConsumed));

        executorService.shutdown();
    }
}
