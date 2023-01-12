
package com.example.jazprojekt.controller;

import com.example.jazprojekt.model.Airplane;
import com.example.jazprojekt.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/airplane")
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/airplane/{id}")
    public Airplane getAirplaneById(@PathVariable Long id) {
        return airplaneService.getAirplaneById(id);
    }

    @PostMapping("/airplane")
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        return airplaneService.createAirplane(airplane);
    }

    @PutMapping("/airplane/{id}")
    public Airplane updateAirplane(@PathVariable Long id, @RequestBody Airplane airplane) {
        airplane.setId(id);
        return airplaneService.updateAirplane(airplane);
    }

    @DeleteMapping("/airplane/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        airplaneService.deleteAirplane(id);
    }
}


