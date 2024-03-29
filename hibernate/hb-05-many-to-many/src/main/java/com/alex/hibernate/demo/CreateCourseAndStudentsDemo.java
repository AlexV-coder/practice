package com.alex.hibernate.demo;

import com.alex.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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

            // create a course
            Course course = new Course("Pacman - How To Score One Million Points");

            // save the course .. and leverage the cascade all
            System.out.println("\nSaving the course ...");
            session.save(course);
            System.out.println("Saved the course: " + course);

            // create the students
            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Mary", "Public", "mary@gmail.com");

            // add students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("\nSaving students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudents());

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
            System.out.println("Done");
        }
    }
}
