package behavioural.observer;

public class Pensioner implements Observer {

    private final String name;

    public Pensioner(String name) {
        this.name = name;
    }

    @Override
    public void notify(String news) {
        System.out.println("Pensioner " + name + " has received the news: " + news);
    }
}
