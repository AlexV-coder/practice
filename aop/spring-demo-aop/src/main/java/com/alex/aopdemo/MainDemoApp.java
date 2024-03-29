package com.alex.aopdemo;

import com.alex.aopdemo.dao.AccountDAO;
import com.alex.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        // call the membership method
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
