package T1.repaso_executor.ejercicio5;

public class Ejercicio5 {
    public static final int NUM_FILOSOFOS = 5;
    public static final int NUM_PALILLOS = 5;

    static void main(String[] args) {
        Mesa mesa = new Mesa(NUM_FILOSOFOS, NUM_PALILLOS);
        mesa.empezarComida();
    }
}
/*
Ejercicio 5
Implementar una solución sencilla al problema de la comida de los 5 filósofos de Dijkstra que
evite el interbloqueo.
Cinco filósofos pasan la vida pensando en una mesa redonda y solo dejan de pensar de vez en
cuando para comer de un cuenco de espaguetis. Para ello deben tomar los palillos que tienen a
ambos lados, primero uno y luego otro.
Por supuesto, no pueden coger un palillo si lo está utilizando otro filósofo. Entonces deben
esperar a que termine y lo suelte. Una vez tomado un palillo, no lo sueltan hasta que no
consiguen el otro palillo. Entonces comen y, cuando han terminado de comer, dejan ambos
palillos de nuevo en la mesa.
Se recomienda numerar los filósofos de 0 a 4.
El filósofo i come con los palillos i (a su izquierda) e (i+1) mod 5 (a su derecha).
Ejercicio 5.1
Realiza la misma funcionalidad pero utilizando semáforos.
*/
