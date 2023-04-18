public class Ejercicio10 {
    public static void main(String[] args) {
        boolean resultado;
        int [] arr = new int [10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 8;
        arr[8] = 9;
        arr[9] = 10;

        resultado = estaOrdenado(arr);
        System.out.println(resultado);

    }
    public static boolean estaOrdenado(int [] arreglo){
        int length = arreglo.length;
        int inicio = 0;
        int fin = arreglo.length;
        while((inicio < arreglo.length/2)&&(arreglo[inicio] < arreglo[inicio+1])&&(arreglo[fin-1] > arreglo[fin-2])){
            inicio++;
            fin--;
        }
        if((inicio == arreglo.length / 2)&&(arreglo[inicio] < arreglo[inicio+1])){
           return true;
        }
        else{
            return false;
        }
    }
}
