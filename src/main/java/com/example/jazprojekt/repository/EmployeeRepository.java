package com.example.jazprojekt.repository;


import com.example.jazprojekt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByPosition(String position);
    Employee findEmployeeByFirstNameAndLastName(String firstName, String lastName);
}