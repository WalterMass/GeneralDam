package walter_massari_barros_iihoshi_practica01;

public class Ejercicio4 {
    /*
    4. Crea un clase Persona que tenga como atributos nombre, apellidos, edad
    y DNI. Debemos evitar, mediante el uso de excepciones, que se
    introduzca una edad menor de 18 y mayor de 120, ya sea al crear el objeto
    o al modificar el valor de edad.
    */
    static void main(String[] args) throws Exception {
        Persona oscar = new Persona("Oscar", "Lopez", 38, "000000000");
        System.out.println(oscar);
//        Persona walter = new Persona("Walter Massari", "Barros Iihoshi", 17, "00000000");
        oscar.setEdad(121);

    }
}
class Persona{
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;

    public Persona(String nombre, String apellidos, int edad, String dni) throws Exception {
        String mensaje = "No es posible crear a "+nombre+ " porque es ";
        System.out.println();
        if (edad < 18){
            throw new Exception(mensaje + " menor de 18");
        }else if (edad > 120){
            throw new Exception(mensaje + " mayor de 120");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad) throws Exception{
        String mensaje = "No es posible modificar a "+nombre+ " porque la edad es ";
        if (edad < 18){
            throw new Exception(mensaje + " menor de 18");
        }else if (edad > 120){
            throw new Exception(mensaje + " mayor de 120");
        }
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                '}';
    }
}
