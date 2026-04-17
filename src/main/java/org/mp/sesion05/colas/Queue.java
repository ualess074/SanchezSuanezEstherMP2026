package org.mp.sesion05.colas;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    int getSize();
    boolean isEmpty();
}