import java.util.ArrayList;
import java.util.List;

public class ServicioDFS {

    private Grafo<?> grafo;
    private List<Integer> visitados;

    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.visitados = new ArrayList<>();
    }

    public List<Integer> dfsForest(int verticeInicial) {
        this.visitados.clear();
        visitar(verticeInicial);
        return new ArrayList<>(this.visitados);
    }

    private void visitar(int vertice) {
        this.visitados.add(vertice);
        List<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        if (adyacentes != null){
            for (int adyacente : adyacentes) {
                if (!this.visitados.contains(adyacente)) {
                    visitar(adyacente);
                }
            }
        }

    }
}
