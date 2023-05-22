public class Arco<T> {
    private int origen;
    private int destino;
    private T etiqueta;

    public Arco(int origen, int destino, T etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return origen;
    }

    public int getVerticeDestino() {
        return destino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

}
