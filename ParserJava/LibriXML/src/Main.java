import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        List<Libro> libri = new ArrayList<>();
        try {
            //creo l'istanza per mappare il file XML come struttura ad albero
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //carica il file XML, lo analizza e ritorna un oggetto di tipo Document
            Document document = builder.parse(new File("src/libri.xml"));

            //stampo il tag radice
            System.out.println("Elemento root: " + document.getDocumentElement().getNodeName());

            //genero la lista di libri
            NodeList nodeList = document.getElementsByTagName("libro");

            for (int i = 0; i < nodeList.getLength(); i++)   {
                //estraggo il nodo i-esimo
                //Node node = nodeList.item(i);

                Element element = (Element) nodeList.item(i);

                //estraggo i tag e gli attributi dai singoli nodi
                String genere = element.getAttribute("genere");
                String autore = element.getElementsByTagName("autore").item(0).getTextContent();
                String titolo = element.getElementsByTagName("titolo").item(0).getTextContent();
                double prezzo = Double.parseDouble(element.getElementsByTagName("prezzo").item(0).getTextContent());

                libri.add(new Libro(autore, titolo, genere, prezzo));
            }


        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Errore nel parsing XML");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file XML");
            System.exit(1);
        }

        for (Libro libro: libri) {
            System.out.println(libro);
        }

    }
}
