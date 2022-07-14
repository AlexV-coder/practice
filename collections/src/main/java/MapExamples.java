import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExamples {
    public static void main(String[] args) {

        Map<String, String> users = new HashMap<>();
        users.put("123", "Jane");
        users.put("789", "Alex");
        users.put("432", "Andrew");

        // Traversing with iterator
        Iterator<Map.Entry<String, String>> iterator = users.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // Traversing with for
        for(Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // Traversing with streams
        users.entrySet().stream().forEach(entry -> System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue()));
    }
}
