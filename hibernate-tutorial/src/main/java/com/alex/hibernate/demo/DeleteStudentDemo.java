package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);

            //session.delete(student);

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
