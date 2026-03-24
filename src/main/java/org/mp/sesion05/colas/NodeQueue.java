package org.mp.sesion05.colas;

public class NodeQueue<E> implements Queue<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;

        E value = front.data;
        front = front.next;
        size--;

        if (isEmpty()) { 
            rear = null;
        }

        return value;
    }

    @Override
    public E front() {
        return isEmpty() ? null : front.data;
    }
}
