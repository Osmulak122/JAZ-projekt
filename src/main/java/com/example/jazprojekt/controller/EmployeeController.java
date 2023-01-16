package com.example.jazprojekt.controller;

import com.example.jazprojekt.model.Employee;
import com.example.jazprojekt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PutMapping("/employee/id/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/employee/firstname/{firstname}/lastname/{lastname}")
    public ResponseEntity<Employee> getEmployeeByFirstNameAndLastName(@PathVariable String firstname, @PathVariable String lastname) {
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameAndLastName(firstname, lastname));
    }

    @GetMapping("/employee/position/{position}")
    public ResponseEntity<List<Employee>> getEmployeesByPosition(@PathVariable String position) {
        return ResponseEntity.ok(employeeService.getEmployeesByPosition(position));
    }
}
