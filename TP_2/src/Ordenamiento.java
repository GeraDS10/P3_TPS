

public class Ordenamiento {
    public static void main(String[] args) {
        int [] arreglo = new int[5];
        arreglo[0] = 5;
        arreglo[1] = 2;
        arreglo[2] = 10;
        arreglo[3] = 8;
        arreglo[4] = 7;
        imprimirArreglo(arreglo);
        /*
        --Seleccion

        ordenarPorSeleccion(arreglo);
         */

        /*

        --Burbujeo

        ordenarPorBurbujeo(arreglo);
        System.out.println(" ");

         */
        imprimirArreglo(arreglo);
        /*
        --QuickSort

        QuickSort.quicksort(arreglo, 0,4);
        imprimirArreglo(arreglo);
         */

        /*
        --MergeSort

        MergeSort ms = new MergeSort();
        ms.sort(arreglo);
        imprimirArreglo(arreglo);
         */




    }
    public static void imprimirArreglo(int [] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int [] ordenarPorBurbujeo(int [] arr){
        boolean cambio = true;
        int j = 0;
        int temp;
        while (cambio){
            cambio = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i+1]){
                    cambio = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int [] ordenarPorSeleccion(int [] arr){
        for (int pos = 0; pos < arr.length; pos++) {
            int aux;
            int posicion = 0;
            boolean cambio = false;
            int i = pos+1;
            while (i < arr.length){
                if (arr[i] < arr[pos]){
                    posicion = i;
                    cambio = true;
                }
                i++;
            }
            if (cambio == true){
                aux = arr[pos];
                arr[pos] = arr[posicion];
                arr[posicion] = aux;
            }
        }
        return arr;
    }
}
