package com.example.jazprojekt.service;

import com.example.jazprojekt.model.Airplane;
import com.example.jazprojekt.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Airplane getAirplaneById(Long id) {
        return airplaneRepository.findById(id).orElse(null);
    }

    public Airplane createAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public Airplane updateAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public void deleteAirplane(Long id) {
        airplaneRepository.deleteById(id);
    }
}
