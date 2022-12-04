import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Auto> auto = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/noleggio.xml"));
            NodeList nodeList = document.getElementsByTagName("auto");
            for (int i = 0; i < nodeList.getLength(); i++)   {
                Element element = (Element) nodeList.item(i);

                String classe = element.getElementsByTagName("classe").item(0).getTextContent();
                String marca = element.getElementsByTagName("marca").item(0).getTextContent();
                String modello = element.getElementsByTagName("modello").item(0).getTextContent();
                double cilindrata = Double.parseDouble(element.getElementsByTagName("cilindrata").item(0).getTextContent());
                double potenza = Double.parseDouble(element.getElementsByTagName("potenza").item(0).getTextContent());
                String alimentazione = element.getElementsByTagName("alimentazione").item(0).getTextContent();
                double numero_passeggieri = Double.parseDouble(element.getElementsByTagName("numero_passeggieri").item(0).getTextContent());
                double volume_bagagliaio = Double.parseDouble(element.getElementsByTagName("volume_bagagliaio").item(0).getTextContent());

                auto.add(new Auto(classe, marca, modello, cilindrata, potenza, alimentazione, numero_passeggieri, volume_bagagliaio));
            }
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Errore nel parsing XML");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file XML");
            System.exit(1);
        }

        try {
            System.out.println("Inserisci la classe di auto con alimentazione ibrida che vuoi visualizzare (A,B,C,D,E): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine().toUpperCase();
            for (Auto automobile : auto) {
                if (Objects.equals(automobile.getClasse(), s) && Objects.equals(automobile.getAlimentazione(), "Ibrida"))  {
                    System.out.println(automobile);
                }
            }
        }
        catch(Exception e) {
            System.out.println("Errore nell'inserimento da tastiera");
            System.exit(1);
        }
    }
}