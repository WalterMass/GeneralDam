/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alumno
 */
public class Ejercicio5_3 {
    
    public static void main(String[] args) {
        exe();
    }
    
    public static void exe(){
        File dst = new File("src/Files/practica5/alimentos.dat");
        List<Alimento> alimentos = generarListaAlimentos(10);
        serializar(dst, alimentos);
        desSerializar(dst);
    }
    
    public static void desSerializar(File org){
        System.out.println("Alimentos des serializados");
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Alimento alimento;
        
        try{
            fis = new FileInputStream(org);
            ois = new ObjectInputStream(fis);
            
            do{
                if (fis.available() == 0) break;
                
                alimento = (Alimento) ois.readObject();
                System.out.println(alimento);
            }while (true);
        }catch(Exception e){}
        
        
    }
    
    public static void serializar(File dst, List<Alimento> lista){
        try(ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(dst)) ){
            if (dst.exists()){
                dst.createNewFile();
            }
            
            for(Alimento a : lista){
                oos.writeObject(a);
            }
            
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static List<Alimento> generarListaAlimentos(int cantidad){
        List<Alimento> alimentos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Alimento alimento = new Alimento();
            do{
                
                int energia = randomInt(500);
                int hidratosCarbono = randomInt(50);
                int azucares = randomInt(50);
                int grasasSaturadas = randomInt(30);
                int grasasInsaturadas = randomInt(20);
                int proteina = randomInt(5);
                
                alimento = new Alimento(
                        "void", 
                        energia, 
                        hidratosCarbono, 
                        azucares, 
                        grasasSaturadas, 
                        grasasInsaturadas, 
                        proteina);
            } while(Alimento.comprobarAlimento(alimento) != 100);
            
            alimento.setId(String.valueOf(i+1));
            alimentos.add(alimento);
        }
        
        System.out.println("Alimentos Creados");
        alimentos.forEach(a ->{ System.out.println(a + " "+Alimento.comprobarAlimento(a));});
        return alimentos;
    }
    
    public static int randomInt(int bound){
        Random rand = new Random();
        return rand.nextInt(1, bound);
    }
    
    
    /*
    Unidad de trabajo 01
3. Crea un programa que cumpla los siguientes requerimientos:
a. Una clase alimento con los siguientes atributos
i. Id
ii. Energía que aporta por 100g
iii. Hidratos de carbono en 100g
iv. Azúcares en 100g (deben estar dentro del límite de los
hidratos de carbono)
v. Grasas saturadas en 100g
vi. Grasas insaturadas en 100g
vii. Proteínas en 100g
    
b. La suma de Hidratos de carbono, grasas saturadas, grasas
insaturadas y proteínas debe ser 100g
    
c. El programa generará 10 alimentos aleatorios. Los datos
numéricos deben ser aleatorios, pero deben seguir las limitaciones
indicadas anteriormente.
    
d. Después de generarlos, el programa recogerá estos 10 elementos
y los almacenará un fichero serializado.
    
e. A continuación, el programa leerá el fichero generado y
comparará que los datos de los alimentos que hemos recuperado
coinciden con los que ya teníamos.
Página | 3
    */
}
