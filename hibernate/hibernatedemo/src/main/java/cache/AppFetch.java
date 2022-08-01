package cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppFetch {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session1 = sf.openSession();
        Session session2 = sf.openSession();

        Alien alien;

        session1.beginTransaction();

        alien = session1.get(Alien.class, 1);
        System.out.println(alien);

        session1.getTransaction().commit();
        session1.close();

        session2.beginTransaction();

        alien = session2.get(Alien.class, 1);
        System.out.println(alien);

        session2.getTransaction().commit();
        session2.close();


    }
}
