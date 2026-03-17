package org.mp.sesion04.list.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.size());
    }

    @Test
    void testAddAtIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);

        list.add(1, 2);

        assertEquals(2, list.get(1));
    }

    @Test
    void testContains() {
        LinkedList<String> list = new LinkedList<>();
        list.add("test");

        assertTrue(list.contains("test"));
    }

    @Test
    void testIndexOf() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");

        assertEquals(1, list.indexOf("b"));
    }

    @Test
    void testLastIndexOf() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("a");

        assertEquals(2, list.lastIndexOf("a"));
    }

    @Test
    void testSet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        list.set(0, 10);

        assertEquals(10, list.get(0));
    }

    @Test
    void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        list.remove((Object)1);

        assertFalse(list.contains(1));
    }
}
