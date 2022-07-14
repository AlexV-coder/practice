import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueExamples {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.addLast("2");
        deque.addFirst("5");

        System.out.println(deque);

        while(!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
