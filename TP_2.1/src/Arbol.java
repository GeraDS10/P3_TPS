public class Arbol {

    private int valor;
    private Arbol izquierda;
    private Arbol derecha;

    public Arbol(int valor){
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public void add(int nuevoValor){
        if (nuevoValor < this.valor){
            if (this.izquierda.isEmpty()){
                this.izquierda = new Arbol(nuevoValor);
            }
            else {
                this.izquierda.add(nuevoValor);
            }
            }
        else {
            if (this.derecha.isEmpty()){
                this.derecha = new Arbol(nuevoValor);
            }
            else {
                this.derecha.add(nuevoValor);
            }
        }
    }

    public boolean isEmpty(){
        return this ==  null;
    }

    public void insert(int i){
        this.valor = i;
    }

    private Arbol getNodoMasIzquierdo(Arbol root){
        Arbol aux = root;
        while (aux.getIzquierda() != null){
            aux = aux.getIzquierda();
        }
        return aux;
    }
    public boolean delete(int i){
        //Todo
        boolean resultado = false;
        Arbol aux = this;
        Arbol last = this;

        while (aux !=null){
            if (aux.equals(i)){
                Arbol arbolDelete = aux;
                if (last.equals(aux)){
                    if ((aux.getIzquierda() == null)&&(aux.getDerecha() != null)){
                        this.setDerecha(null);
                    } else if ((aux.getIzquierda() != null)&&(aux.getDerecha() == null)) {
                        this.setIzquierda(null);
                    }
                }
                else {
                    if ((aux.getDerecha() == null)&&(aux.getIzquierda() == null)&&(last.isLower(i))){
                        last.setDerecha(null);
                    }
                    else if ((aux.getDerecha() == null)&&(aux.getIzquierda() == null)&&(!last.isLower(i))) {
                        last.setIzquierda(null);
                    }
                    else if ((aux.getDerecha() != null)&&(aux.getIzquierda() == null)&&(!last.isLower(i))) {
                        last.setDerecha(aux.getDerecha());
                    }
                    else if ((aux.getDerecha() != null)&&(aux.getIzquierda() == null)&&(last.isLower(i))) {
                        last.setIzquierda(aux.getDerecha());
                    }
                    else if ((aux.getDerecha() == null)&&(aux.getIzquierda() != null)&&(!last.isLower(i))) {
                        last.setDerecha(aux.getIzquierda());
                    }
                    else if ((aux.getDerecha() == null)&&(aux.getIzquierda() != null)&&(last.isLower(i))) {
                        last.setIzquierda(aux.getIzquierda());
                    }
                    else if ((aux.getDerecha() != null)&&(aux.getIzquierda() != null)&&(!last.isLower(i))) {
                        //BUSCAR EL NMI
                        last.setDerecha(this.getNodoMasIzquierdo(aux));
                    }
                    else if ((aux.getDerecha() != null)&&(aux.getIzquierda() != null)&&(last.isLower(i))) {
                        //BUSCAR EL NMI
                        last.setIzquierda();
                    }
                }



            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return this.valor == ((int) obj);
    }

    public int getHeight(){
        //Todo
        return 0;
    }

    public void printPosOrder(){
        //Todo
    }

    public void printPreOrder(){
        //Todo
    }

    public boolean isLower(int i){
        return this.valor < i;
    }

    public void setIzquierda(Arbol a){
        this.izquierda = a;
    }

    public void setDerecha(Arbol a){
        this.derecha = a;
    }

    public Arbol getIzquierda(){
        return this.izquierda;
    }

    public Arbol getDerecha() {
        return this.derecha;
    }
}


