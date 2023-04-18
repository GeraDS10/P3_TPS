public class ListaDoblementeVinculada {

    private Node first;
    private int size;

    public ListaDoblementeVinculada(){
        this.first = null;
        this.size = 0;
    }

    public void insertFront(Node nuevo){
        if(this.first == null){
            this.first = nuevo;
            this.size ++;
        }
        else {
            nuevo.setNext(this.first);
            this.first.setPrevious(nuevo);
            this.first = nuevo;
            this.size++;
        }
    }

    public void insertPosition(int pos, Node nuevo){
        if (pos <= this.size){
            int i = 0;
            Node iterador = this.first;
            while (i < pos){
                iterador = iterador.getNext();
                i++;
            }
            nuevo.setPrevious(iterador.getPrevious());
            nuevo.setNext(iterador);
            this.size++;
        }
    }

    public Node extractFront(){
        this.size--;
        Node front = this.first;
        this.first = front.getNext();
        return front;
    }

    public Node getPosition(int pos){
        if(pos <= this.size){
            int i = 0;
            Node iterador = this.first;
            while (i < pos){
                iterador = iterador.getNext();
                i++;
            }
            iterador.getPrevious().setNext(iterador.getNext());
            iterador.getNext().setPrevious(iterador.getPrevious());
            this.size--;
            return iterador;
        }
        return null;
    }

}
