package hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class AppPut {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        for(int i = 0; i < 50; i++) {
            Student s = new Student(i, "Name " + i, new Random().nextInt(100));
            session.persist(s);
        }

        session.getTransaction().commit();
        session.close();
    }
}
