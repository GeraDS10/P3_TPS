import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio13 {
    public static void main(String[] args) {
        int valor;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese cantidad de terminos de serie Fibonacci a obtener");
            valor = Integer.valueOf(entrada.readLine());
            getSecuenciaFibonacci(valor);
        } catch (Exception e){
            System.out.println(e);
        }


    }

    public static void getSecuenciaFibonacci(int i){
        int iterador = 0;
        int primero = 0;
        int segundo = 1;
        if(i >= 1){
            if (i == 1){
                System.out.println(primero);
            } else if (i == 2) {
                System.out.println(primero);
                System.out.println(segundo);
            } else{
                int proximo;
                System.out.println(primero);
                iterador++;
                System.out.println(segundo);
                iterador++;
                while (iterador < i){
                    proximo = primero + segundo;
                    System.out.println(proximo);
                    primero = segundo;
                    segundo = proximo;
                    iterador++;
                }
            }
        }
    }
}
