package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    List<Employee> subordinates;
    String name;

    public Manager(List<Employee> subordinates, String name) {
        this.subordinates = subordinates;
        this.name = name;
    }

    @Override
    public void callSubordiantes(String superior) {
        System.out.println(name + ": " + superior + " is my boss");
        for(Employee subordinate : subordinates) {
            subordinate.callSubordiantes(this.name);
        }
    }
}
