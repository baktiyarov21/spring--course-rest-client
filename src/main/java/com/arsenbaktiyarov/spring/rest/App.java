package com.arsenbaktiyarov.spring.rest;

import com.arsenbaktiyarov.spring.rest.configuration.MyConfig;
import com.arsenbaktiyarov.spring.rest.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> employees = communication.getAllEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

//        Employee employee = communication.getEmployee(2);
//        System.out.println(employee);

        communication.deleteEmployee(1);
    }
}
