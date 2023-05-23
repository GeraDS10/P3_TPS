import java.util.List;

public class Main {
    public static void main(String[] args) {

        GrafoDirigido grafo = new GrafoDirigido();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1, 2, "A");
        grafo.agregarArco(2, 3, "B");
        grafo.agregarArco(3, 4, "C");
        grafo.agregarArco(3, 4, "D");
        grafo.agregarArco(4, 5, "E");
        grafo.agregarArco(1, 3, "F");
        grafo.agregarArco(1, 4, "G");
        grafo.agregarArco(1, 5, "H");

        System.out.println("Grafo dirigido inicial:");
        System.out.println(grafo);
        System.out.println("Adyacentes vertice 1 -> " + grafo.obtenerAdyacentes(1));
        System.out.println("Adyacentes vertice 3 -> " + grafo.obtenerAdyacentes(3));

        System.out.println("¿Existe el arco (2, 3)? " + grafo.existeArco(2, 3));
        System.out.println("¿Existe el arco (1, 4)? " + grafo.existeArco(1, 4));
        System.out.println("Borrando vertice 3 y adyacencias");;
        grafo.borrarVertice(3);
        System.out.println("Adyacentes vertice 3 -> " + grafo.obtenerAdyacentes(3));
        System.out.println("¿Existe el arco (2, 3)? " + grafo.existeArco(2, 3));
        System.out.println("¿Existe el arco (3, 4)? " + grafo.existeArco(3, 4));


        ServicioDFS servicioDFS = new ServicioDFS(grafo);
        List<Integer> recorridoDFS = servicioDFS.dfsForest(1);
        System.out.println("Recorrido DFS desde el vértice 1: " + recorridoDFS);

        ServicioBFS servicioBFS = new ServicioBFS(grafo);
        List<Integer> recorridoBFS = servicioBFS.bfsForest(1);
        System.out.println("Recorrido BFS desde el vértice 1: " + recorridoBFS);


        ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, 1, 5, 3);
        List<List<Integer>> caminos = servicioCaminos.caminos();
        System.out.println("Caminos encontrados:");
        for (List<Integer> camino : caminos) {
            System.out.println(camino);
        }
    }
}
