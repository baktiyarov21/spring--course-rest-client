package com.arsenbaktiyarov.spring.rest;

import com.arsenbaktiyarov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/spring_rest/api/employees/";
    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });

        List<Employee> employees = responseEntity.getBody();
        return employees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id,
                Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee) {


        if ( employee.getId() == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("new employee was added");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id " + employee.getId() + " was updated" );
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee was deleted");
    }

}
