package com.example.jazprojekt.repository;

import com.example.jazprojekt.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
        Optional<Airplane> findByRegistrationNumber(String registrationNumber);
        Airplane findAirplaneByMakeAndModel(String make, String model);
}

