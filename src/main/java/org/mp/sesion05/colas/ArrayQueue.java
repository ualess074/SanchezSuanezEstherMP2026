package org.mp.sesion05.colas;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int front, rear, size;

    public ArrayQueue() {
        data = (E[]) new Object[10];
        front = 0;
        rear = 0;
        size = 0;
    }

    private void resize() {
        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size;
    }

    @Override
    public void enqueue(E element) {
        if (size == data.length) resize();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        E val = data[front];
        front = (front + 1) % data.length;
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
