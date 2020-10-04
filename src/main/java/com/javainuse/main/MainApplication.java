package com.javainuse.main;

import com.javainuse.dao.EmployeeDAO;
import com.javainuse.domain.Employee;
import com.javainuse.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        //Load the Spring container using the Spring Configuration File
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //Retrieve the Bean from the Spring Conatiner
        EmployeeService empService = container.getBean(EmployeeService.class);
        Employee emp1 = new Employee("1", "Test1", "Manager", 1000);
        Employee emp2 = new Employee("1", "Test2", "Manager", 1000);
        Employee emp3 = new Employee("1", "Test3", "Manager", 1000);
        Employee emp4 = new Employee("1", "Test4", "Manager", 1000);
        Employee emp5 = new Employee("1", "Test5", "Manager", 1000);

        empService.addNewEmployee(emp1);
        empService.addNewEmployee(emp2);
        empService.addNewEmployee(emp3);
        empService.addNewEmployee(emp4);
        empService.addNewEmployee(emp5);
        List<Employee> employees = empService.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}
