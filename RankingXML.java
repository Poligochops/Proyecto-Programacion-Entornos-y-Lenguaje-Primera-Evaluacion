import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class RankingXML 
{
    // 1. Guarda los arrays paralelos reales en ranking.xml
    public static void guardarXML(String[] nombres, int[] puntos, int total)
    {
        try 
        {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.newDocument();

            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            for (int i = 0; i < total; i++) 
            {
                Element jugador = documento.createElement("jugador");
                jugador.setAttribute("posicion", String.valueOf(i + 1));
                raiz.appendChild(jugador);

                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(nombres[i]);
                jugador.appendChild(nombre);

                Element puntuacion = documento.createElement("puntuacion");
                puntuacion.setTextContent(String.valueOf(puntos[i]));
                jugador.appendChild(puntuacion);
            }

            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformerFabrica.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(new File("ranking.xml"));
            transformer.transform(origen, destino);
        } 
        catch (Exception e) 
        {
            System.out.println("Error generando el XML: " + e.getMessage());
        }
    }

    // 2. Lee ranking.xml y mete los datos en los dos arrays paralelos
    public static int cargarXML(String[] nombres, int[] puntos)
    {
        int total = 0;
        try 
        {
            File archivo = new File("ranking.xml");
            if (!archivo.exists()) return 0;

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList lista = documento.getElementsByTagName("jugador");
            int limite = Math.min(lista.getLength(), 10);

            for (int i = 0; i < limite; i++) 
            {
                Element jugador = (Element) lista.item(i);
                nombres[i] = jugador.getElementsByTagName("nombre").item(0).getTextContent();
                puntos[i] = Integer.parseInt(jugador.getElementsByTagName("puntuacion").item(0).getTextContent());
                total++;
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error al leer el XML: " + e.getMessage());
        }
        return total;
    }

    // 3. Ordena los arrays paralelos (top 10, mayor a menor, empates conservan el antiguo)
    public static int actualizarRanking(String[] nombres, int[] puntos, int total, String nuevoNombre, int nuevosPuntos)
    {
        if (total == 10 && nuevosPuntos <= puntos[9]) 
        {
            return total;
        }

        int pos = total;
        for (int i = 0; i < total; i++) 
        {
            if (nuevosPuntos > puntos[i]) // '>' estricto para mantener el más antiguo en empate
            {
                pos = i;
                break;
            }
        }

        if (total < 10) total++;

        for (int i = total - 1; i > pos; i--) 
        {
            nombres[i] = nombres[i - 1];
            puntos[i] = puntos[i - 1];
        }

        if (pos < 10) 
        {
            nombres[pos] = nuevoNombre;
            puntos[pos] = nuevosPuntos;
        }

        guardarXML(nombres, puntos, total); // Guarda automáticamente en el XML
        return total;
    }

    // 4. Muestra el ranking por consola
    public static void mostrarRanking(String[] nombres, int[] puntos, int total)
    {
        System.out.println("========================================");
        System.out.println("       RANKING DE LA ARENA GESTRAL      ");
        System.out.println("========================================");

        if (total == 0) 
        {
            System.out.println("El ranking está vacío.");
        } 
        else 
        {
            for (int i = 0; i < total; i++) 
            {
                System.out.println((i + 1) + ". " + nombres[i] + " - " + puntos[i] + " puntos");
            }
        }
        System.out.println("========================================");
    }
}