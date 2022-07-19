package fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AppPut {
    public static void main(String[] args) {
        List<Laptop> laptops = List.of(
                new Laptop(101, "Dell", 1000),
                new Laptop(102, "Apple", 2000),
                new Laptop(103, "Asus", 800),
                new Laptop(104, "Acer", 1500),
                new Laptop(105, "Samsung", 1400)
        );
        List<Alien> aliens = List.of(
                new Alien(1, "Navin", List.of(laptops.get(0), laptops.get(2), laptops.get(4))),
                new Alien(2, "Rahul", new ArrayList<>()),
                new Alien(3, "Mayank", List.of(laptops.get(1), laptops.get(3)))
        );

        laptops.get(0).setAlien(aliens.get(0));
        laptops.get(1).setAlien(aliens.get(2));
        laptops.get(2).setAlien(aliens.get(0));
        laptops.get(3).setAlien(aliens.get(2));
        laptops.get(4).setAlien(aliens.get(0));

        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        for(Laptop laptop : laptops) {
            session.persist(laptop);
        }
        for(Alien alien : aliens) {
            session.persist(alien);
        }
        session.getTransaction().commit();
        session.close();
    }
}
