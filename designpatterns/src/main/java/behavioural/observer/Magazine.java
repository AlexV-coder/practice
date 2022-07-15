package behavioural.observer;

import java.util.List;

public class Magazine {
    private String news;
    private List<Observer> subscribers;

    public Magazine(List<Observer> subscribers) {
        this.subscribers = subscribers;
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    private void notifyObservers() {
        for(Observer subscriber : subscribers) {
            subscriber.notify(news);
        }
    }

}
