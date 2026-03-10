package org.mp.sesion03.arraydinamico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayDinamicoTest {

    @Test
    void testAgregar() {

        ArrayDinamico<Integer> array = new ArrayDinamico<>();

        array.agregar(10);
        array.agregar(20);

        assertEquals(2, array.tamaño());
    }

    @Test
    void testObtener() {

        ArrayDinamico<String> array = new ArrayDinamico<>();

        array.agregar("hola");

        assertEquals("hola", array.obtener(0));
    }
}
