package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
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

            // get the pacman course from db
            int id = 10;
            Course pacman = session.get(Course.class, id);

            // delete the course
            System.out.println("Deleting course: " + pacman);
            session.delete(pacman);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
            System.out.println("Done");
        }
    }
}
