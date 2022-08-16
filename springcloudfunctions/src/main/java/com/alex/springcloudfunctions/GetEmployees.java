package com.alex.springcloudfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GetEmployees implements Supplier<EmployeeData> {
    @Override
    public EmployeeData get() {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployees(employees());
        return employeeData;
    }

    private List<Employee> employees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Alex", "alex@gmail.com"));
        employees.add(new Employee("2", "Andrei", "andrei@gmail.com"));
        employees.add(new Employee("3", "Sergiu", "sergiu@gmail.com"));
        employees.add(new Employee("4", "Vasile", "vasile@gmail.com"));
        return employees;
    }
}
