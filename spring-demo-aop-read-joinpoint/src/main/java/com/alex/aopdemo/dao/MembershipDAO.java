package com.alex.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember() {
        System.out.println(getClass() + ": ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");
    }
}
