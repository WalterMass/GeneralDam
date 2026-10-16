package walter_massari_barros_iihoshi_practica04;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */
public class Ejercicio4_9 {
    
    public static void main(String[] args) {
        String rutaOrg = "src/Files/ejemplo.jpg";
        File fileOrg = new File(rutaOrg);
        
        String rutaDst = "src/Files/Backup/destino";
        File fileDst = new File(rutaDst);
        
        try{
            if (!fileOrg.exists()){
                throw new ExcepcionFicheroOrigenNoEncontrado("No se ha podido encontrar el archivo de origne");
            }
            if (!fileDst.exists()){
                
                fileDst.getParentFile().mkdirs();
                fileDst.createNewFile();
            }
            actividad9(fileOrg, fileDst);
            
        }catch (ExcepcionFicheroOrigenNoEncontrado | IOException e){
            System.out.println(e.getMessage()); 
        }
    }
    
    public static void actividad9(File org, File dst)throws NoSuchFileException, IOException{
        FileInputStream fis = new FileInputStream(org);
        FileOutputStream fos = new FileOutputStream(dst);
        byte[] buffer = new byte[1024];
        int lectura;
        while((lectura = fis.read(buffer)) != -1){
            fos.write(buffer, 0, lectura);
        }
    }
    
    /*9. Crea una herramienta en Java para realizar duplicaciones de seguridad
    de ficheros binarios copiando sus datos en bloques de memoria de
    tamaño fijo. El programa debe verificar en primer lugar la presencia del
    archivo de origen; si este no existe, debe lanzar y capturar una excepción
    propia personalizada denominada ExcepcionFicheroOrigenNoEncontrado.
    Si la carpeta de destino no existe en el sistema, la aplicación creará toda
    la estructura de directorios necesaria antes de iniciar la copia. La copia se
    realizará leyendo el archivo de origen en tramos de 1024 bytes e
    inscribiéndolos de forma continua en el fichero de destino, garantizando
    la liberación limpia de los recursos de entrada y salida empleados.*/
    
}
