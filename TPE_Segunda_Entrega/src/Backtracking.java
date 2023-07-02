import java.util.*;
public class Backtracking {
    private GrafoNoDirigido<Integer> grafo;
    private List<Arco<Integer>> arcos;
    private ArrayList<ArrayList<Arco>> solucionesArcos;
    private int iteracionSobreArcos;


    public Backtracking(List<Arco<Integer>> arcos) {
        this.arcos = arcos;
        construirGrafo();
        solucionesArcos = new ArrayList<>();
        int iteracionSobreArcos = 0;

    }

    private void construirGrafo() {
        grafo = new GrafoNoDirigido<>();
        for (Arco<Integer> arco : arcos) {
            int verticeOrigen = arco.getVerticeOrigen();
            int verticeDestino = arco.getVerticeDestino();
            grafo.agregarVertice(verticeOrigen);
            grafo.agregarVertice(verticeDestino);
            grafo.agregarArco(verticeOrigen, verticeDestino, arco.getEtiqueta());
        }
    }

    public void encontrarRedSubterraneos() {
        Iterator listaVertices = grafo.obtenerVertices();
        ArrayList<Integer> vertices = new ArrayList<>();
        while (listaVertices.hasNext()){
            vertices.add( (int) listaVertices.next());
        }
        Iterator listaArcos = grafo.obtenerArcos();
        ArrayList<Arco> arcos = new ArrayList<>();
        while (listaArcos.hasNext()){
            arcos.add( (Arco) listaArcos.next());
        }
        ArrayList<Arco> caminoActual;
        int numeroArco;
        for (int vertice: vertices
             ) {
            numeroArco = 0;
            caminoActual = new ArrayList<>();
            backtrack(vertice, vertices.size(), arcos, caminoActual, numeroArco);
        }

        imprimirSolucion(obtenerMejorSolucion());
    }


    private void backtrack(int vertice, int cantidadVertices, ArrayList<Arco> listaArcos, ArrayList<Arco> caminoActual, int numeroArco) {
        if (caminoActual.size() == cantidadVertices -1){
            solucionesArcos.add(caminoActual);
        } else if (numeroArco < listaArcos.size()-1) {
            Arco a = listaArcos.get(numeroArco);
            if ((a.getVerticeOrigen() == vertice) || (a.getVerticeDestino() == vertice)){
                caminoActual.add(a);
            }
            numeroArco++;
            iteracionSobreArcos++;
            backtrack(vertice, cantidadVertices, listaArcos, caminoActual, numeroArco);
        }
    }

    private ArrayList<Arco> obtenerMejorSolucion(){
        int mejorResultado = 0;
        ArrayList<Arco> mejorSolucion = new ArrayList<>();
        for (ArrayList<Arco> s: this.solucionesArcos
             ) {
            int suma = 0;
            for (Arco a: s
                 ) {
                suma += (int) a.getEtiqueta();
            }
            if (mejorResultado == 0){
                mejorResultado = suma;
                mejorSolucion = s;
            } else if (suma < mejorResultado) {
                mejorResultado = suma;
                mejorSolucion = s;
            }
        }
        return mejorSolucion;
    }
    private void imprimirSolucion(ArrayList<Arco> solucion){
        System.out.println("Backtraking");
        int total = 0;
        for (Arco a: solucion
             ) {
            System.out.print(a.getVerticeOrigen() + "-" + a.getVerticeDestino() + ",");
            total += (int) a.getEtiqueta();
        }
        System.out.println("");
        System.out.println(total + " kms");
        System.out.println("Iteraciones sobre arcos = " + iteracionSobreArcos);
    }
}