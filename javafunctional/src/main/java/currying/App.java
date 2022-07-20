package currying;

import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        Function<Double, Function<Double, Double>> weight = gravity -> mass -> mass * gravity;

        Function<Double, Double> weightOnEarth = weight.apply(9.81);
        Function<Double, Double> weightOnMars = weight.apply(3.75);

        double myMass = 82.5;

        System.out.println("My weight on Earth: " + weightOnEarth.apply(myMass));
        System.out.println("My weight on Mars: " + weightOnMars.apply(myMass));

    }
}
