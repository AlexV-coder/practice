package creational.abstractfactory.chair;

public class OfficeChair implements Chair {

    @Override
    public void printChairInfo() {
        System.out.println("I'm an office chair!");
    }
}
