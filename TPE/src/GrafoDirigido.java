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

    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId)){
            vertices.put(verticeId, new LinkedList<>());
        }

    }

    /**
     * Complejidad: O(X) donde X es la cantidad de arcos contenidos
     * en la lista de arcos, debido a que se deben recorrer todos los valores de
     * la lista de arcos para borrar aquellos donde se encuentre el vertice a borrar
     */

    public void borrarVertice(int verticeId) {
       vertices.remove(verticeId);
        Iterator<Arco<T>> iter = arcos.iterator();
        while (iter.hasNext()) {
            Arco<T> arco = iter.next();
            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                iter.remove();
            }
        }
        for (LinkedList<Integer> listaAdyacentes : vertices.values()) {
            listaAdyacentes.remove(Integer.valueOf(verticeId));
        }
    }

    /**
     * Complejidad: O(1) debido a que agregar el nuevo arco en la
     * lista de arcos y en la lista de adyacentes del vertice
     * tiene una complejidad constante
     */

    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if((this.contieneVertice(verticeId1) && (this.contieneVertice(verticeId2))) && (!existeArco(verticeId1, verticeId2))){
            Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
            arcos.add(arco);
            LinkedList<Integer> listaAdyacentes = vertices.get(verticeId1);
            if (listaAdyacentes != null) {
                listaAdyacentes.add(verticeId1);
            }
        }

    }

    /**
     * Complejidad: O(X) donde X es la cantidad de arcos de la lista
     * ya que en el peor de los casos se deben recorrer todos los arcos de la lista
     * para encontrar el arco a borrar
     */
    public void borrarArco(int verticeId1, int verticeId2) {
        if (this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2)){
            Iterator<Arco<T>> iter = arcos.iterator();
            while (iter.hasNext()) {
                Arco<T> arco = iter.next();
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                    iter.remove();
                    break;
                }
            }
            LinkedList<Integer> listaAdyacentes = vertices.get(verticeId1);
            if (listaAdyacentes != null) {
                listaAdyacentes.remove(Integer.valueOf(verticeId2));
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Iterator<Arco<T>> iterador = arcos.iterator();
        boolean resultado = false;
        while (iterador.hasNext()){
            Arco<T> arco = iterador.next();
            if ((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)){
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        Iterator<Arco<T>> iterador = arcos.iterator();
        boolean resultado = false;
        while (iterador.hasNext()) {
            Arco<T> arco = iterador.next();
            if ((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)){
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        return this.arcos.size();
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        LinkedList<Integer> listaVertices = new LinkedList<>(this.vertices.keySet());
        Iterator<Integer> iteratorVertices = listaVertices.iterator();
        return iteratorVertices;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        LinkedList<Integer> adyacentes = new LinkedList<Integer>();
        if (vertices.containsKey(verticeId)){
            adyacentes = vertices.get(verticeId);
        }
        Iterator<Integer> iteradorAdyacentes = adyacentes.iterator();
        return iteradorAdyacentes;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        Iterator<Arco<T>> iterator = this.arcos.iterator();
        return iterator;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (this.contieneVertice(verticeId)){
            Iterator<Arco<T>> iterator = this.arcos.iterator();
            LinkedList<Arco<T>> encontrados = new LinkedList<Arco<T>>();
            while (iterator.hasNext()){
                Arco<T> arco = iterator.next();
                if ((arco.getVerticeOrigen() == verticeId) || (arco.getVerticeDestino() == verticeId)){
                    encontrados.add(arco);
                }
            }
            Iterator<Arco<T>> iteratorEncontrados = encontrados.iterator();
            return iteratorEncontrados;
        }
        return null;
    }
}
