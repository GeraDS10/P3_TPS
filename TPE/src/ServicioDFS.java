import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {

    private Grafo<?> grafo;

    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> dfsForest() {
        List<Integer> visitados = new ArrayList<>();
        for (int vertice = 0; vertice < grafo.cantidadVertices(); vertice++) {
            if (!visitados.contains(vertice)) {
                dfs(vertice, visitados);
            }
        }
        return visitados;
    }

    private void dfs(int vertice, List<Integer> visitados) {
        visitados.add(vertice);
        Iterator<?> adyacentesIterator = grafo.obtenerAdyacentes(vertice);
        if (adyacentesIterator != null) {
            while (adyacentesIterator.hasNext()) {
                int adyacente = (int) adyacentesIterator.next();
                if (!visitados.contains(adyacente)) {
                    dfs(adyacente, visitados);
                }
            }
        }
    }
}
