package com.javainuse.dao;

import com.javainuse.domain.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void addNewEmployee(Employee employee);

    public List<Employee> getAllEmployees();
}
