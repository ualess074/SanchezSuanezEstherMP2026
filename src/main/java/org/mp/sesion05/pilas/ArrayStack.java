package org.mp.sesion05.pilas;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {

    private E[] data;
    private int size;

    public ArrayStack() {
        data = (E[]) new Object[10];
        size = 0;
    }

    private void resize() {
        E[] newData = (E[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public void push(E element) {
        if (size == data.length) resize();
        data[size++] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();
        E val = data[--size];
        data[size] = null;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return data[size - 1];
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