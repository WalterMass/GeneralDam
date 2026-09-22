package T1.carreras;

public class LanzarCarrera {
    static int PARTICIPANTES = 4;
    static Corredor[] corredores = new Corredor[PARTICIPANTES];
    void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando Carrera");
        for (int i = 0; i < PARTICIPANTES; i++){
            String name = "Corredor-"+(i+1);
            Corredor corredor = new Corredor(name);
            corredores[i] = corredor;
            corredor.start();
        }

        System.out.println();
        System.out.println("Corredores");

        for (Corredor corredor: corredores) {
            corredor.join();
        }


        System.out.println("Final de Carrera ha ganado el corredor "+mostrarGanador());

        mostrarPodium();
    }

    public Corredor mostrarGanador(){
        bubbleSort();
        return corredores[0];
    }

    public void mostrarPodium(){
        System.out.println("\n\n\n");
        for (int i = 0; i < 3; i++){
            System.out.println("Nº"+(i+1)+" "+corredores[i]);
        }
    }

    public void bubbleSort(){

        for (int i = 0; i < corredores.length-1; i++){
            for (int j = 0; j < corredores.length-1; j++){
                Corredor resto;
                if (corredores[j].getTiempo() > corredores[j+1].getTiempo()){
                    resto = corredores[j];
                    corredores[j] = corredores[j+1];
                    corredores[j+1] = resto;
                }
            }
        }

    }

}
