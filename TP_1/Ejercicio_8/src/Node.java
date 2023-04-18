public class Node<T>{
    private T info;
    private Node<T> next;
    private Node<T> previous;


    public Node(){
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next){
        this.info = info;
        this.setNext(next);
    }

    public void setNext(Node<T> next){
        this.next= next;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setPrevious(Node<T> nodo){
        this.previous = nodo;
    }

    public Node<T> getPrevious(){
        return this.previous;
    }

    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "Node{" +
                "info=" + this.info +
                ", next=" + next +
                '}';
    }
}
