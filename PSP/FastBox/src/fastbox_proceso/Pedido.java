package fastbox_proceso;

import fastbox_utilities.EstadoPedido;

public class Pedido extends Thread implements Runnable{
    private String idPedido;
    private int cantidadProducto;
    private EstadoPedido estado = null;
    private String codigoEtiqueta = null;
    private Recursos recursos;

    public Pedido(String idPedido, int cantidadProducto, Recursos recursos) {
        this.cantidadProducto = cantidadProducto;
        this.idPedido = idPedido;
        this.recursos = recursos;
    }

    @Override
    public void run(){
        try{
            this.estado = EstadoPedido.CREADO;
            System.out.println("Creado: "+this);
            recursos.prepararPedido(this);
            recursos.etiquetarPedido(this);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getCodigoEtiqueta() {
        return codigoEtiqueta;
    }

    public void setCodigoEtiqueta(String codigoEtiqueta) {
        this.codigoEtiqueta = codigoEtiqueta;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    @Override
    public String toString() {
        return
                "Id: " + idPedido +
                "; Codigo de Etiqueta:" + ((codigoEtiqueta != null) ? codigoEtiqueta: "null") +
                "; cantidadProducto: " + cantidadProducto+
                "; Estado:" + estado;
    }

}
