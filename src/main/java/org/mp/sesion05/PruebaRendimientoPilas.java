package org.mp.sesion05;

import org.mp.sesion05.pilas.*;

/**
 * Clase que evalúa el rendimiento de distintas implementaciones de pilas.
 * Se miden los tiempos de las operaciones push y pop.
 */
public class PruebaRendimientoPilas {

    /**
     * Método que ejecuta la prueba para una pila concreta
     */
    private static void probarStack(Stack<Integer> stack, int n, String nombre) {

        // Medición del tiempo de inserción (push)
        long startPush = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        long endPush = System.nanoTime();

        // Medición del tiempo de eliminación (pop)
        long startPop = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long endPop = System.nanoTime();

        // Mostrar resultados por consola
        System.out.println(nombre + " | N=" + n +
                " | push=" + (endPush - startPush) +
                " ns | pop=" + (endPop - startPop) + " ns");
    }

    public static void main(String[] args) {

        // Diferentes tamaños de prueba
        int[] tamaños = {10000, 20000, 50000};

        for (int n : tamaños) {

            // ArrayStack: implementación basada en array → O(1)
            probarStack(new ArrayStack<>(n), n, "ArrayStack");

            // NodeStack: implementación basada en nodos → O(1)
            probarStack(new NodeStack<>(), n, "NodeStack");

            // LinkedListStack: usa lista simplemente enlazada
            // removeLast() es O(n) → provoca peor rendimiento
            probarStack(new LinkedListStack<>(), n, "LinkedListStack");

            System.out.println("-----------------------------------");
            
         // LinkedListStack es más lenta porque eliminar el último elemento
         // en una lista simplemente enlazada requiere recorrer toda la lista.
         // Esto hace que pop() tenga complejidad O(n).
        }
    }
}
