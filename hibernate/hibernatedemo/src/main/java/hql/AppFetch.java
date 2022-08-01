package hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AppFetch {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        int minMark = 50;
        Query query = session.createQuery("SELECT id, name, marks from Student where marks > :minMark");
        query.setParameter("minMark", minMark);
        List<Object[]> students = query.list();
        for(Object[] student : students) {
            System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
        }
        session.getTransaction().commit();
        session.close();
    }
}
