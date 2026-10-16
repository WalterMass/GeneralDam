/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica06;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author waltermassari
 */
public class Ejercicio6_2 {

    public static void main(String[] args) {
        exe();
    }
    
    public static void exe(){
        List<Pueblo> pueblos = pueblosGeneradosManualmente();
        
        crearFicheroXML(pueblos);
        
    }
    
    
    // los objetos me los ha generado la ia
    public static List<Pueblo> pueblosGeneradosManualmente(){
        List<Pueblo> pueblos = 
        new ArrayList<>(List.of(
             new Pueblo("Valdemora", 120, List.of(
                 new Vivienda("Calle Mayor 1", List.of(
                     new Habitante("Juan", "García López", 1985),
                     new Habitante("María", "García López", 1988)
                 )),
                 new Vivienda("Calle Sol 12", List.of(
                     new Habitante("Pedro", "Martínez Ruiz", 1970),
                     new Habitante("Lucía", "Martínez Ruiz", 2001)
                 ))
             )),

             new Pueblo("Robledal", 85, List.of(
                 new Vivienda("Plaza España 3", List.of(
                     new Habitante("Ana", "Fernández Díaz", 1992),
                     new Habitante("Carlos", "Fernández Díaz", 1990)
                 )),
                 new Vivienda("Calle Luna 7", List.of(
                     new Habitante("Elena", "Sánchez Pérez", 1965)
                 ))
             )),

             new Pueblo("Monteverde", 210, List.of(
                 new Vivienda("Avenida del Río 15", List.of(
                     new Habitante("Miguel", "Torres Martín", 1978),
                     new Habitante("Laura", "Torres Martín", 1980),
                     new Habitante("Sofía", "Torres Martín", 2010)
                 )),
                 new Vivienda("Calle Olivo 9", List.of(
                     new Habitante("David", "Romero Gil", 1995)
                 ))
             )),

             new Pueblo("Villaflor", 65, List.of(
                 new Vivienda("Calle Jardín 4", List.of(
                     new Habitante("Isabel", "Navarro Ruiz", 1958),
                     new Habitante("Antonio", "Navarro Ruiz", 1955)
                 )),
                 new Vivienda("Plaza del Molino 2", List.of(
                     new Habitante("Paula", "Moreno Castro", 2003),
                     new Habitante("Javier", "Moreno Castro", 2000)
                 ))
             )),

             new Pueblo("Peñablanca", 175, List.of(
                 new Vivienda("Calle Castillo 10", List.of(
                     new Habitante("Alberto", "Jiménez Soto", 1982),
                     new Habitante("Carmen", "Jiménez Soto", 1984)
                 )),
                 new Vivienda("Camino Real 21", List.of(
                     new Habitante("Daniel", "Ortega León", 1975),
                     new Habitante("Clara", "Ortega León", 2005),
                     new Habitante("Mario", "Ortega León", 2008)
                 ))
             ))
         ));
        
        return pueblos;
    }

    private static void crearFicheroXML(List<Pueblo> listPueblos) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try {
        DocumentBuilder builder = factory.newDocumentBuilder();

        DOMImplementation implementation = builder.getDOMImplementation();

        // Crear el documento con su elemento raíz
        Document documento = implementation.createDocument(
                null, "Pueblos", null
        );
        documento.setXmlVersion("1.0");

        // Obtener el elemento raíz que ya existe
        Element elementoPueblos = documento.getDocumentElement();

        // Recorrer los pueblos
        for (Pueblo pueblo : listPueblos) {
            Element elementoPueblo = documento.createElement("Pueblo");

            elementoPueblo.setAttribute("Nombre", pueblo.getNombre());
            elementoPueblo.setAttribute(
                    "Extension",
                    String.valueOf(pueblo.getExtension())
            );

            // Crear el elemento de viviendas
            Element elementoViviendas =
                    documento.createElement("Viviendas");

            // Recorrer las viviendas del pueblo actual
            for (Vivienda vivienda : pueblo.getViviendas()) {
                Element elementoVivienda = documento.createElement("Vivienda");
                elementoVivienda.setAttribute(
                        "Direccion",
                        vivienda.getDirecion()
                );

                // Crear el elemento de habitantes
                Element elementoHabitantes = documento.createElement("Habitantes");

                // Recorrer los habitantes de la vivienda actual
                for (Habitante habitante : vivienda.getHabitantes()) {
                    Element elementoHabitante =
                            documento.createElement("Habitante");

                    elementoHabitante.setAttribute(
                            "Nombre", habitante.getNombre()
                    );
                    elementoHabitante.setAttribute(
                            "Apellidos", habitante.getApellidos()
                    );
                    elementoHabitante.setAttribute(
                            "AñoNacimiento",
                            String.valueOf(habitante.getAñoNacimiento())
                    );

                    elementoHabitantes.appendChild(elementoHabitante);
                }

                elementoVivienda.appendChild(elementoHabitantes);
                elementoViviendas.appendChild(elementoVivienda);
            }

            elementoPueblo.appendChild(elementoViviendas);
            elementoPueblos.appendChild(elementoPueblo);
        }

        // Guardar el XML
        File archivo = new File("src/Files/practica6/pueblos.xml");

        File carpeta = archivo.getParentFile();
        if (carpeta != null) {
            carpeta.mkdirs();
        }

        Source source = new DOMSource(documento);
        Result result = new StreamResult(archivo);

        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();
        //Formato para el xml
        transformer.setOutputProperty(
            javax.xml.transform.OutputKeys.INDENT, "yes"
        );
        transformer.setOutputProperty(
            "{http://xml.apache.org/xslt}indent-amount", "4"
        );
       

        transformer.transform(source, result);

        System.out.println("Archivo XML creado correctamente.");

    } catch (ParserConfigurationException | TransformerException ex) {
        ex.printStackTrace();
    }
}

   
}


/*
2. Crea un programa que guarde la información de varios objetos de tipo
Pueblo.
a. De cada pueblo conocemos:
i. Nombre
ii. Extensión
iii. Viviendas que lo componen
b. Cada vivienda tiene una dirección y alberga un número
indeterminado de habitantes.
c. De cada uno de los habitantes conocemos los siguientes datos:
i. Nombre
ii. Apellidos
iii. Año de nacimiento
Queremos que el programa sea capaz de guardar en un fichero xml un
número indeterminado de pueblos con todas sus viviendas
correspondientes y habitantes distribuidos en sus respectivas viviendas.
*/