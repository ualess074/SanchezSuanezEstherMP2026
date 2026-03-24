package org.mp.sesion05.pilas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    @Test
    void testPushPop() {
        Stack<Integer> stack = new ArrayStack<>(10);

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        Stack<Integer> stack = new ArrayStack<>(10);

        stack.push(5);
        assertEquals(5, stack.peek());
    }

    @Test
    void testEmpty() {
        Stack<Integer> stack = new ArrayStack<>(10);
        assertTrue(stack.isEmpty());
    }
}