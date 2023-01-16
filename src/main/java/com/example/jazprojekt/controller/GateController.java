package com.example.jazprojekt.controller;

import com.example.jazprojekt.model.Gate;
import com.example.jazprojekt.repository.GateRepository;
import com.example.jazprojekt.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GateController {
    GateService gateService;

    @Autowired
    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping("/gate")
    public ResponseEntity<List<Gate>> getAllGates() {
        return ResponseEntity.ok(gateService.getAllGates());
    }

    @GetMapping("/gate/id/{id}")
    public ResponseEntity<Gate> getGateById(@PathVariable Long id) {
        return ResponseEntity.ok(gateService.getGateById(id));
    }

    @PostMapping("/gate")
    public ResponseEntity<Gate> createGate(@RequestBody Gate gate) {
        return ResponseEntity.ok(gateService.createGate(gate));
    }

    @PutMapping("/gate/id/{id}")
    public ResponseEntity<Gate> updateGate(@PathVariable Long id, @RequestBody Gate gate) {
        return ResponseEntity.ok(gateService.updateGate(id, gate));
    }

    @DeleteMapping("/gate/id/{id}")
    public void deleteGate(@PathVariable Long id) {
        gateService.deleteGateById(id);
    }

    @GetMapping("/gate/terminal/{terminal}")
    public ResponseEntity<List<Gate>> getGatesByTerminal(@PathVariable String terminal) {
        return ResponseEntity.ok(gateService.getGatesByTerminal(terminal));
    }

    @GetMapping("/gate/status/{status}")
    public ResponseEntity<List<Gate>> getGatesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(gateService.getGatesByStatus(status));
    }
}
