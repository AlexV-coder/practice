package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Course;
import com.alex.hibernate.demo.entity.Instructor;
import com.alex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get a course
            int id = 10;
            Course course = session.get(Course.class, id);

            // delete course
            session.delete(course);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
            System.out.println("Done");
        }
    }
}
