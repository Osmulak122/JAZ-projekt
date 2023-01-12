package com.example.jazprojekt.repository;

import com.example.jazprojekt.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {
    Optional<Gate> findByGatenumber(int gatenumber);
    Gate findGateById(Long id);
    Gate findGateByTerminalAndGatenumber(String terminal, int gatenumber);
}
