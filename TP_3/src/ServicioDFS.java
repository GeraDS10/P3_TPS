import java.util.LinkedList;

public class ServicioDFS<T> {

    private Grafo grafo;
    private LinkedList<T> blancos;
    private LinkedList<T> amarillos;
    private LinkedList<T> negros;

    public ServicioDFS(Grafo grafo){
        this.grafo = grafo;
        blancos = new LinkedList<>();
        amarillos = new LinkedList<>();
        negros = new LinkedList<>();
    }

    public void recorrer(){
        LinkedList<LinkedList<T>> vertices = this.grafo.getVertices();
        for (int i = 0; i < vertices.size(); i++) {
            this.blancos.add(vertices.get(i).get(0));
        }
        for (int i = 0; i < vertices.size(); i++) {
            if (this.blancos.contains(vertices.get(i).get(0))){
                System.out.println("Recorriendo vertice = " + vertices.get(i).get(0));
                this.visitar(vertices.get(i), vertices);
            }
        }

        System.out.println("Vertices visitados " + this.negros);
    }

    public void visitar(LinkedList<T> vertice, LinkedList<LinkedList<T>> vertices){
        this.amarillos.add(vertice.get(0));
        System.out.println("Colocando amarillo = " + vertice.get(0));
        this.blancos.remove(vertice.get(0));
        if (vertice.size() >= 1){
            for (int i = 1; i < vertice.size(); i++) {
                //System.out.println("Vertice -> " + vertice.get(i));
                if (this.blancos.contains(vertice.get(i))){
                    //System.out.println("Visitando vertice = " + vertice.get(i));
                    int v = 0;
                    while ((!vertices.get(v).get(0).equals(vertice.get(i))) && (v <= vertices.size())){
                        v++;
                    }
                    if (v <= vertices.size()){
                        this.visitar(vertices.get(v), vertices);
                    }
                }
                else{
                    if (this.amarillos.contains(vertice.get(i))){
                        System.out.println("Hay ciclo = " + vertice.get(0) + " -> " + vertice.get(i));
                    }
                }
            }
        }

        this.negros.add(vertice.get(0));
        System.out.println("Colocando negro vertice -> " + vertice.get(0));
        this.amarillos.remove(vertice.get(0));
    }

}
