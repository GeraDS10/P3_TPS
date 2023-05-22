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

        System.out.println("Grafo dirigido inicial:");
        System.out.println(grafo);

        System.out.println("¿Existe el arco (2, 3)? " + grafo.existeArco(2, 3));
        System.out.println("¿Existe el arco (1, 4)? " + grafo.existeArco(1, 4));
    }
}
