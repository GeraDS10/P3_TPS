import java.util.ArrayList;

public class Ejercicio_12 {

    public ArrayList getBinario(int i){
        ArrayList resultado = new ArrayList<>();
        if (i >= 2){
            int resto = 0;
            while (resto >= 2){
                resto = dividirPorDos(i);
                if (resto % 2 == 0){
                    resultado.add(0);
                }
                else {
                    resultado.add(1);
                }
            }
        }
        return resultado;
    }

    public int dividirPorDos(int i){
        return i / 2;
    }
}
