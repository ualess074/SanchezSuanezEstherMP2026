package org.mp.sesion03.notas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotasTest {

    @Test
    void testAgregarNota() {

        Notas notas = new Notas(3);

        assertTrue(notas.agregarNota("A1",7.0));
        assertTrue(notas.agregarNota("A2",8.0));
    }

    @Test
    void testDuplicado() {

        Notas notas = new Notas(3);

        notas.agregarNota("A1",7.0);

        assertFalse(notas.agregarNota("A1",9.0));
    }

    @Test
    void testObtenerNota() {

        Notas notas = new Notas(3);

        notas.agregarNota("A1",7.5);

        assertEquals(7.5, notas.obtenerNota("A1"));
    }

    @Test
    void testMedia() {

        Notas notas = new Notas(3);

        notas.agregarNota("A1",7.0);
        notas.agregarNota("A2",9.0);

        assertEquals(8.0, notas.calcularMedia());
    }
}
