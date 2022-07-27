package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Course;
import com.alex.hibernate.demo.entity.Instructor;
import com.alex.hibernate.demo.entity.InstructorDetail;
import com.alex.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the course
            int id = 10;
            Course course = session.get(Course.class, id);

            // print the course
            System.out.println("Deleting the course ... ");
            System.out.println(course);

            // print the course reviews
            System.out.println(course.getReviews());

            //delete the course
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
