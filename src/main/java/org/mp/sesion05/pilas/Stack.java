package org.mp.sesion05.pilas;

public interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}