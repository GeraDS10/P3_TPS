import java.util.ArrayList;

public class Ejercicio_2_Backtracking {

    /**
     * Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural
     * y cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este,
     * sur y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud
     * de un camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría
     * representarse el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y
     * cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.
     */


}
    class BacktrackingLaberinto{

    Laberinto laberinto;
        ArrayList<CeldaLaberinto> menorCamino;
        ArrayList<CeldaLaberinto> celdasVisitadas;
    public BacktrackingLaberinto(Laberinto laberinto){
        laberinto = laberinto;
        menorCamino = new ArrayList<>();
        celdasVisitadas = new ArrayList<>();
    }

    public ArrayList<CeldaLaberinto> encontrarMenorCamino(CeldaLaberinto inicio, CeldaLaberinto fin){
        ArrayList<CeldaLaberinto> caminoActual = new ArrayList<>();
        caminoActual.add(inicio);
        celdasVisitadas.add(inicio);

        backtracking(inicio, fin, caminoActual);
        return menorCamino;
    }

    private void backtracking(CeldaLaberinto celdaActual, CeldaLaberinto fin, ArrayList<CeldaLaberinto> caminoActual){
        if (celdaActual.equals(fin)){
            if (caminoActual.size() < menorCamino.size()){
                menorCamino = new ArrayList<>(caminoActual);
            }
        }
        else {
          if (celdaActual.este){
              celdasVisitadas.add(laberinto.getEste(celdaActual));
              caminoActual.add(laberinto.getEste(celdaActual));
              backtracking(laberinto.getEste(celdaActual), fin, caminoActual);
          } else if (celdaActual.oeste) {
              celdasVisitadas.add(laberinto.getOeste(celdaActual));
              caminoActual.add(laberinto.getOeste(celdaActual));
              backtracking(laberinto.getOeste(celdaActual), fin, caminoActual);
          } else if (celdaActual.norte) {
              celdasVisitadas.add(laberinto.getNorte(celdaActual));
              caminoActual.add(laberinto.getNorte(celdaActual));
              backtracking(laberinto.getNorte(celdaActual), fin, caminoActual);
          } else if (celdaActual.sur) {
              celdasVisitadas.add(laberinto.getSur(celdaActual));
              caminoActual.add(laberinto.getSur(celdaActual));
              backtracking(laberinto.getSur(celdaActual), fin, caminoActual);
          }
        }
    }
    }



    abstract class Laberinto{
        CeldaLaberinto [][] celdas;

        public Laberinto(int tamanio){
            celdas = new CeldaLaberinto[tamanio][tamanio];
        }

        public abstract CeldaLaberinto getNorte(CeldaLaberinto cl);
        public abstract CeldaLaberinto getEste(CeldaLaberinto cl);
        public abstract CeldaLaberinto getOeste(CeldaLaberinto cl);
        public abstract CeldaLaberinto getSur(CeldaLaberinto cl);

    }

    class CeldaLaberinto{
        int numeroNatural;
        boolean este;
        boolean norte;
        boolean oeste;
        boolean sur;

        public CeldaLaberinto(int numeroNatural, boolean este, boolean norte, boolean oeste, boolean sur) {
            this.numeroNatural = numeroNatural;
            this.este = este;
            this.norte = norte;
            this.oeste = oeste;
            this.sur = sur;
        }
    }


