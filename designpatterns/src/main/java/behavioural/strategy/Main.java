package behavioural.strategy;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird(new RapidFlying());
        bird.getFlyStrategy().fly();
        bird.setFlyStrategy(new SlowFlying());
        bird.getFlyStrategy().fly();
    }
}
