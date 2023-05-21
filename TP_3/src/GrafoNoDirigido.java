import java.util.LinkedList;
import java.util.List;

public class GrafoNoDirigido<T> extends Grafo<T>{

    private LinkedList<LinkedList<T>> vertices;

    public GrafoNoDirigido(){
        vertices = new LinkedList<>();
    }

    @Override
    public void agregarVertice(T nuevoVertice) {
        LinkedList<T> lista = new LinkedList<T>();
        if (!lista.contains(nuevoVertice)){
            lista.add(nuevoVertice);
            this.vertices.add(lista);
        }
    }

    @Override
    public void agregarAdyacencia(T vertice, T nuevaAdyacencia) {

    }

    @Override
    public LinkedList<LinkedList<T>> getVertices() {
        return this.vertices;
    }
}
