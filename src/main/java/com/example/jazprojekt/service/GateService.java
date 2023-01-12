package com.example.jazprojekt.service;

//create GateService
import com.example.jazprojekt.model.Gate;
import com.example.jazprojekt.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {

        @Autowired
        private GateRepository gateRepository;

        public List<Gate> getAllGates() {
            return gateRepository.findAll();
        }

        public Gate getGateById(Long id) {
            return gateRepository.findById(id).orElse(null);
        }

        public Gate createGate(Gate gate) {
            return gateRepository.save(gate);
        }

        public Gate updateGate(Gate gate) {
            return gateRepository.save(gate);
        }

        public void deleteGate(Long id) {
            gateRepository.deleteById(id);
        }
}


