package org.mp.sesion03.pares;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParTest {

    @Test
    void testCrearPar() {

        Par<String,Integer> par = new Par<>("edad",25);

        assertEquals("edad", par.getPrimero());
        assertEquals(25, par.getSegundo());
    }

    @Test
    void testToString() {

        Par<String,Integer> par = new Par<>("A",10);

        assertEquals("(A, 10)", par.toString());
    }
}
