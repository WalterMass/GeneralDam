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
public class Ejercicio6_4 {
    public static void main(String[] args) {
        actividad4();
    }
    
    public static void actividad4(){
        File org = new File("src/Files/practica6/juegos.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document documento = builder.parse(org);
            Element raiz = documento.getDocumentElement();
            NodeList listaTipos = raiz.getChildNodes();
            
            for (int i=0; i < listaTipos.getLength(); i++){
                Node nodoTipo = listaTipos.item(i);
                if(nodoTipo.getNodeType() == Node.ELEMENT_NODE){
                    Element elementoTipo = (Element) nodoTipo;
                    String tipo = elementoTipo.getTagName().toUpperCase();
                    System.out.println("\n--- Tipo: "+tipo+" ---");
                    NodeList listaJuegos = elementoTipo.getElementsByTagName("juego");
                    for (int j=0; j < listaJuegos.getLength(); j++){
                        Node nodoJuego = listaJuegos.item(j);
                        if (nodoTipo.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoJuego = (Element) nodoJuego;
                            String id = elementoJuego.getAttribute("id");
                            String nombre = elementoJuego.getElementsByTagName("nombre")
                                    .item(0).getTextContent().trim();
                            String minEdad = elementoJuego.getElementsByTagName("minEdad")
                                    .item(0).getTextContent().trim();
                            String minJugadores = elementoJuego.getElementsByTagName("minJugadores")
                                    .item(0).getTextContent().trim();
                            String maxJugadores = elementoJuego.getElementsByTagName("maxJugadores")
                                    .item(0).getTextContent().trim();
                            String tiempoJuego = elementoJuego.getElementsByTagName("tiempoJuego")
                                    .item(0).getTextContent().trim();
                            String tipoJuego = elementoJuego.getElementsByTagName("tipo")
                                    .item(0).getTextContent().trim();
                            System.out.println("\nId = "+ id+
                                    "\n Nombre = "+nombre+
                                    "\n Minimo de Edad = "+minEdad+
                                    "\n Minimo de Jugadores = "+minJugadores+
                                    "\n Maximo de Jugadores = "+maxJugadores+
                                    "\n Tiempo de Juego = "+tiempoJuego+
                                    "\n Tipo = "+tipoJuego
                                    );
                        }
                    }
                }
            }
        }catch(ParserConfigurationException | SAXException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
4. Crear un programa que cargue la información de un fichero xml con una 
estructura similar a la del ejemplo en un objeto colección de juegos. 
Después  de  cargarlo  deberá  escribir  por  pantalla  el  contenido  de  la 
colección de juegos.

*/