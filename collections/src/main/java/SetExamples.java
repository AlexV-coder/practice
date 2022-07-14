import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {
    public static void main(String[] args) {
        // Hash Set
        Set<String> hashSet = new HashSet<>();
        hashSet.add("First");
        hashSet.add("Second");
        hashSet.add("4");
        hashSet.add("3");
        hashSet.add("Fifth");
        System.out.println(hashSet);

        // Tree Set
        Set<String> treeSet = new TreeSet<>(hashSet);
        System.out.println(treeSet);
    }
}
