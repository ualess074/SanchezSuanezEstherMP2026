package org.mp.sesion06.orderedlist;

import java.util.*;

public class OrderedList<E extends Comparable<E>> {

    private List<E> list = new ArrayList<>();

    public void addElement(E e) {
        list.add(e);
        Collections.sort(list);
    }

    public boolean removeElement(E e) {
        return list.remove(e);
    }

    public int getSize() {
        return list.size();
    }

    public E getElement(int index) {
        return list.get(index);
    }

    public int getIndex(E e) {
        return list.indexOf(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
