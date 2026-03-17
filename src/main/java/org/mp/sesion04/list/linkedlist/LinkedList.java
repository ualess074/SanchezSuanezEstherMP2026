package org.mp.sesion04.list.linkedlist;

import java.util.AbstractList;

public class LinkedList<E> extends AbstractList<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public void add(int index, E e) {
        checkIndexForAdd(index);

        Node newNode = new Node(e);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if ((o == null && current.data == null) ||
                (o != null && o.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current = head;
        int index = 0;
        int lastIndex = -1;

        while (current != null) {
            if ((o == null && current.data == null) ||
                (o != null && o.equals(current.data))) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }

        return lastIndex;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E old = current.data;
        current.data = e;

        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Node removed;

        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            removed = current.next;
            current.next = removed.next;
        }

        size--;
        return removed.data;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Índice inválido");
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Índice inválido");
    }
}
