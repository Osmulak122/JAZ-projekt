
package com.example.jazprojekt.controller;

import com.example.jazprojekt.model.Airplane;
import com.example.jazprojekt.repository.AirplaneRepository;
import com.example.jazprojekt.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/airplane")
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        return ResponseEntity.ok(airplaneService.getAllAirplanes());
    }

    @GetMapping("/airplane/id/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable Long id) {
        return ResponseEntity.ok(airplaneService.getAirplaneById(id));
    }

    @PostMapping("/airplane")
    public ResponseEntity<Airplane> createAirplane(@RequestBody Airplane airplane) {
        return ResponseEntity.ok(airplaneService.createAirplane(airplane));
    }

    @PutMapping("/airplane/id/{id}")
    public ResponseEntity<Airplane> updateAirplane(@RequestBody Airplane airplane, @PathVariable Long id) {
        return ResponseEntity.ok(airplaneService.updateAirplane(id, airplane));
    }

    @DeleteMapping("/airplane/id/{id}")
    public ResponseEntity<String> deleteAirplane(@PathVariable Long id) {
        airplaneService.deleteAirplaneById(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/airplane/make/{make}")
    public ResponseEntity<List<Airplane>> getAirplanesByMake(@PathVariable String make) {
        return ResponseEntity.ok(airplaneService.getAirplanesByMake(make));
    }

    @GetMapping("/airplane/model/{model}")
    public ResponseEntity<List<Airplane>> getAirplanesByModel(@PathVariable String model) {
        return ResponseEntity.ok(airplaneService.getAirplanesByModel(model));
    }
}


