package org.mp.sesion05;

import org.mp.sesion05.colas.*;

/**
 * Clase que evalúa el rendimiento de distintas implementaciones de colas.
 * Se miden los tiempos de las operaciones enqueue y dequeue.
 */
public class PruebaRendimientoColas {

    /**
     * Método que ejecuta la prueba para una cola concreta
     */
    private static void probarQueue(Queue<Integer> queue, int n, String nombre) {

        // Medición del tiempo de inserción (enqueue)
        long startEnqueue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        long endEnqueue = System.nanoTime();

        // Medición del tiempo de eliminación (dequeue)
        long startDequeue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        long endDequeue = System.nanoTime();

        // Mostrar resultados por consola
        System.out.println(nombre + " | N=" + n +
                " | enqueue=" + (endEnqueue - startEnqueue) +
                " ns | dequeue=" + (endDequeue - startDequeue) + " ns");
    }

    public static void main(String[] args) {

        // Diferentes tamaños de prueba
        int[] tamaños = {10000, 20000, 50000};

        for (int n : tamaños) {

            // ArrayQueue: cola circular → O(1)
            probarQueue(new ArrayQueue<>(n), n, "ArrayQueue");

            // NodeQueue: nodos con referencia a inicio y fin → O(1)
            probarQueue(new NodeQueue<>(), n, "NodeQueue");

            // LinkedListQueue: usa java.util.LinkedList (doblemente enlazada)
            // Operaciones eficientes en ambos extremos → O(1)
            probarQueue(new LinkedListQueue<>(), n, "LinkedListQueue");

            System.out.println("-----------------------------------");
            
         // LinkedListQueue no tiene problemas de rendimiento porque usa
         // una lista doblemente enlazada (java.util.LinkedList),
         // lo que permite insertar y eliminar en O(1).
        }
    }
}
