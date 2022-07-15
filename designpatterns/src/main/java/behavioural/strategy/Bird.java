package behavioural.strategy;

public class Bird {
    private FlyStrategy flyStrategy;

    public Bird(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public FlyStrategy getFlyStrategy() {
        return flyStrategy;
    }

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }
}
