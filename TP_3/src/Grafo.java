import java.util.LinkedList;
import java.util.List;

public abstract class Grafo<T> {

    public abstract void agregarVertice(T nuevoVertice);

    public abstract void agregarAdyacencia(T vertice, T nuevaAdyacencia);

    public abstract LinkedList<LinkedList<T>> getVertices();

}
