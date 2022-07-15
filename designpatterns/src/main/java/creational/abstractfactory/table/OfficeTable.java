package creational.abstractfactory.table;

public class OfficeTable implements Table {

    @Override
    public void printTableInfo() {
        System.out.println("I'm an office table");
    }
}
