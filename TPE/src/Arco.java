public class Arco<T> {
    private int origen;
    private int destino;
    private T etiqueta;

    public Arco(int origen, int destino, T etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return this.origen;
    }



    public int getVerticeDestino() {
        return this.destino;
    }

    public T getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public String toString() {
        return "Arco{" +
                "origen=" + origen +
                ", destino=" + destino +
                ", etiqueta=" + etiqueta +
                '}';
    }
}
