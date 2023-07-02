import java.util.*;

class GrafoNoDirigido<T> implements Grafo<T> {
    private Map<Integer, LinkedList<Integer>> vertices;
    private LinkedList<Arco<T>> arcos;

    public GrafoNoDirigido() {
        vertices = new HashMap<>();
        arcos = new LinkedList<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId)){
            vertices.put(verticeId, new LinkedList<>());
        }
    }

    @Override
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

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        vertices.get(verticeId1).add(verticeId2);
        vertices.get(verticeId2).add(verticeId1);
        arcos.add(new Arco<>(verticeId1, verticeId2, etiqueta));

    }

    @Override
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
            LinkedList<Integer> listaAdyacentesV2 = vertices.get(verticeId2);
            if (listaAdyacentesV2 != null) {
                listaAdyacentesV2.remove(Integer.valueOf(verticeId1));
            }
        }
    }
    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Iterator<Arco<T>> iterador = arcos.iterator();
        boolean resultado = false;
        while (iterador.hasNext()){
            Arco<T> arco = iterador.next();
            if ((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2) || (arco.getVerticeOrigen() == verticeId2) && (arco.getVerticeDestino() == verticeId1)){
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
            if ((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2) || (arco.getVerticeOrigen() == verticeId2) && (arco.getVerticeDestino() == verticeId1)){
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        return arcos.size();
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
        return arcos.iterator();
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