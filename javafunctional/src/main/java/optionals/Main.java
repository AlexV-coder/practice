package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<IllegalArgumentException> exception = () -> new IllegalArgumentException("Bad call");
        Object val = Optional.ofNullable(null)
                .orElseThrow(exception);
        System.out.println(val);
    }
}
