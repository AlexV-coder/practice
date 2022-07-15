package behavioural.observer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Observer> subscribers = List.of(
                new Journalist("Alex"),
                new Pensioner("Vlad"),
                new Pensioner("Andrew"),
                new Journalist("Alice")
        );
        Magazine magazine = new Magazine(subscribers);
        magazine.setNews("Water is wet");
        magazine.setNews("I like Java");
    }
}
