package Ejercicio_3;

import java.util.ArrayList;

public class Greedy {

    public ArrayList<Actividad> actividades;

    public Actividad seleccionar(ArrayList<Actividad> actividades){
        if (actividades.size() != 0){
            Actividad primera = actividades.get(0);
            for (Actividad a: actividades
                 ) {
                if (a.horaFin < primera.getHoraFin()){
                    primera = a;
                }
            }
            return primera;
        }
        return null;
    }

    public ArrayList<Actividad> maximoActividades(ArrayList<Actividad> actividades){
        ArrayList<Actividad> solucion = new ArrayList<>();
        Actividad a = seleccionar(actividades);
        actividades.remove(a);
        solucion.add(a);
        while (actividades.size() >0){
            Actividad siguiente = seleccionar(actividades);
            actividades.remove(siguiente);
            if (solucion.get(solucion.size()-1).getHoraFin() <= siguiente.getHoraComienzo()){
                solucion.add(siguiente);
            }
        }
        return solucion;
    }
}
