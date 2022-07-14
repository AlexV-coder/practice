package lock;

import java.util.concurrent.locks.Lock;

public class CustomRunnable implements Runnable {
    private int count = 0;
    private Lock lock;

    public CustomRunnable(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        for(int i = 1; i <= 1_000_000; i++) {
            count++;
        }
        lock.unlock();
        System.out.println(count);
    }
}
