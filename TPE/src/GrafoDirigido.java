import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    private Map<Integer, List<Integer>> vertices;
    private List<Arco<String>> arcos;

    public GrafoDirigido() {
        vertices = new HashMap<>();
        arcos = new ArrayList<>();
    }

    @Override
    public void agregarVertice(int vertice) {
        vertices.put(vertice, new LinkedList<>());
    }

    @Override
    public void borrarVertice(int vertice) {
        vertices.remove(vertice);
        // Borrar todas las aristas de salida relacionadas con el vértice
        for (List<Integer> adyacentes : vertices.values()) {
            adyacentes.remove((Integer) vertice);
        }
    }

    public void agregarArco(int verticeOrigen, int verticeDestino, String etiqueta) {
        arcos.add(new Arco<>(verticeOrigen, verticeDestino, etiqueta));
        vertices.get(verticeOrigen).add(verticeDestino);
    }


    public void borrarArco(int verticeOrigen, int verticeDestino) {
        arcos.removeIf(arco -> arco.getVerticeOrigen() == verticeOrigen && arco.getVerticeDestino() == verticeDestino);
        vertices.get(verticeOrigen).remove((Integer) verticeDestino);
    }

    public boolean existeArco(int verticeOrigen, int verticeDestino) {
        for (Arco<String> arco : arcos) {
            if (arco.getVerticeOrigen() == verticeOrigen && arco.getVerticeDestino() == verticeDestino) {
                return true;
            }
        }
        return false;
    }
}
