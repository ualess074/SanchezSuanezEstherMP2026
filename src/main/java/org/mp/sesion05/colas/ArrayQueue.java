package org.mp.sesion05.colas;

public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

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
        if (size == data.length) {
            throw new RuntimeException("Queue llena"); // ✔ evita error silencioso
        }

        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;

        E value = data[front];
        data[front] = null; // ✔ evita memory leak
        front = (front + 1) % data.length;
        size--;

        return value;
    }

    @Override
    public E front() {
        return isEmpty() ? null : data[front];
    }
}
