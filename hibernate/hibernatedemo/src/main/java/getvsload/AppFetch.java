package getvsload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppFetch {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        // Retrieves object right now
        // Executes query right now
        //Laptop laptop = session.get(Laptop.class, 101);

        // Retrieves object when it is used for the first time
        // Executes query when the object is needed
        // For the moment it only returns a proxy object
        Laptop laptop = session.load(Laptop.class, 101);

        System.out.println(laptop.getBrand());

        session.getTransaction().commit();
        session.close();

    }
}
