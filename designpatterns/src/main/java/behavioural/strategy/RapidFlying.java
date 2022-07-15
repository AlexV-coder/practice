package behavioural.strategy;

public class RapidFlying implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Flying fast!");
    }
}
