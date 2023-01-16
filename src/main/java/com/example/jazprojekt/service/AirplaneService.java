package com.example.jazprojekt.service;

import com.example.jazprojekt.model.Airplane;
import com.example.jazprojekt.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {
    private AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public Airplane createAirplane(Airplane airplane) {
        if(airplane.getId() != null) {
            throw new IllegalArgumentException("Airplane id must be null");
        }
        if(airplane.getMake() == null) {
            throw new IllegalArgumentException("Airplane make must not be null");
        }
        if(airplane.getModel() == null) {
            throw new IllegalArgumentException("Airplane model must not be null");
        }
        if(airplane.getCapacity() > 1 && airplane.getCapacity() < 800) {
            throw new IllegalArgumentException("Airplane capacity must be realistic :D");
        }
        return airplaneRepository.save(airplane);
    }
    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Airplane getAirplaneById(Long id) {
        Optional<Airplane> a = airplaneRepository.findById(id);
        if(a.isPresent()) {
            return a.get();
        }
        throw new IllegalArgumentException("Airplane with id " + id + " not found");
    }



    public Airplane updateAirplane(Long id, Airplane airplane) {
        Airplane airplaneToUpdate = getAirplaneById(id);
        if(airplane.getMake() != null) {
            airplaneToUpdate.setMake(airplane.getMake());
        }
        if(airplane.getModel() != null) {
            airplaneToUpdate.setModel(airplane.getModel());
        }
        if(airplane.getCapacity() > 1 && airplane.getCapacity() < 800) {
            airplaneToUpdate.setCapacity(airplane.getCapacity());
        }
        return airplaneRepository.save(airplaneToUpdate);
    }

    public void deleteAirplaneById(Long id) {
        airplaneRepository.deleteById(id);
    }

    public List<Airplane> getAirplanesByMake(String make) {
        return airplaneRepository.findAirplanesByMake(make);
    }

    public List<Airplane> getAirplanesByModel(String model) {
        return airplaneRepository.findAirplanesByModel(model);
    }
}
