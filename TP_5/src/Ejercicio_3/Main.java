package Ejercicio_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Actividad a1 = new Actividad(8, 9);
        Actividad a2 = new Actividad(10, 12);
        Actividad a3 = new Actividad(9, 11);
        Actividad a4 = new Actividad(12, 15);
        Actividad a5 = new Actividad(11, 18);
        Actividad a6 = new Actividad(20, 22);
        Actividad a7 = new Actividad(19, 20);
        Actividad a8 = new Actividad(17, 18);
        Actividad a9 = new Actividad(9, 23);
        Actividad a10 = new Actividad(7, 8);
        ArrayList<Actividad> actividades = new ArrayList<>();
        actividades.add(a1);
        actividades.add(a2);
        actividades.add(a3);
        actividades.add(a4);
        actividades.add(a5);
        actividades.add(a6);
        actividades.add(a7);
        actividades.add(a8);
        actividades.add(a9);
        actividades.add(a10);
        Greedy greedy = new Greedy();
        ArrayList<Actividad> solucion = greedy.maximoActividades(actividades);
        System.out.print("Solucion ->");
        for (Actividad a: solucion
             ) {
            System.out.println(" Inicio: " + a.getHoraComienzo() + " - Fin: " + a.getHoraFin());
        }
    }
}
