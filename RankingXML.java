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

public class rankingXML 
{
    // 1. Guarda los arrays paralelos reales en ranking.xml con estilo incrustado
    public static void guardarXML(String[] nombres, int[] puntos, int total)
    {
        try 
        {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.newDocument();

            // Apunta al estilo interno (#estilo-ranking) para que Chrome/Edge no lo bloqueen en local
            org.w3c.dom.ProcessingInstruction xslt = documento.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"#estilo-ranking\"");
            documento.appendChild(xslt);

            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            // Bloque XSLT + CSS incrustado dentro del XML
            Element stylesheet = documento.createElementNS("http://www.w3.org/1999/XSL/Transform", "xsl:stylesheet");
            stylesheet.setAttribute("version", "1.0");
            stylesheet.setAttribute("id", "estilo-ranking");
            raiz.appendChild(stylesheet);

            Element template = documento.createElementNS("http://www.w3.org/1999/XSL/Transform", "xsl:template");
            template.setAttribute("match", "/");
            stylesheet.appendChild(template);

            Element html = documento.createElement("html");
            template.appendChild(html);

            Element head = documento.createElement("head");
            html.appendChild(head);

            Element style = documento.createElement("style");
            style.setTextContent(
                "body { background-color: cornflowerblue; font-family: Arial; padding: 20px; } " +
                "table { border-collapse: collapse; background-color: white; } " +
                "th, td { padding: 8px 15px; text-align: center; } " +
                "th { font-weight: bold; background-color: lightblue; }"
            );
            head.appendChild(style);

            Element body = documento.createElement("body");
            html.appendChild(body);

            Element h1 = documento.createElement("h1");
            h1.setTextContent("Ranking de la Arena Gestral");
            body.appendChild(h1);

            Element table = documento.createElement("table");
            table.setAttribute("border", "1");
            body.appendChild(table);

            Element trHeader = documento.createElement("tr");
            table.appendChild(trHeader);

            String[] columnas = {"Posición", "Nombre", "Puntuación"};
            for (String col : columnas) 
            {
                Element th = documento.createElement("th");
                th.setTextContent(col);
                trHeader.appendChild(th);
            }

            Element forEach = documento.createElementNS("http://www.w3.org/1999/XSL/Transform", "xsl:for-each");
            forEach.setAttribute("select", "ranking/jugador");
            table.appendChild(forEach);

            Element trRow = documento.createElement("tr");
            forEach.appendChild(trRow);

            String[] campos = {"@posicion", "nombre", "puntuacion"};
            for (String campo : campos) 
            {
                Element td = documento.createElement("td");
                Element valueOf = documento.createElementNS("http://www.w3.org/1999/XSL/Transform", "xsl:value-of");
                valueOf.setAttribute("select", campo);
                td.appendChild(valueOf);
                trRow.appendChild(td);
            }

            // Datos reales de los jugadores
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
            if (nuevosPuntos > puntos[i])
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

        guardarXML(nombres, puntos, total);
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