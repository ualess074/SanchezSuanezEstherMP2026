package org.mp.sesion05.colas;

import java.util.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        return list.pollFirst(); // devuelve null si está vacía ✔
    }

    @Override
    public E front() {
        return list.peekFirst(); // devuelve null si está vacía ✔
    }
}