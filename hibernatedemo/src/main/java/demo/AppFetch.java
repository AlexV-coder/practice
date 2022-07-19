package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppFetch {
    public static void main(String[] args) {
        Alien alien;

        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        alien = session.get(Alien.class, 103);
        transaction.commit();

        System.out.println(alien);
    }
}
