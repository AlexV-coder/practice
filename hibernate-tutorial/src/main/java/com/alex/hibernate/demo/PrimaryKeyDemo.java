package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // create 3 students
            System.out.println("Creating 3 students...");
            Student student1 = new Student("Paul", "Wall", "paul@gmail.com");
            Student student2 = new Student("Mary", "Public", "mary@gmail.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");
            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
