package org.example;

public class Libro {
    private String titolo;
    private String genere;
    private String autore;
    private double prezzo;

    public Libro(String titolo, String genere, String autore, double prezzo) {
        this.titolo = titolo;
        this.genere = genere;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return  "titolo='" + titolo +
                ", genere='" + genere +
                ", autore='" + autore +
                ", prezzo=" + prezzo ;
    }
}
