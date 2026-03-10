package org.mp.sesion03.mezclalineal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MezclaLinealTest {

    @Test
    void testMezclaEnteros() {

        int[] a = {1,3,5};
        int[] b = {2,4,6};

        int[] resultado = MezclaLineal.mezclaLinealInt(a,b);

        assertArrayEquals(new int[]{1,2,3,4,5,6}, resultado);
    }

    @Test
    void testMezclaComparables() {

        Integer[] a = {1,3,5};
        Integer[] b = {2,4,6};

        Integer[] resultado = MezclaLineal.mezclaLinealComparables(a,b);

        assertArrayEquals(new Integer[]{1,2,3,4,5,6}, resultado);
    }
}
