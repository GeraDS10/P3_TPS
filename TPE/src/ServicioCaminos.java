import java.util.ArrayList;
import java.util.List;

public class ServicioCaminos {
    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;
    private List<List<Integer>> caminos;

    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        this.caminos = new ArrayList<>();
    }

    public List<List<Integer>> caminos() {
        this.caminos.clear();
        List<Integer> caminoActual = new ArrayList<>();
        caminoActual.add(this.origen);
        buscarCaminos(this.origen, caminoActual);
        return new ArrayList<>(caminos);
    }

    private void buscarCaminos(int verticeActual, List<Integer> caminoActual) {
        if (verticeActual == destino) {
            caminos.add(new ArrayList<>(caminoActual));
        } else if (caminoActual.size() <= this.lim) {
            List<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);
            for (int adyacente : adyacentes) {
                Arco<String> arco = new Arco<>(verticeActual, adyacente, null);
                if (!existeArcoEnCamino(arco, caminoActual)) {
                    caminoActual.add(adyacente);
                    this.buscarCaminos(adyacente, caminoActual);
                    caminoActual.remove(caminoActual.size() - 1);
                }
            }
        }
    }

    private boolean existeArcoEnCamino(Arco<String> arco, List<Integer> camino) {
        int tamanioCamino = camino.size();
        if (tamanioCamino >= 2) {
            int verticeAnterior = camino.get(tamanioCamino - 2);
            int verticeActual = camino.get(tamanioCamino - 1);
            return arco.getVerticeOrigen() == verticeAnterior && arco.getVerticeDestino() == verticeActual;
        }
        return false;
    }
}
