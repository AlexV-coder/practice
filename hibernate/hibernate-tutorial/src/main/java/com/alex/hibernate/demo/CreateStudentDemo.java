package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // create the student object
            System.out.println("Creating a new student object...");
            Student student = new Student("Paul", "Wall", "paul@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
