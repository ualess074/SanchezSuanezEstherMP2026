package org.mp.sesion01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MayorTest {

    @Test
    void testMayorNormal() {
        int[] datos = {1, 5, 3, 9, 2};
        assertEquals(9, Mayor.elEnteroMayor(datos));
    }

    @Test
    void testMayorNegativos() {
        int[] datos = {-10, -3, -50};
        assertEquals(-3, Mayor.elEnteroMayor(datos));
    }

    @Test
    void testMayorUnSoloElemento() {
        int[] datos = {7};
        assertEquals(7, Mayor.elEnteroMayor(datos));
    }
}
