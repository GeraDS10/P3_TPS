public class Pila<T> {

    private Node<T> first;
    private int size;

    public Pila(){
        this.first = null;
        this.size = 0;
    }

    public void push(T info){
        Node<T> tmp = new Node<T> (info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size ++;
    }

    public T pop(){
        if(this.first != null){
            T infoFirst = this.first.getInfo();
            this.setFirst(this.first.getNext());
            this.size --;
            return infoFirst;
        }else {
            return null;
        }
    }

    public T top(){
        return this.first.getInfo();
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

    public int size(){
        return this.size;
    }

    public void reverse(){
        if(this.first.getNext() != null){
            Node<T> anterior = this.first;
            Node<T> iterador = this.first.getNext();
            Node<T> siguiente = iterador.getNext();
            anterior.setNext(null);
            while (siguiente != null){
                iterador.setNext(anterior);
                anterior = iterador;
                iterador = siguiente;
                siguiente = siguiente.getNext();
            }
            iterador.setNext(anterior);
            this.first = iterador;
        }
    }

    public void imprimirPila(){
        Node<T> iterador = this.first;
        while (iterador != null){
            System.out.println(iterador.getInfo());
            iterador =iterador.getNext();
        }
    }

    @Override
    public String toString() {
        return "Pila : " + this.first;
    }
}
