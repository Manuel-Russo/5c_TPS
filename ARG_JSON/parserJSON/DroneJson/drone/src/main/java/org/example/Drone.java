package org.example;

public class Drone {
    private int longitudine;
    private int latitudine;
    private int altitudine;

    public Drone(int longitudine, int latitudine, int altitudine) {
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.altitudine = altitudine;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "longitudine=" + longitudine +
                ", latitudine=" + latitudine +
                ", altitudine=" + altitudine +
                '}';
    }
}
