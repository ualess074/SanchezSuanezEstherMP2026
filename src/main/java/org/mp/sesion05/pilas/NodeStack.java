package org.mp.sesion05.pilas;

public class NodeStack<E> implements Stack<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E value = top.data;
        top = top.next;
        size--;
        return value;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : top.data;
    }
}
