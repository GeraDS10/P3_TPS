+import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList lista = new MySimpleLinkedList<>();
        lista.insertFront(1);
        lista.insertFront(2);
        lista.insertFront(3);
        lista.insertFront(4);
        lista.insertFront(5);

        Iterator<Node> iterador = lista.iterator();

        while (iterador.hasNext()){
            System.out.println(iterador.next());
        }
    }
}