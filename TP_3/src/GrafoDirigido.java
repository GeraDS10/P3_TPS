import java.util.LinkedList;

public class GrafoDirigido<T> extends Grafo<T> {

    private LinkedList<LinkedList<T>> vertices;

    public GrafoDirigido(){
        vertices = new LinkedList<>();
    }

    public void agregarVertice(T nuevoVertice){
        LinkedList<T> lista = new LinkedList<T>();
        if (!lista.contains(nuevoVertice)){
            lista.add(nuevoVertice);
            this.vertices.add(lista);
        }
    }

    public void agregarAdyacencia(T vertice, T nuevaAdyacencia){
        for (int i = 0; i <this.vertices.size() ; i++) {
            if (this.vertices.get(i).get(0).equals(vertice)){
                //luego considerar buscar que existe el vertice adyacente
                this.vertices.get(i).add(nuevaAdyacencia);
                //System.out.println("Agregando adyacencia");
            }
        }
        /*
        int i = 0;
        if ((vertices.contains(vertice)) && (vertices.contains(nuevaAdyacencia))){
            while ((i < vertices.size()) && (vertice.equals(vertices.get(i)))){
                i++;
            }
            if (vertice.equals(vertices.get(i))){
                System.out.println("Agregando adyacencia");
                vertices.get(i).add(nuevaAdyacencia);
            }
        }

         */
    }

    @Override
    public LinkedList<LinkedList<T>> getVertices() {
        return this.vertices;
    }
}
