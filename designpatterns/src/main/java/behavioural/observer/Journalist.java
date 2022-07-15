package behavioural.observer;

public class Journalist implements Observer {

    private final String name;

    public Journalist(String name) {
        this.name = name;
    }

    @Override
    public void notify(String news) {
        System.out.println("Journalist " + name + " has received the news: " + news);
    }
}
