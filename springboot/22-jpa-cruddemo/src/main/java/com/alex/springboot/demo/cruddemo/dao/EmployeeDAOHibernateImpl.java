package com.alex.springboot.demo.cruddemo.dao;

import com.alex.springboot.demo.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        System.out.println("=>>>>> Init EmployeeDAO");
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        System.out.println("=>>>>>> Entity Manager: " + entityManager);
        System.out.println("=>>>>>> Current Thread: " + Thread.currentThread().getName());

        Session session = entityManager.unwrap(Session.class);

        System.out.println("=>>>>>> Session: " + session);

        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;

    }

    @Override
    public Employee findById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;

    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("" +
                "delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
