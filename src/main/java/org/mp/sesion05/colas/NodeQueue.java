package org.mp.sesion05.colas;

import java.util.NoSuchElementException;

public class NodeQueue<E> implements Queue<E> {

    private class Node {
        E data;
        Node next;

        Node(E d) { data = d; }
    }

    private Node front, rear;
    private int size;

    @Override
    public void enqueue(E element) {
        Node n = new Node(element);
        if (rear != null) rear.next = n;
        rear = n;
        if (front == null) front = n;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        E val = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return val;
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
