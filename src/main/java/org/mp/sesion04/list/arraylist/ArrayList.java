package org.mp.sesion04.list.arraylist;

import java.util.AbstractList;

public class ArrayList<E> extends AbstractList<E> {

    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings({ "unchecked" })
    public ArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity();
        data[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E e) {
        checkIndexForAdd(index);
        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
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
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null && data[i] == null) return i;
            if (o != null && o.equals(data[i])) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o == null && data[i] == null) return i;
            if (o != null && o.equals(data[i])) return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
 
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= data.length) {
            int newCapacity = data.length * 2;
            E[] newData = (E[]) new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }
}
