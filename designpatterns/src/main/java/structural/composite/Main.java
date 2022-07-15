package structural.composite;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees1 = List.of(
                new NonManager("Alex"),
                new NonManager("Andrew"),
                new NonManager("Alice")
        );
        Employee manager1 = new Manager(employees1, "Mathew");

        List<Employee> employees2 = List.of(
                manager1,
                new NonManager("Andrea"),
                new NonManager("Laura")
        );
        Employee manager2 = new Manager(employees2, "Dan");
        manager2.callSubordiantes("No one");
    }
}
