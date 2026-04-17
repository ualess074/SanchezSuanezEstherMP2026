package org.mp.sesion06.circularlist;

import java.util.*;

public class CircularList<E> implements Iterable<E> {

    private List<E> list = new ArrayList<>();

    public void addElement(E e) {
        list.add(e);
    }

    public boolean removeElement(E e) {
        return list.remove(e);
    }

    public int getSize() {
        return list.size();
    }

    public E getElement(int index) {
        if (list.isEmpty()) throw new IndexOutOfBoundsException();
        return list.get(index % list.size());
    }

    public int getIndex(E e) {
        return list.indexOf(e);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public E next() {
                if (list.isEmpty()) throw new NoSuchElementException();
                E val = list.get(index % list.size());
                index++;
                return val;
            }
        };
    }
}