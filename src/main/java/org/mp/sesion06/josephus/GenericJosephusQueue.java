package org.mp.sesion06.josephus;

import java.util.*;

public class GenericJosephusQueue<E> {

    private int k, n;
    private Queue<E> queue = new LinkedList<>();

    public GenericJosephusQueue(int k, int n, E[] datos) {
        this.k = k;
        this.n = n;

        if (datos != null) {
            for (E e : datos) {
                if (e != null && !e.equals("")) queue.add(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Problema de Josephus: k=" + k + ", n=" + n +
                "\nCola: " + queue.toString();
    }

    public String ordenEliminar() {

        if (queue.isEmpty()) return "No hay ninguna persona";
        if (queue.size() == 1) return "Solo hay una persona";

        StringBuilder sb = new StringBuilder("Orden de eliminación:\n");

        Queue<E> q = new LinkedList<>(queue);

        while (!q.isEmpty()) {

            for (int i = 1; i < k; i++) {
                q.add(q.poll());
            }

            E eliminado = q.poll();
            sb.append("Debe morir ").append(eliminado).append("\n");
        }

        return sb.toString();
    }
}
