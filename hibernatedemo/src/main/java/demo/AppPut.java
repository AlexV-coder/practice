package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppPut {
    public static void main(String[] args) {
        Alien alien = new Alien();
        alien.setId(101);
        alien.setName(new AlienName("Alex", "Vasile", "Magic"));
        alien.setColor("Blue");

        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(alien);
        transaction.commit();
    }
}
