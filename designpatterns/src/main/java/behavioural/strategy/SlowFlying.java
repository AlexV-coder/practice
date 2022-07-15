package behavioural.strategy;

public class SlowFlying implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Flying slow..");
    }
}
