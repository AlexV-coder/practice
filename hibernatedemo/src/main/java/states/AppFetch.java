package states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppFetch {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Laptop laptop = new Laptop(102, "Lenovo", 1000);
        session.persist(laptop);
        laptop.setPrice(1500);
        session.getTransaction().commit();
        session.detach(laptop);
        laptop.setPrice(2000);
        session.close();
    }
}
