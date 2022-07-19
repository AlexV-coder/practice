package relations.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setId(101);
        laptop.setName("DELL");

        Student student = new Student();
        student.setRollNumber(1);
        student.setName("Alex");
        student.setMarks(50);

        student.getLaptops().add(laptop);
        laptop.getStudents().add(student);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();
        session.persist(laptop);
        session.persist(student);
        session.getTransaction().commit();

        session.close();
    }
}
