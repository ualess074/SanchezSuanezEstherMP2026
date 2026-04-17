package org.mp.sesion05.pilas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void push(E element) {
        list.addLast(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.removeLast();
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.getLast();
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
