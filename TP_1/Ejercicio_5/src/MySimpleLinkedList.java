import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<Node<T>>{

    private Node<T> first;
    private int size;

    public MySimpleLinkedList(){
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info){
        Node<T> tmp = new Node<T> (info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size ++;
    }

    public T extractFront(){
        if(this.first != null){
            T infoFirst = this.first.getInfo();
            this.setFirst(this.first.getNext());
            this.size --;
            return infoFirst;
        }else {
            return null;
        }
    }

    private void setFirst(Node node){
        this.first = node;
    }
    public boolean isEmpty(){
        if(this.first == null){
            return true;
        }
        else {
            return false;
        }
    }

    public T get (int index){
        if((this.size >= index)&&(this.size != 0)){
            int i = 0;
            Node<T> iterador = this.first;
         while (i < index){
             iterador = iterador.getNext();
             i++;
         }
         return iterador.getInfo();
        }
        else {
            return null;
        }
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }

    public Iterator iterator(){
        return new IteratorNode();
    }

    protected class IteratorNode implements Iterator<T> {
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return  pos < getSize();
        }

        public T next(){
            pos++;
            return get(pos-1);
        }
    }

}
