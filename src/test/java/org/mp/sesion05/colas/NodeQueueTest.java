package org.mp.sesion05.colas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeQueueTest {

    @Test
    void testEnqueueDequeue() {
        Queue<Integer> queue = new NodeQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    void testFront() { // ✔ antes peek
        Queue<Integer> queue = new NodeQueue<>();

        queue.enqueue(10);
        assertEquals(10, queue.front());
    }

    @Test
    void testEmpty() {
        Queue<Integer> queue = new NodeQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testSize() { // ✔ antes getSize
        Queue<Integer> queue = new NodeQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size());
    }
}