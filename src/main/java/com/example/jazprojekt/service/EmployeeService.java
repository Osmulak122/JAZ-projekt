package com.example.jazprojekt.service;

import com.example.jazprojekt.model.Employee;
import com.example.jazprojekt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> e = employeeRepository.findById(id);
        if(e.isPresent()) {
            return e.get();
        }
        throw new IllegalArgumentException("Employee with id " + id + " not found");
    }

    public Employee createEmployee(Employee employee) {
        if(employee.getId() != null) {
            throw new IllegalArgumentException("Employee id must be null");
        }
        if(employee.getFirstName() == null) {
            throw new IllegalArgumentException("Employee first name must not be null");
        }
        if(employee.getLastName() == null) {
            throw new IllegalArgumentException("Employee last name must not be null");
        }
        if(employee.getSalary() < 0) {
            throw new IllegalArgumentException("Employee salary must be positive");
        }
        if(employee.getPosition() == null) {
            throw new IllegalArgumentException("Employee position must not be null");
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = getEmployeeById(id);
        if(employee.getFirstName() != null) {
            employeeToUpdate.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName() != null) {
            employeeToUpdate.setLastName(employee.getLastName());
        }
        if(employee.getSalary() > 0) {
            employeeToUpdate.setSalary(employee.getSalary());
        }
        if(employee.getPosition() != null) {
            employeeToUpdate.setPosition(employee.getPosition());
        }
        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByPosition(String position) {
        return employeeRepository.findEmployeesByPosition(position);
    }

    public Employee getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findEmployeeByFirstNameAndLastName(firstName, lastName);
    }
}

