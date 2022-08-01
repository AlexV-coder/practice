package cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AppPut {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(1, "Alex", "Blue"));
        aliens.add(new Alien(2, "Andrew", "Green"));
        aliens.add(new Alien(3, "Alice", "Red"));

        session.beginTransaction();
        for(Alien alien : aliens) {
            session.persist(alien);
        }
        session.getTransaction().commit();
        session.close();
    }
}
