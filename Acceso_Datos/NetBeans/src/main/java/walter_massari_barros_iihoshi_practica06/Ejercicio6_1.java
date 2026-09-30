/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica06;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author alumno
 */
public class Ejercicio6_1 {
    public static void main(String[] args) {
        try{
            actividad1();
        }catch(IOException e){
        }
    }

    private static void actividad1() throws IOException{
        File librosXml = new File("src/Files/practica6/libros.xml");
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        
        List<Libro> libros = new ArrayList<>();
        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(librosXml);
            NodeList nodes = document.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++){
                NamedNodeMap atributos = nodes.item(i).getAttributes();
                
                Libro libro = new Libro(
                    atributos.getNamedItem("titulo").getNodeValue(),
                    atributos.getNamedItem("autor").getNodeValue(),
                    atributos.getNamedItem("isbn").getNodeValue(),
                    atributos.getNamedItem("genero").getNodeValue()                    
                );
                
                libros.add(libro);
                
            }
            
            libros.forEach(l -> System.out.println(l));
            
        }catch(ParserConfigurationException | SAXException e){
            System.out.println(e.getMessage());
        }
        
    }
}
/* 
1. Crea un programa que lea una lista de libros y los almacene en un fichero
XML.
a. De cada uno de los libros conocemos los siguientes datos:
i. Título
ii. Autor
iii. ISBN
iv. Género
*/