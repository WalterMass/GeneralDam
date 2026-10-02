/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author alumno
 */
public class Ejercicio6_1 {
    public static void main(String[] args) {
        try{
            actividad1();
        }catch(Exception e){
        }
    }
    
    

    private static List<Libro> crearLibros(){
        File librosCsv = new File("src/Files/practica6/libros.csv");
        
        List<Libro> libros = new ArrayList<>();
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(librosCsv)));
                
                ){
            while(br.ready()){
                String[] linea = br.readLine().split(";");
                Libro libro = new Libro(linea[0],linea[1],linea[2], linea[3]);
                libros.add(libro);
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        return libros;
        
        
    }

    private static void actividad1() {
        List<Libro> libros = crearLibros();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        if (!libros.isEmpty()){
            try {
                builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document documento = implementation.createDocument(
                        null,
                        "clase_libros",
                        null
                );
                
                documento.setXmlVersion("1.0");
                
                Element listaLibros = documento.createElement("Libros");
                for (Libro l:libros){
                    Element libro = documento.createElement("Libro");
                    
                    libro.setAttribute("Titulo", l.getTitulo());
                    libro.setAttribute("Autor", l.getAutor());
                    libro.setAttribute("ISBN", l.getIsbn());
                    libro.setAttribute("Género", l.getGenero());
                    
                    listaLibros.appendChild(libro);
                }
                
                documento.getDocumentElement()
                        .appendChild(listaLibros);
                
                Result result = new StreamResult(new File("src/Files/practica6/libros.xml"));
                Source source = new DOMSource(documento);
                
                Transformer transformer = TransformerFactory.newInstance()
                                                            .newTransformer();
                transformer.transform(source, result);
            } catch (ParserConfigurationException | TransformerConfigurationException ex) {
                System.out.println(ex.getMessage());
            } catch (TransformerException ex) {
                System.getLogger(Ejercicio6_1.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } 
        }else{
            System.out.println("No hay ningun libro para crear el xml");
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