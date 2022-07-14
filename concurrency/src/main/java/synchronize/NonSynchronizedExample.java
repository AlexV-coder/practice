package synchronize;

public class NonSynchronizedExample {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                for(int i = 1; i <= 1_000_000; i++) {
                    count++;
                }
                System.out.println(count);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
