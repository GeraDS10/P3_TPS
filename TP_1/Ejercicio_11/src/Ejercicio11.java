public class Ejercicio11 {
    public static void main(String[] args) {

    }

    public static int buscar(int buscado, int [] arreglo){
        int i = 0;
        while((buscado != arreglo[i])&&(i <= arreglo.length)){
            i++;
        }
        if (i <= arreglo.length){
            return i;
        }
        else {
            return -1;
        }
    }
}
