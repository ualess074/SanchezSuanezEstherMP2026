package org.mp.sesion04.list.linkedlist;

import java.util.*;

public class LinkedList<E> extends AbstractList<E> {

    private class Node {
        E data;
        Node next;
        Node(E data) { this.data = data; }
    }

    private Node head;
    private int size;

    public LinkedList() {
		super();
	}



    public LinkedList(E[] elements) {
        if (elements != null) {
            for (E e : elements) add(e);
        }
    }

    public E getFirst() {
        return (head == null) ? null : head.data;
    }

    public E getLast() {
        if (head == null) return null;
        Node current = head;
        while (current.next != null) current = current.next;
        return current.data;
    }

    public void addFirst(E e) {
        Node n = new Node(e);
        n.next = head;
        head = n;
        size++;
    }

    public void addLast(E e) {
        add(e);
    }

    @Override
    public boolean add(E e) {
        Node n = new Node(e);
        if (head == null) {
            head = n;
        } else {
            Node c = head;
            while (c.next != null) c = c.next;
            c.next = n;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index <= 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node c = head;
            for (int i = 0; i < index - 1; i++) {
                c = c.next;
            }
            Node n = new Node(e);
            n.next = c.next;
            c.next = n;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null) return null;
        E val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public E removeLast() {
        if (head == null) return null;
        if (head.next == null) return removeFirst();

        Node c = head;
        while (c.next.next != null) c = c.next;

        E val = c.next.data;
        c.next = null;
        size--;
        return val;
    }

    @Override
    public E remove(int index) {
        if (size == 0) return null;

        if (index <= 0) return removeFirst();
        if (index >= size - 1) return removeLast();

        Node c = head;
        for (int i = 0; i < index - 1; i++) {
            c = c.next;
        }

        E val = c.next.data;
        c.next = c.next.next;
        size--;
        return val;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        Node c = head;
        for (int i = 0; i < index; i++) {
            c = c.next;
        }
        return c.data;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) return null;
        Node c = head;
        for (int i = 0; i < index; i++) {
            c = c.next;
        }
        E old = c.data;
        c.data = e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    public int indexOf(Object o) {
        Node c = head;
        int i = 0;
        while (c != null) {
            if (Objects.equals(o, c.data)) return i;
            c = c.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node c = head;
        int i = 0, last = -1;
        while (c != null) {
            if (Objects.equals(o, c.data)) last = i;
            c = c.next;
            i++;
        }
        return last;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node current = head;
            Node previous = null;
            Node lastReturned = null;
            Node lastReturnedPrev = null;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (current == null)
                    throw new NoSuchElementException();

                lastReturnedPrev = previous;
                lastReturned = current;

                previous = current;
                current = current.next;

                return lastReturned.data;
            }

            public void remove() {
                if (lastReturned == null)
                    throw new IllegalStateException();

                if (lastReturnedPrev == null) {
                    
                    head = head.next;
                } else {
                    lastReturnedPrev.next = lastReturned.next;
                }

                size--;

                
                previous = lastReturnedPrev;
                lastReturned = null;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList)) return false;

        LinkedList<?> other = (LinkedList<?>) o;

        if (this.size != other.size) return false;

        Iterator<E> it1 = this.iterator();
        Iterator<?> it2 = other.iterator();

        while (it1.hasNext()) {
            if (!Objects.equals(it1.next(), it2.next())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node c = head;
        while (c != null) {
            sb.append(c.data);
            if (c.next != null) sb.append(", ");
            c = c.next;
        }
        return sb.append("]").toString();
    }
}
