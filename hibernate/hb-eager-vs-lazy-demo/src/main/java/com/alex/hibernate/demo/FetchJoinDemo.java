package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Course;
import com.alex.hibernate.demo.entity.Instructor;
import com.alex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int id = 1;
            Query<Instructor> query = session.createQuery("secdlect i from Instructor i JOIN FETCH i.courses where i.id =: theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", id);

            // execute query
            Instructor instructor = query.getSingleResult();

            // commit transaction
            session.getTransaction().commit();

            // close the sessions
            session.close();

            System.out.println(instructor);
            System.out.println(instructor.getCourses());

        } finally {
            sessionFactory.close();
            System.out.println("Done");
        }
    }
}
