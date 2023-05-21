import java.util.ArrayList;
import java.util.List;

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
            if (this.izquierda == null){
                this.izquierda = new Arbol(nuevoValor);
            }
            else {
                this.izquierda.add(nuevoValor);
            }
            }
        else {
            if (this.derecha == null){
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

    public int getValor(){
        return this.valor;
    }
    public boolean delete(int i){
        //Todo
        boolean resultado = false;
        Arbol aux = this;
        Arbol last = this;

        while ((aux !=null)&&(resultado == false)){
            //System.out.println("COMPARANDO: " + aux.getValor() + " -> " + i);
            if (aux.equals(i)){
                Arbol arbolDelete = aux;
                if (last.equals(aux.getValor())){
                    //System.out.println("ES RAIZ");
                    if ((aux.getIzquierda() == null)&&(aux.getDerecha() != null)){
                        this.setDerecha(null);
                        resultado = true;
                    } else if ((aux.getIzquierda() != null)&&(aux.getDerecha() == null)) {
                        this.setIzquierda(null);
                        resultado = true;
                    } else if ((aux.getIzquierda() != null)&&(aux.getDerecha() !=null)) {
                         last = aux.getNodoMasIzquierdo(aux.getDerecha());
                         last.setDerecha(aux.getDerecha());
                         last.setIzquierda(aux.getIzquierda());
                         last.getDerecha().delete(last.getValor());
                         resultado = true;
                    }
                }
                else {
                    //System.out.println("NO ES RAIZ");
                   if (last.getDerecha().equals(aux.getValor())){
                      // System.out.println("ES SUBARBOL DERECHO");
                       if ((aux.getDerecha() == null) && (aux.getIzquierda() == null)){
                        //   System.out.println("ES HOJA");
                           last.setDerecha(null);
                           resultado = true;
                       } else if ((aux.getDerecha() == null) && (aux.getIzquierda() != null)) {
                          // System.out.println("SOLO RAMA MENOR");
                           last.setDerecha(aux.getIzquierda());
                           resultado = true;
                       } else if ((aux.getDerecha() != null) && (aux.getIzquierda() == null)) {
                           //System.out.println("SOLO RAMA MAYOR");
                           last.setDerecha(aux.getDerecha());
                           resultado = true;
                       } else if ((aux.getDerecha() != null) && (aux.getIzquierda() == null)) {
                           //System.out.println("AMBAS RAMAS");
                           last.setDerecha(aux.getNodoMasIzquierdo(aux));
                           last.getDerecha().setIzquierda(aux.getIzquierda());
                           last.getDerecha().setDerecha(aux.getDerecha());
                           last.getDerecha().delete(aux.getValor());
                           resultado = true;
                       }
                   }
                   else {
                      // System.out.println("ES SUBARBOL IZQUIERDO");
                       if ((aux.getDerecha() == null) && (aux.getIzquierda() == null)){
                           last.setIzquierda(null);
                           resultado = true;
                       } else if ((aux.getDerecha() == null) && (aux.getIzquierda() != null)) {
                           last.setIzquierda(aux.getIzquierda());
                           resultado = true;
                       } else if ((aux.getDerecha() != null) && (aux.getIzquierda() == null)) {
                           last.setIzquierda(aux.getDerecha());
                           resultado = true;
                       } else if ((aux.getDerecha() != null) && (aux.getIzquierda() == null)) {
                           last.setIzquierda(aux.getNodoMasIzquierdo(aux));
                           last.getIzquierda().setIzquierda(aux.getIzquierda());
                           last.getIzquierda().setDerecha(aux.getDerecha());
                           last.getIzquierda().delete(aux.getValor());
                           resultado = true;
                       }
                   }
                }
            }
            if (resultado == false){
                last = aux;
                if (aux.getValor() < i){
                    aux = aux.getDerecha();
                }
                else{
                    aux = aux.getIzquierda();
                }
            }
        }
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        return this.valor == ((int) obj);
    }

    public int getHeight(){
        int leftBranch = 0;
        int rightBranch = 0;
        if (izquierda != null){
            leftBranch = izquierda.getHeight();
        }
        if (derecha != null){
            rightBranch = derecha.getHeight();
        }
        if (leftBranch >= rightBranch){
            return 1+leftBranch;
        }
        else {
            return 1+rightBranch;
        }
    }

    public void printPosOrder(Arbol a){
        if (a == null){
            System.out.print("-");
        }
        else {
            printPosOrder(a.getIzquierda());
            printPosOrder(a.getDerecha());
            System.out.print(a.getValor() + " ");
        }
    }

    public void printPreOrder(Arbol a){
        if (a == null){
            System.out.print("-");
        }
        else {
            System.out.print(a.getValor() + " ");
            printPreOrder(a.getIzquierda());
            printPreOrder(a.getDerecha());
        }
    }

    public void printInOrder(Arbol a){
        if (a == null){
            System.out.print("-");
        }
        else {
            printInOrder(a.getIzquierda());
            System.out.print(a.getValor() + " ");
            printInOrder(a.getDerecha());
        }
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

    public List getLongestBranch(){
        List leftBranch = new ArrayList<>();
        List rightBranch = new ArrayList<>();
        if (izquierda != null){
            leftBranch.addAll(izquierda.getLongestBranch());
        }
        if (derecha != null){
            rightBranch.addAll(derecha.getLongestBranch());
        }
        if (leftBranch.size() >= rightBranch.size()){
            leftBranch.add(valor);
            return leftBranch;
        }
        else {
            rightBranch.add(valor);
            return rightBranch;
        }
    }

    public List getFrontera(){
        //TODO
        return null;
    }

    public int getMaxElement(){
        int left = 0;
        int right = 0;
        if (izquierda != null){
            izquierda.getMaxElement();
        }
        if (derecha != null){
            derecha.getMaxElement();
        }
        if (left > valor){
            return left;
        }
        else if (right > valor) {
            return right;
        }
        else {
            return valor;
        }
    }
    public List getElementAtLevel(int i){
        //TODO
        return null;
    }



    public boolean isLeaf(){
        if ((izquierda == null) && (derecha == null)){
            return true;
        }
        else{
            return false;
        }
    }

    // EJERCICIO 2.2 --------------------------------
    public int getSum(){
        int suma = 0;
        if (!this.isLeaf()){
            int left = 0;
            int right = 0;
            if (izquierda != null){
                left = izquierda.getSum();
            }
            if (derecha != null){
                right = derecha.getSum();
            }
            System.out.println("izquierda = " + izquierda + " + " + "derecha = " + derecha);
            suma = left + right;
        }
        return suma + this.valor;
    }

    // FIN EJERCICIO 2.2 ----------------------------
    // EJERCICIO 2.3 --------------------------------

    public List getHigher(int k){
        List resultado = new ArrayList<>();
        if ((this.isLeaf()) && (this.valor > k)){
            resultado.add(this);
        } else if (!this.isLeaf()) {
            if (izquierda != null){
                resultado.addAll(izquierda.getHigher(k));
            }
            if (derecha != null){
                resultado.addAll(derecha.getHigher(k));
            }
        }
        return resultado;
    }

    // FIN EJERCICIO 2.3 --------------------------

    // EJERCICIO 2.4 -------------------------------
    public void completeTree(){
        if (!this.isLeaf()){
           if (!izquierda.isLeaf()){
               izquierda.completeTree();
           }
           if (!derecha.isLeaf()){
               derecha.completeTree();
           }
           this.valor = derecha.getValor() - izquierda.getValor();
        }
    }

    // FIN EJERCICIO 2.4-----------------------------




    @Override
    public String toString() {
        return "Arbol = (" + this.valor + ")";
    }
}


