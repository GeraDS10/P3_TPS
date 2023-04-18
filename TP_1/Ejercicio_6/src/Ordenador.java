import java.util.Iterator;

public class Ordenador {

    public MySimpleLinkedList ordenadorListasDesordenadas(MySimpleLinkedList listaUno, MySimpleLinkedList listaDos){
        Iterator<Node> iteradorListaUno = listaUno.iterator();
        MySimpleLinkedList nuevaLista = new MySimpleLinkedList<>();
        Node nodoListaDos = (Node) listaDos.get(1);
        while (iteradorListaUno.hasNext()){
            Node nodoListaUno = iteradorListaUno.next();
            while ((nodoListaDos.getNext()!= null)&&(!nodoListaDos.equals(nodoListaDos))){
                nodoListaDos = nodoListaDos.getNext();
            }
            if (nodoListaUno.equals(nodoListaDos)){
                nuevaLista.insertarOrdenado(nodoListaDos);
            }
        }
        return nuevaLista;
    }

     public MySimpleLinkedList ordenadorListasOrdenadas(MySimpleLinkedList listaUno, MySimpleLinkedList listaDos){
         Iterator<Node> iteradorListaUno = listaUno.iterator();
         MySimpleLinkedList nuevaLista = new MySimpleLinkedList<>();
         Node nodoListaDos = (Node) listaDos.get(1);
         while (iteradorListaUno.hasNext()){
             Node nodoListaUno = iteradorListaUno.next();
             while((!nodoListaDos.equals(nodoListaUno))&&(nodoListaDos.esMayor(nodoListaUno))){
                 /*
                 Se puede optimizar la busqueda realizando un corte si el valor a comparar es mayor,
                 ya que se encuentran ordenadas ambas listas
                  */
                 nodoListaDos.getNext();
             }
             if (nodoListaDos.equals(nodoListaUno)){
                 nuevaLista.insertarOrdenado(nodoListaDos);
             }
         }
         return nuevaLista;
     }

     public MySimpleLinkedList ordenadorListasOrdenadasIteradores(MySimpleLinkedList listaUno, MySimpleLinkedList listaDos){
         Iterator<Node> iteradorListaUno = listaUno.iterator();
         Iterator<Node> iteraorListaDos = listaDos.iterator();
         Node nodoListaUno = iteradorListaUno.next();
         Node nodoListaDos = iteraorListaDos.next();
         MySimpleLinkedList nuevaLista = new MySimpleLinkedList<>();
         while ((iteradorListaUno.hasNext())&&(iteraorListaDos.hasNext())){
             if ((nodoListaUno.esMayor(nodoListaDos))){
                 nodoListaDos = iteraorListaDos.next();
             } else if (nodoListaDos.esMayor(nodoListaUno)) {
                 nodoListaUno = iteradorListaUno.next();
             } else if (nodoListaUno.equals(nodoListaDos)) {
                 nuevaLista.insertarOrdenado(nodoListaDos);
                 nodoListaUno = iteradorListaUno.next();
                 nodoListaDos = iteraorListaDos.next();
                 /*
                 Se optimiza el recorrido de ambas listas implementando iterador ya que ambas se encuentran
                 ordenadas. No serepite el recorrido en ninguna de las 2 listas
                  */
             }
         }
         return nuevaLista;
     }
}
