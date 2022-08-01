package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Instructor;
import com.alex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println(instructorDetail);

            // print the instructor
            System.out.println(instructorDetail.getInstructor());

            // remove the associated object reference
            // break bidirectional reference
            instructorDetail.getInstructor().setInstructorDetail(null);

            // delete instructor detail
            session.delete(instructorDetail);

            // commit transaction
            session.getTransaction().commit();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
            System.out.println("Done");
        }
    }
}
