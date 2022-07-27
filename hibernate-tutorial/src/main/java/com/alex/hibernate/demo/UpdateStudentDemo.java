package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            student.setFirstName("Scooby");
            session.getTransaction().commit();

            // NEW CODE
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // update email for students
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
