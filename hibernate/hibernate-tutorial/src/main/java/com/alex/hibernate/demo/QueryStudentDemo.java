 package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

 public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student ").list();

            // display the students
            System.out.println(students);

            // query students: lastName = 'Duck'
            students = session.createQuery("from Student where lastName = 'Duck'").list();
            System.out.println(students);

            // query students: lastName = 'Duck' OR firstName='Mary'

            students = session.createQuery("from Student where lastName = 'Duck' OR firstName = 'Mary'").list();
            System.out.println(students);

            // query students: email LIKE '%gmail.com'
            students = session.createQuery("from Student where email LIKE '%@gmail.com'").list();
            System.out.println(students);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
