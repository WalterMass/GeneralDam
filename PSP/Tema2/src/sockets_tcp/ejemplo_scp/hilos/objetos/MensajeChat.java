package sockets_tcp.ejemplo_scp.hilos.objetos;

import java.io.Serializable;

public class MensajeChat implements Serializable {
    private String contenidoMensaje;
    private String emisor;
    private String receptor;
    private boolean contieneEmojis;

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public boolean isContieneEmojis() {
        return contieneEmojis;
    }

    public void setContieneEmojis(boolean contieneEmojis) {
        this.contieneEmojis = contieneEmojis;
    }

    @Override
    public String toString() {
        return "MensajeChat{" +
                "contenidoMensaje='" + contenidoMensaje + '\'' +
                ", emisor='" + emisor + '\'' +
                ", receptor='" + receptor + '\'' +
                ", contieneEmojis=" + contieneEmojis +
                '}';
    }
}
