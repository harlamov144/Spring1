package com.javainuse.service;

import com.javainuse.dao.EmployeeDAO;
import com.javainuse.domain.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDAO empDAO;

    public void addNewEmployee(Employee emp) {
        empDAO.addNewEmployee(emp);
    }

    public List<Employee> getEmployees() {
        return empDAO.getAllEmployees();
    }

    //Setter for EmployeeDAO for setter injection
    public void setEmpDAO(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }
}
