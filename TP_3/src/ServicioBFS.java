import java.util.LinkedList;

public class ServicioBFS<T> {

    LinkedList<T> visitados;
    LinkedList<T> noVisitados;
    LinkedList<LinkedList<T>> cola;
    Grafo grafo;

    public ServicioBFS(Grafo grafo){
        this.grafo = grafo;
        this.visitados = new LinkedList<>();
        this.noVisitados = new LinkedList<>();
        this.cola = new LinkedList<>();
    }

    public void recorrer(){
        LinkedList<LinkedList<T>> vertices = this.grafo.getVertices();
        this.cola.clear();
        for (int i = 0; i < vertices.size(); i++) {
            noVisitados.add(vertices.get(i).get(0));
        }
        System.out.println("No visitados -> " + this.noVisitados);
        for (int i = 0; i < this.grafo.getVertices().size(); i++) {
            if (this.noVisitados.contains(vertices.get(i).get(0))){
                this.visitar(vertices.get(i), vertices);
            }
        }
        System.out.println(this.cola);
    }

    public void visitar(LinkedList<T> vertice, LinkedList<LinkedList<T>> vertices){
        System.out.println("visitando -> " + vertice.get(0));
        this.visitados.add(vertice.get(0));
        this.noVisitados.remove(vertice.get(0));
        this.cola.add(vertice);
        System.out.println("Agregando a cola -> " + vertice.get(0));
        while (!this.cola.isEmpty()){
            LinkedList<T> x = (LinkedList<T>) cola.remove();
            System.out.println("Sacando de cola ====> " + x.get(0));
            for (int i = 0; i < x.size(); i++) {
                if (this.noVisitados.contains(x.get(i))){
                    this.visitados.add(x.get(i));
                    this.noVisitados.remove(x.get(i));
                    int j = 0;
                    while (vertices.get(j).get(0) != x.get(i)){
                        j++;
                    }
                    this.cola.add(vertices.get(j));
                    System.out.println("Agregando a cola --> " + vertices.get(j).get(0));
                }
            }
        }

    }
}
