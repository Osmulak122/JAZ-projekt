package com.example.jazprojekt.repository;


import com.example.jazprojekt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
    Employee findEmployeeByEmail(String email);
    Employee findEmployeeByPhoneNumber(String phoneNumber);
    Employee findEmployeeByPosition(String position);
}