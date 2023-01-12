package com.example.jazprojekt.controller;

import com.example.jazprojekt.model.Gate;
import com.example.jazprojekt.repository.GateRepository;
import com.example.jazprojekt.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gate")
public class GateController {
    GateService gateService;

    @Autowired
    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping("/gate")
    public List<Gate> getAllGates() {
        return gateService.getAllGates();
    }

    @GetMapping("/gate/{id}")
    public Gate getGateById(@PathVariable Long id) {
        return gateService.getGateById(id);
    }

    @PostMapping("/gate")
    public Gate createGate(@RequestBody Gate gate) {
        return gateService.createGate(gate);
    }

    @PutMapping("/gate/{id}")
    public Gate updateGate(@PathVariable Long id, @RequestBody Gate gate) {
        gate.setId(id);
        return gateService.updateGate(gate);
    }

    @DeleteMapping("/gate/{id}")
    public void deleteGate(@PathVariable Long id) {
        gateService.deleteGate(id);
    }
}
