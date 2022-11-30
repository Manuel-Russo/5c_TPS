public class Auto {
    private String classe;
    private String marca;
    private String modello;
    private double cilindrata;

    private double potenza;

    private String alimentazione;
    private double numero_passeggieri;
    private double volume_bagagliaio;

    public Auto(String classe, String marca, String modello, double cilindrata, double potenza, String alimentazione, double numero_passeggieri, double volume_bagagliaio) {
        this.classe = classe;
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.potenza = potenza;
        this.alimentazione = alimentazione;
        this.numero_passeggieri = numero_passeggieri;
        this.volume_bagagliaio = volume_bagagliaio;
    }

    public String getClasse() {
        return classe;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "classe='" + classe + '\'' +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cilindrata=" + cilindrata + " cm3" +
                ", potenza=" + potenza + " Kw" +
                ", alimentazione='" + alimentazione + '\'' +
                ", numero_passeggieri=" + numero_passeggieri +
                ", volume_bagagliaio=" + volume_bagagliaio + " litri" +
                '}';
    }
}
