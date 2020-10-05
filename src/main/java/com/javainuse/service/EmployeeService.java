package com.javainuse.service;

import com.javainuse.dao.EmployeeDAOImplUsingJDBC;
import com.javainuse.domain.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDAOImplUsingJDBC empDAO;

    public void addNewEmployee(Employee emp) {
        empDAO.addNewEmployee(emp);
    }

    public List<Employee> getEmployees() {
        return empDAO.getAllEmployees();
    }

    //Setter for EmployeeDAO for setter injection
    public void setEmpDAO(EmployeeDAOImplUsingJDBC empDAO) {
        this.empDAO = empDAO;
    }
}
