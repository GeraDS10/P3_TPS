import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio_3_Backtracking {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int M = 7;

        List<List<Integer>> combinaciones = encontrarCombinaciones(numeros, M);

        System.out.println("Combinaciones que suman " + M + ":");
        for (List<Integer> combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }


    public static List<List<Integer>> encontrarCombinaciones(int[] numeros, int M) {
        List<List<Integer>> combinaciones = new ArrayList<>();
        List<Integer> combinacionActual = new ArrayList<>();

        Arrays.sort(numeros); // Ordenar los números para mejorar la eficiencia

        backtrack(numeros, M, 0, combinacionActual, combinaciones);

        return combinaciones;
    }

    private static void backtrack(int[] numeros, int objetivo, int indice, List<Integer> combinacionActual, List<List<Integer>> combinaciones) {
        if (objetivo == 0) {
            // Se encontró una combinación que suma al objetivo
            combinaciones.add(new ArrayList<>(combinacionActual));
            return;
        }

        if (objetivo < 0 || indice >= numeros.length) {
            // Si el objetivo es negativo o se ha alcanzado el final del arreglo de números, se detiene la recursión
            return;
        }

        // Se explora tomar el número actual en la combinación
        combinacionActual.add(numeros[indice]);
        backtrack(numeros, objetivo - numeros[indice], indice + 1, combinacionActual, combinaciones);
        combinacionActual.remove(combinacionActual.size() - 1);

        // Se explora no tomar el número actual en la combinación
        backtrack(numeros, objetivo, indice + 1, combinacionActual, combinaciones);
    }
}
