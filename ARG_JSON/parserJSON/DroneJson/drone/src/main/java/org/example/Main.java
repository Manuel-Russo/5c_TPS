package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Drone> posizioni = new ArrayList<>();

        try {
            ObjectMapper mapper=new ObjectMapper();
            JsonNode node=mapper.readTree(new File("src/main/resources/drone.json"));
            JsonNode rootNodes = node.path("percorso");
            JsonNode posizioneNode = rootNodes.path("posizione");
            for (JsonNode posizione: posizioneNode) {
                int longitudine = posizione.get("longitudine").asInt();
                int latitudine = posizione.get("latitudine").asInt();
                int altitudine = posizione.get("altitudine").asInt();
                posizioni.add(new Drone(longitudine,latitudine,altitudine));
            }
            for (Drone spostamenti : posizioni) {
                System.out.println(spostamenti);
            }
        } catch (IOException e) {
            System.out.println("ERRORE LETTURA FILE JSON");
            System.exit(1);
        }

    }
}