package getvsload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class AppPut {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        for(int i = 1; i <= 100; i++) {
            session.persist(new Laptop(i, "Name " + i, new Random().nextInt(10000)));
        }

        session.getTransaction().commit();
        session.close();
    }
}
