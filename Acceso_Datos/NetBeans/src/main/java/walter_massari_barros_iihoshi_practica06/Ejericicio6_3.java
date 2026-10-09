/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica06;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author waltermassari
 */
public class Ejericicio6_3 {
    public static void main(String[] args) {
        actividad3();
    }
    
    public static void actividad3(){
        File org = new File("src/Files/practica6/camiones.xml");
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document documento = builder.parse(org);
//            documento.getDocumentElement().normalize();
            
            NodeList listaCamiones = documento.getElementsByTagName("camion");
            
            for (int i = 0; i < listaCamiones.getLength(); i++){
                Node nodo = listaCamiones.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element camion = (Element) nodo;
                    
                    String matricula  = camion.getAttribute("matricula");
                    String marca = camion.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = camion.getElementsByTagName("modelo").item(0).getTextContent();
                    String anio = camion.getElementsByTagName("anio").item(0).getTextContent();
                    
                    System.out.println("camion: "+matricula+"; "+marca+"; "+modelo+"; "+anio);
                }
            }
        }catch(ParserConfigurationException | SAXException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
3. Crea un programa que lea un fichero XML que contenga la información de
una serie de camiones, los almacene en una lista de la clase Camion y,
finalmente, recorra dicha lista y muestre por pantalla todos los camiones
leídos y sus características.
A continuación se muestra el contenido de un posible fichero
camiones.xml:
*/    