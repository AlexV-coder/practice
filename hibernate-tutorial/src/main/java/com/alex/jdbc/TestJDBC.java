package com.alex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database..");
            Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
            System.out.println("Connection successful");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
