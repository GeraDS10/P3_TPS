package Ejercicio_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        ArrayList<Moneda> monedas = new ArrayList<>();
        Moneda n1 = new Moneda(100);
        Moneda n2 = new Moneda(25);
        Moneda n3 = new Moneda(10);
        Moneda n4 = new Moneda(5);
        Moneda n5 = new Moneda(1);
        monedas.add(n1);
        monedas.add(n2);
        monedas.add(n3);
        monedas.add(n4);
        monedas.add(n5);
        ArrayList<Moneda> solucion = greedy.greedy(monedas, 289);
        System.out.print("Solucion -> ");
        for (Moneda m: solucion
        ) {
            System.out.print(" Ejercicio_1.Moneda [" + m.getValor() + "]");
        }
    }

}
