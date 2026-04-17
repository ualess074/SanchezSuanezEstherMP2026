package org.mp.sesion05.pilas;

import java.util.NoSuchElementException;

public class NodeStack<E> implements Stack<E> {

    private class Node {
        E data;
        Node next;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    @Override
    public void push(E element) {
        top = new Node(element, top);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();
        E val = top.data;
        top = top.next;
        size--;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return top.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
