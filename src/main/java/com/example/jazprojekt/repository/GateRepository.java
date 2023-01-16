package com.example.jazprojekt.repository;

import com.example.jazprojekt.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {

    List<Gate> findGatesByTerminal(String terminal);
    List<Gate> findGatesByStatus(String gateNumber);
}
