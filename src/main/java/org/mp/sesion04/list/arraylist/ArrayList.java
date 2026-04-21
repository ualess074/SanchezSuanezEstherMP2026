package org.mp.sesion04.list.arraylist;

import java.util.*;

public class ArrayList<E> extends AbstractList<E> {

    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayList(E[] elements) {
        data = (E[]) new Object[Math.max(DEFAULT_CAPACITY, elements.length)];
        for (E e : elements) {
            data[size++] = e;
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacity();
        data[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
        return removed;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i != -1) {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void trimToSize() {
        if (size == data.length)
            throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");

        data = Arrays.copyOf(data, size);
    }

    @Override
    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, data[i])) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, data[i])) return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;
            int lastRet = -1;

            public boolean hasNext() {
                return cursor < size;
            }

            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException("No hay más elementos en la lista");
                lastRet = cursor;
                return data[cursor++];
            }

            public void remove() {
                if (lastRet == -1)
                    throw new IllegalStateException("No se puede usar remove() sin hacer next()");
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayList)) return false;
        ArrayList<?> other = (ArrayList<?>) o;
        if (size != other.size) return false;

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(data[i], other.data[i])) return false;
        }
        return true;
    }
}
