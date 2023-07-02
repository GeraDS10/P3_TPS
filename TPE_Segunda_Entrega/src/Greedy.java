import java.util.*;
class Greedy<T> {
    private GrafoNoDirigido<T> grafo;
    private int iteracionesSobreArcos;

    public Greedy(List<Arco<Integer>> arcos) {
        iteracionesSobreArcos = 0;
        grafo = new GrafoNoDirigido<>();
        for (Arco<Integer> arco : arcos) {
            grafo.agregarVertice(arco.getVerticeOrigen());
            grafo.agregarVertice(arco.getVerticeDestino());
            grafo.agregarArco(arco.getVerticeOrigen(), arco.getVerticeDestino(), (T) arco.getEtiqueta());
        }
    }

    public void construirRedSubterraneos() {
        List<Arco<T>> redSubterraneos = new ArrayList<>();
        Iterator<Arco<T>> arcosIterator = grafo.obtenerArcos();
        List<Arco<T>> arcosOrdenados = new ArrayList<>();
        while (arcosIterator.hasNext()) {
            arcosOrdenados.add(arcosIterator.next());
        }
        arcosOrdenados.sort((arco1, arco2) -> ((Integer) arco1.getEtiqueta()).compareTo((Integer) arco2.getEtiqueta()));

        boolean[] visitados = new boolean[grafo.cantidadVertices() + 1];

        for (Arco<T> arco : arcosOrdenados) {
            iteracionesSobreArcos++;
            if (!visitados[arco.getVerticeDestino()]) {
                redSubterraneos.add(arco);
                visitados[arco.getVerticeDestino()] = true;
            }
        }
        imprimirSolucion(redSubterraneos);
    }

    private void imprimirSolucion(List<Arco<T>> solucion){
        int total = 0;
        System.out.println("Greedy");
        for (Arco a : solucion
        ) {
            System.out.print(a.getVerticeOrigen() + "-" + a.getVerticeDestino() + ",");
            total += (int) a.getEtiqueta();
        }
        System.out.println("");
        System.out.println(total + " kms");
        System.out.println("Iteraciones sobre Arcos = " + iteracionesSobreArcos);
    }
}
