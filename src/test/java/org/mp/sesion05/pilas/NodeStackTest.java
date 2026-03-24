package org.mp.sesion05.pilas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {

    @Test
    void testPushPop() {
        Stack<Integer> stack = new NodeStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        Stack<Integer> stack = new NodeStack<>();

        stack.push(10);
        assertEquals(10, stack.peek());
    }

    @Test
    void testEmpty() {
        Stack<Integer> stack = new NodeStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSize() {
        Stack<Integer> stack = new NodeStack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.getSize());
    }
}
