package com.javainuse.dao;

import com.javainuse.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private List<Employee> testEmployees = new ArrayList<Employee>();

    public void addNewEmployee(Employee employee) {
        testEmployees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(testEmployees);
    }
}
