package structural.composite;

public class NonManager implements Employee {

    String name;

    public NonManager(String name) {
        this.name = name;
    }
    @Override
    public void callSubordiantes(String superior) {
        System.out.println(name + ": " + superior + " is my boss");
    }
}
