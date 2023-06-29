import java.util.*;

public class ServicioBFS {
    private Grafo<?> grafo;

    public ServicioBFS(Grafo<?> grafo) {
        this.grafo = grafo;
    }
    public List<Integer> bfsForest() {
        List<Integer> visitados = new ArrayList<>();
        Queue<Integer> cola = new LinkedList<>();

        for (int vertice = 0; vertice < grafo.cantidadVertices(); vertice++) {
            if (!visitados.contains(vertice)) {
                cola.add(vertice);
                visitados.add(vertice);

                while (!cola.isEmpty()) {
                    int verticeActual = cola.poll();
                    Iterator<?> adyacentesIterator = grafo.obtenerAdyacentes(verticeActual);
                    if (adyacentesIterator != null) {
                        while (adyacentesIterator.hasNext()) {
                            int adyacente = (int) adyacentesIterator.next();
                            if (!visitados.contains(adyacente)) {
                                cola.add(adyacente);
                                visitados.add(adyacente);
                            }
                        }
                    }
                }
            }
        }
        return visitados;
    }
}
