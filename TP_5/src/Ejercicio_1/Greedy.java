package Ejercicio_1;

import java.util.ArrayList;

public class Greedy {
    ArrayList<Moneda> tiposMoneda;

    public Greedy(){
        tiposMoneda = new ArrayList<>();
    }

    public Moneda seleccionar(ArrayList<Moneda> tiposMonedas){
        Moneda mayor = new Moneda(0);
        for (Moneda m: tiposMonedas
        ) {
            if (m.getValor() > mayor.getValor()){
                mayor = m;
            }
        }
        return mayor;
    }
    public ArrayList<Moneda> greedy(ArrayList<Moneda> tiposMoneda, int total){
        ArrayList<Moneda> solucion = new ArrayList<>();
        while ((tiposMoneda.size() > 0)&&(total > 0)){
            Moneda m = seleccionar(tiposMoneda);
            tiposMoneda.remove(m);
            if (m.getValor() <= total){
                solucion.add(m);
                total -= m.getValor();
                while (total >= m.getValor()){
                    solucion.add(m);
                    total -= m.getValor();
                }
            }
        }
        if (total == 0){
            return solucion;
        }
        else {
            return null;
        }
    }
}
