import java.util.ArrayList;

public class Ejercicio_1_Backtracking {
    /*
    Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente
    en un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
    permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
    representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
    puerta es un arco dirigido hacia otra habitación.
     */
    int [][] grafo;
    int habitaciones;
    ArrayList visitadas;
    ArrayList mejorCamino;
    int maxHabitaciones;

    public boolean habitacionFueVisitada(int habitacion){
        return this.visitadas.contains(habitacion);
    }

    public ArrayList<Integer> encontrarCaminoMasLargo(int [][] grafo, int habitaciones, int entrada, int salida){
        this.grafo = grafo;
        this.habitaciones = habitaciones;
        this.visitadas = new ArrayList<>();
        this.mejorCamino = new ArrayList<>();
        this.maxHabitaciones = 0;

        ArrayList<Integer> caminoActual = new ArrayList<>();
        caminoActual.add(entrada);
        visitadas.add(entrada);

        backtrack(entrada, salida, caminoActual);

        return mejorCamino;
    }

    private void backtrack(int habitacionActual, int salida, ArrayList<Integer> caminoActual){
        if (habitacionActual == salida){
            if (caminoActual.size() > maxHabitaciones){
                maxHabitaciones = caminoActual.size();
                mejorCamino = new ArrayList<>(caminoActual);
            }
            return;
        }

        for (int i = 0; i <habitaciones ; i++) {
            if ((grafo[habitacionActual][i] == 1) && (!habitacionFueVisitada(grafo[habitacionActual][i]))){
                visitadas.add(grafo[habitacionActual][i]);
                caminoActual.add(grafo[habitacionActual][i]);
                backtrack(grafo[habitacionActual][i], salida, caminoActual);
                visitadas.remove(grafo[habitacionActual][i]);
                caminoActual.remove(grafo[habitacionActual][i]);
            }
        }
    }
}
