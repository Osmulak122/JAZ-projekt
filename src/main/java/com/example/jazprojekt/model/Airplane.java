package com.example.jazprojekt.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String registrationNumber;
    private int capacity;
    private LocalDate productionYear;
    @OneToOne(fetch = FetchType.EAGER)
    private Employee serviceEngineer;

    @OneToOne(fetch = FetchType.EAGER)
    private Gate gate;

    public Airplane() {
    }

    public Airplane(String make, String model, String registrationNumber, int capacity, LocalDate productionYear, Employee serviceEngineer, Gate gate) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.productionYear = productionYear;
        this.serviceEngineer = serviceEngineer;
        this.gate = gate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public Employee getServiceEngineer() {
        return serviceEngineer;
    }

    public void setServiceEngineer(Employee serviceEngineer) {
        this.serviceEngineer = serviceEngineer;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
