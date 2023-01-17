package com.example.jazprojekt.service;

//create GateService
import com.example.jazprojekt.model.Gate;
import com.example.jazprojekt.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GateService {

        @Autowired
        private GateRepository gateRepository;

        public List<Gate> getAllGates() {
            return gateRepository.findAll();
        }

        public Gate getGateById(Long id) {
            Optional<Gate> g = gateRepository.findById(id);
            if(g.isPresent()) {
                return g.get();
            }
            throw new IllegalArgumentException("Gate with id " + id + " not found");
        }

        public Gate createGate(Gate gate) {
            if(gate.getId() != null) {
                throw new IllegalArgumentException("Gate id must be null");
            }
            if(gate.getGatenumber() <= 0) {
                throw new IllegalArgumentException("Gate number must be positive");
            }
            if(gate.getTerminal() == null) {
                throw new IllegalArgumentException("Gate terminal must not be null");
            }
            if(gate.getStatus() == null) {
                throw new IllegalArgumentException("Gate status must not be null");
            }
            return gateRepository.save(gate);
        }

        public Gate updateGate(Long id, Gate gate) {
            Gate gateToUpdate = getGateById(id);

            if(gate.getGatenumber() > 0) {
                gateToUpdate.setGatenumber(gate.getGatenumber());
            }
            if(gate.getTerminal() != null) {
                gateToUpdate.setTerminal(gate.getTerminal());
            }
            if(gate.getStatus() != null) {
                gateToUpdate.setStatus(gate.getStatus());
            }
            if(gate.isOccupied() != gateToUpdate.isOccupied()) {
                gateToUpdate.setOccupied(gate.isOccupied());
            }
            if(gate.isSchengen() != gateToUpdate.isSchengen()) {
                gateToUpdate.setSchengen(gate.isSchengen());
            }

            return gateRepository.save(gateToUpdate);
        }

        public void deleteGateById(Long id) {
            gateRepository.deleteById(id);
        }

        public List<Gate> getGatesByTerminal(String terminal) {
            return gateRepository.findGatesByTerminal(terminal);
        }

        public List<Gate> getGatesByStatus(String status) {
            return gateRepository.findGatesByStatus(status);
        }
}


