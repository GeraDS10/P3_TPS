import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private Map<Integer, LinkedList<Integer>> vertices;
    private LinkedList<Arco<T>> arcos;

    public GrafoDirigido() {
        vertices = new HashMap<>();
        arcos = new LinkedList<>();
    }

    /**
     * Complejidad: O(1) debido a que
     * agregar un par clave -> valor en un map
     * tiene una complejidad constante.
     */
    public void agregarVertice(int vertice) {
        vertices.put(vertice, new LinkedList<>());
    }

    /**
     * Complejidad: O(X) donde X es la cantidad de arcos contenidos
     * en la lista de arcos, debido a que se deben recorrer todos los valores de
     * la lista de arcos para borrar aquellos donde se encuentre el vertice a borrar
     */
    public void borrarVertice(int vertice) {
       vertices.remove(vertice);
        Iterator<Arco<T>> iter = arcos.iterator();
        while (iter.hasNext()) {
            Arco<T> arco = iter.next();
            if (arco.getVerticeOrigen() == vertice || arco.getVerticeDestino() == vertice) {
                iter.remove();
            }
        }
        for (LinkedList<Integer> listaAdyacentes : vertices.values()) {
            listaAdyacentes.remove(Integer.valueOf(vertice));
        }
    }

    /**
     * Complejidad: O(1) debido a que agregar el nuevo arco en la
     * lista de arcos y en la lista de adyacentes del vertice
     * tiene una complejidad constante
     */
    public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
        Arco<T> arco = new Arco<>(verticeOrigen, verticeDestino, etiqueta);
        arcos.add(arco);
        LinkedList<Integer> listaAdyacentes = vertices.get(verticeOrigen);
        if (listaAdyacentes != null) {
            listaAdyacentes.add(verticeDestino);
        }
    }
    /**
     * Complejidad: O(X) donde X es la cantidad de arcos de la lista
     * ya que en el peor de los casos se deben recorrer todos los arcos de la lista
     * para encontrar el arco a borrar
     */
    public void borrarArco(int verticeOrigen, int verticeDestino) {
        if (this.vertices.containsKey(verticeOrigen) && this.vertices.containsKey(verticeDestino)){
            Iterator<Arco<T>> iter = arcos.iterator();
            while (iter.hasNext()) {
                Arco<T> arco = iter.next();
                if (arco.getVerticeOrigen() == verticeOrigen && arco.getVerticeDestino() == verticeDestino) {
                    iter.remove();
                    break;
                }
            }
            LinkedList<Integer> listaAdyacentes = vertices.get(verticeOrigen);
            if (listaAdyacentes != null) {
                listaAdyacentes.remove(Integer.valueOf(verticeDestino));
            }
        }
    }
    /**
     * Complejidad: O(1) debido a que obtener la lista de adyacentes desde el map
     * tiene una complejidad constante al igual que la creacion del arraylist para
     * almacenar los valores encontrados
     */
    public List<Integer> obtenerAdyacentes(int vertice) {
        LinkedList<Integer> listaAdyacentes = vertices.get(vertice);
        if (listaAdyacentes != null) {
            return new ArrayList<>(listaAdyacentes);
        }
        return new ArrayList<>();
    }

    /**
     * Complejidad: O(X) donde X es la cantidad de arcos contenidos en arcos
     * ya que se en el peor de los casos se debe recorrer en su totalidad para
     * comprobar la existencia del arco buscado
     */
    public boolean existeArco(int verticeOrigen, int verticeDestino) {
        for (Arco<T> arco : arcos) {
            if (arco.getVerticeOrigen() == verticeOrigen && arco.getVerticeDestino() == verticeDestino) {
                return true;
            }
        }
        return false;
    }
}
