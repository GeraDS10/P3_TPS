import java.util.Iterator;

public class ListaDistintos extends MySimpleLinkedList{

    public MySimpleLinkedList noRepetidos(MySimpleLinkedList listaUno, MySimpleLinkedList listaDos){
        MySimpleLinkedList nuevaLista = new MySimpleLinkedList();
        Node nodoListaUno = (Node) listaUno.get(1);
        Node nodoListaDos = (Node) listaDos.get(1);
        while (nodoListaUno.getNext() != null){
            while ((nodoListaDos.getNext() != null)&&(nodoListaDos.equals(nodoListaUno))){
                if (!nodoListaUno.equals(nodoListaDos)){
                    nuevaLista.insertFront(nodoListaUno);
            }
            }
        }
        return nuevaLista;
    }
}
