package com.javainuse.dao;

import com.javainuse.domain.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplUsingJDBC implements EmployeeDAO {

    //Create Employee Table in constructor.
    public EmployeeDAOImplUsingJDBC() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            createEmployeeTable();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Exception occured in DAO constructor");
        }

    }

    private static void createEmployeeTable() {
        try {
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate(
                        "create table Employee(empId VARCHAR(20), name VARCHAR(50), designation VARCHAR(50),salary VARCHAR(50))");
                System.out.println("Created new table Employee");
            }
            finally {
                if (con != null)
                    con.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Employee table has already been created...");
        }
    }

    public void addNewEmployee(Employee employee) {
        try {
            Connection con = null;
            PreparedStatement insertEmployee = null;
            try {
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                insertEmployee =
                        con.prepareStatement("insert into Employee (empid, name, designation) values (?, ?, ?)");
                insertEmployee.setString(1, employee.getEmpId());
                insertEmployee.setString(2, employee.getName());
                insertEmployee.setString(3, employee.getDesignation());
                insertEmployee.executeUpdate();
                System.out.println("Created new Employee");
            }
            finally {
                if (con != null)
                    con.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Exception Occured while adding new Employee");
        }

    }

    public List<Employee> getAllEmployees() {
        List<Employee> results = new ArrayList<Employee>();
        try {
            Connection con = null;
            PreparedStatement retrieveBooks = null;
            ResultSet rs = null;

            try {
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                retrieveBooks = con.prepareStatement("select * from Employee");
                rs = retrieveBooks.executeQuery();
                while (rs.next()) {
                    String empId = rs.getString(1);
                    String name = rs.getString(2);
                    String designation = rs.getString(3);
                    double salary = 0;
                    Employee emp = new Employee(empId, name, designation, salary);
                    results.add(emp);
                }

            }
            finally {
                if (rs != null)
                    rs.close();
                if (con != null)
                    con.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Exception Occured while retrieving employees");
        }
        return results;
    }

}
