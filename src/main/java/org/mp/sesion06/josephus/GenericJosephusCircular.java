package org.mp.sesion06.josephus;

import java.util.*;

public class GenericJosephusCircular<E> {

    private int k, n;
    private List<E> list = new ArrayList<>();

    public GenericJosephusCircular(int k, int n, E[] datos) {
        this.k = k;
        this.n = n;

        if (datos != null) {
            for (E e : datos) {
                if (e != null && !e.equals("")) list.add(e);
            }
        }
    }

    public String ordenEliminar() {

        if (list.isEmpty()) return "No hay ninguna persona";
        if (list.size() == 1) return "Solo hay una persona";

        StringBuilder sb = new StringBuilder("Orden de eliminación:\n");

        List<E> temp = new ArrayList<>(list);
        int index = 0;

        while (!temp.isEmpty()) {

            index = (index + k - 1) % temp.size();
            E eliminado = temp.remove(index);

            sb.append("Debe morir ").append(eliminado).append("\n");
        }

        return sb.toString();
    }
}