package org.mp.sesion05.colas;

public interface Queue<E> {
    int size();
    boolean isEmpty();
    void enqueue(E element);
    E dequeue();
    E front();
}