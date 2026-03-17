package org.mp.sesion04.list.arraylist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    void testAdd() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.size());
    }

    @Test
    void testAddAtIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);

        list.add(1, 2);

        assertEquals(2, list.get(1));
    }

    @Test
    void testRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        list.remove((Object)1);

        assertFalse(list.contains(1));
    }

    @Test
    void testIndexOf() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        assertEquals(1, list.indexOf("b"));
    }

    @Test
    void testContains() {
        ArrayList<String> list = new ArrayList<>();
        list.add("hola");

        assertTrue(list.contains("hola"));
    }
}
