package org.mp.sesion05.pilas;

public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int top;

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        top = -1;
    }

    @Override
    public int getSize() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E element) {
        data[++top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return data[top--];
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data[top];
    }
}
