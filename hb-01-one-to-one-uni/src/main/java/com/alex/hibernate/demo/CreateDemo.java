package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.Instructor;
import com.alex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // create the objects
            //Instructor instructor = new Instructor("Chad", "Darby", "darby@gmail.com");
            //InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/luv2code", "Luv 2 code!!!");

            Instructor instructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/madhu", "Guitar");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save instructor
            // will save instructorDetail as well because of CASCADE TYPE
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            System.out.println("Done");
        }
    }
}
