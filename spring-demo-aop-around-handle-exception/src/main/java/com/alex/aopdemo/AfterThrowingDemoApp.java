package com.alex.aopdemo;

import com.alex.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = null;

        try {
            // add a boolean flag to simulate exception
            boolean tripWire = true;
            accounts =accountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println("\n\nMain Program .. caught exception: " + ex);
        }
        // display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(accounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
