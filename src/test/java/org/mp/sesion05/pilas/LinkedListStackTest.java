package org.mp.sesion05.pilas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListStackTest {

    @Test
    void testPushPop() {
        Stack<Integer> stack = new LinkedListStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        Stack<Integer> stack = new LinkedListStack<>();

        stack.push(7);
        assertEquals(7, stack.peek());
    }

    @Test
    void testEmpty() {
        Stack<Integer> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSize() {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(3);
        stack.push(4);

        assertEquals(2, stack.getSize());
    }
}
