package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the student mary from database
            int id = 2;
            Student mary = session.get(Student.class, id);
            System.out.println("\nLoaded student: " + mary);
            System.out.println("Courses: " + mary.getCourses());

            // delete student
            System.out.println("\nDeleting student: " + mary);
            session.delete(mary);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
            System.out.println("Done");
        }
    }
}
