package org.mp.sesion04;

import org.mp.sesion04.list.arraylist.ArrayList;
import org.mp.sesion04.list.linkedlist.LinkedList;

import java.util.Random;

public class EvaluadorRendimientoListas {

    public static void main(String[] args) {
        evaluarRendimiento();
    }

    public static void evaluarRendimiento() {

        int[] tamaños = {10000, 20000, 40000};
        Random rand = new Random();

        for (int n : tamaños) {

            System.out.println("\nTamaño: " + n);

            ArrayList<Integer> arrayList = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                arrayList.add(i);
                linkedList.add(i);
            }

            medir("Agregar inicio", () -> {
                for (int i = 0; i < 100; i++)
                    arrayList.add(0, i);
            });

            medir("Agregar inicio (LL)", () -> {
                for (int i = 0; i < 100; i++)
                    linkedList.add(0, i);
            });

            medir("Acceso aleatorio", () -> {
                for (int i = 0; i < 100; i++)
                    arrayList.get(rand.nextInt(n));
            });

            medir("Acceso aleatorio (LL)", () -> {
                for (int i = 0; i < 100; i++)
                    linkedList.get(rand.nextInt(n));
            });
        }
    }

    private static void medir(String nombre, Runnable r) {
        long inicio = System.nanoTime();
        r.run();
        long fin = System.nanoTime();

        System.out.println(nombre + ": " + (fin - inicio) + " ns");
    }
}