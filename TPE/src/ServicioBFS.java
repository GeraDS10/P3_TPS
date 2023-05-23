import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServicioBFS {
    private Grafo<?> grafo;
    private List<Integer> visitados;

    public ServicioBFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.visitados = new ArrayList<>();
    }

    public List<Integer> bfsForest(int verticeInicial) {
        visitados.clear();
        visitar(verticeInicial);
        return new ArrayList<>(this.visitados);
    }

    private void visitar(int verticeInicial) {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(verticeInicial);
        this.visitados.add(verticeInicial);

        while (!cola.isEmpty()) {
            int verticeActual = cola.poll();
            List<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeActual);
            if (adyacentes != null){
                for (int adyacente : adyacentes) {
                    if (!this.visitados.contains(adyacente)) {
                        cola.add(adyacente);
                        this.visitados.add(adyacente);
                    }
                }
            }

        }
    }
}
