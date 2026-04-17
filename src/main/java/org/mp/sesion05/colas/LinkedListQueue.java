package org.mp.sesion05.colas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.removeFirst();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}