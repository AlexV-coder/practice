package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Instructor;
import com.alex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get instructor by primary key / id
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            // delete instructor
            if(instructor != null) {
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
