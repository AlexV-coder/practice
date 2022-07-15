package exercise;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alex", "Programmer"),
                new Employee("Ana", "Manager"),
                new Employee("Andrew", "Designer"),
                new Employee("Alice", "Programmer"),
                new Employee("Diana", "Designer")
        );
        Predicate<Employee> firstPredicate = e -> e.getName().toLowerCase().contains("l");
        Function<Employee, String> firstFunction = e -> e.getName();
        Consumer<String> firstConsumer = e -> System.out.println(e);
        employees.stream().filter(firstPredicate).map(firstFunction).forEach(firstConsumer);
    }

}
