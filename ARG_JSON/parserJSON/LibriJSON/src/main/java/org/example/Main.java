package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Libro> libri=new ArrayList<>();

        try {
            //creo un oggetto di tipo mapper che serve a fare la mappa del nostro file json
            ObjectMapper mapper=new ObjectMapper();
            //trasforma il nostro file json n una struttura ad albero con il metodo readtree
            JsonNode node=mapper.readTree(new File("src/main/resources/libri.json"));
            //fisso il nodo radice
            JsonNode rootNodes=node.path("libri");
            //System.out.println(rootNodes);
            //mi sposto nel nodo libro e li metto nel mio array libriNode
            JsonNode libriNode =rootNodes.path("libro");
            //uso un foreach per assegnare i vari valori a delle variabili usando il metodo get per scegliere il valore e asText() per parsarli in string e sadoble per parsare in doble
            for (JsonNode libro: libriNode) {
                String autore=libro.get("autore").asText();
                String titolo=libro.get("titolo").asText();
                String genere=libro.get("genere").asText();
                double prezzo=libro.get("prezzo").asDouble();
                //aggiungo le informazioni al mio arraylist
                libri.add(new Libro(titolo,genere,autore,prezzo));
            }
            //stampo i miei oggetti libro (il prof lo ha fatto con un foreach io ho preferito usare un fori normale)
            for (int i = 0; i < libri.size(); i++) {
                System.out.println(libri.get(i));
            }
        } catch (IOException e) {
            System.out.println("ERRORE LETTURA FILE JSON");
            System.exit(1);
        }
    }
}
//per compito