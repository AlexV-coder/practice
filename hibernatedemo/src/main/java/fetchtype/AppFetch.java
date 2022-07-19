package fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppFetch {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Alien alien = session.get(Alien.class, 1);
        System.out.println(alien);

        session.getTransaction().commit();
        session.close();
    }
}
