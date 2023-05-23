import java.util.List;

public interface Grafo<T> {

    public void agregarVertice ( int verticeId ) ;
    public void borrarVertice ( int verticeId ) ;
    public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta);
    public void borrarArco(int verticeOrigen, int verticeDestino);
    public boolean existeArco(int verticeOrigen, int verticeDestino);
    public List<Integer> obtenerAdyacentes(int vertice);
}
