package threadlocal;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Main Thread");
        System.out.println(threadLocal.get());
        Thread thread1 = new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set("Thread 1");
            System.out.println(threadLocal.get());
        });
        thread1.start();
        try {
            thread1.join();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(threadLocal.get());
    }
}
