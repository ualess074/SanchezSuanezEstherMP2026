package org.mp.sesion05;

import org.mp.sesion05.pilas.*;

/**
 * Clase que evalúa el rendimiento de distintas implementaciones de pilas.
 * Se miden los tiempos de las operaciones push y pop.
 */
public class PruebaRendimientoPilas {

    private static void probarStack(Stack<Integer> stack, int n, String nombre) {

        long startPush = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        long endPush = System.nanoTime();

        long startPop = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long endPop = System.nanoTime();

        System.out.println(nombre + " | N=" + n +
                " | push=" + (endPush - startPush) +
                " ns | pop=" + (endPop - startPop) + " ns");
    }

    public static void main(String[] args) {

        int[] tamaños = {10000, 20000, 50000};

        for (int n : tamaños) {

            // ✔ CAMBIO AQUÍ
            probarStack(new ArrayStack<>(), n, "ArrayStack");

            probarStack(new NodeStack<>(), n, "NodeStack");

            probarStack(new LinkedListStack<>(), n, "LinkedListStack");

            System.out.println("-----------------------------------");
        }
    }
}
