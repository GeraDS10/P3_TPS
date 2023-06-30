import java.util.ArrayList;

public class Ejercicio_6_Backtracking {

    /**
     * Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
     * directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió
     * a ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
     * casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
     * caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas
     * todavía había pasto (señal de que en ellas no había
     */

    abstract class Jardin{
        ArrayList<Celda> celdasPisadas;
        int cantidadCeldasPisadas;

        ArrayList<Celda> getPosibles(Celda celda){
            return null;
        }
    }

    abstract class Celda{

    }

    class BacktrackingAtila{
        Jardin jardin;
        public void imprimirSolucion(ArrayList<Celda> solucion){

        }

        public void encontrarCamino(Jardin jardin, Celda entrada){
            ArrayList<Celda> solucion = new ArrayList<>();
            ArrayList<Celda> visitadas = new ArrayList<>();
            solucion.add(entrada);
            backtrakcing(entrada, visitadas, solucion);

        }

        private void backtrakcing(Celda actual, ArrayList<Celda> visitadas, ArrayList<Celda> caminoActual){
            if (visitadas.size() < jardin.cantidadCeldasPisadas){
                imprimirSolucion(caminoActual);
            }
            ArrayList<Celda> posibles = jardin.getPosibles(actual);
            for (Celda c: posibles
                 ) {
                caminoActual.add(c);
                visitadas.add(c);
                backtrakcing(c, visitadas, caminoActual);
            }

        }
    }
}
