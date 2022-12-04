public class Libro {
    private String autore;
    private String titolo;
    private String genere;
    private double prezzo;

    public Libro(String autore, String titolo, String genere, double prezzo)    {
        this.autore = autore;
        this.titolo = titolo;
        this.genere = genere;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Autore: " + autore +
                ", Titolo: " + titolo +
                ", Genere: " + genere +
                ", Prezzo: " + prezzo;
    }
}
