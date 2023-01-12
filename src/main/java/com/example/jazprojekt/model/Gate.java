package com.example.jazprojekt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gate")
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int gatenumber;
    private String terminal;
    private String status;
    private boolean isSchengen;
    private boolean isOccupied;

    public Gate() {
    }

    public Gate(int gatenumber, String terminal, String status, boolean isSchengen, boolean isOccupied) {
        this.gatenumber = gatenumber;
        this.terminal = terminal;
        this.status = status;
        this.isSchengen = isSchengen;
        this.isOccupied = isOccupied;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGatenumber() {
        return gatenumber;
    }

    public void setGatenumber(int gatenumber) {
        this.gatenumber = gatenumber;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSchengen() {
        return isSchengen;
    }

    public void setSchengen(boolean schengen) {
        isSchengen = schengen;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
