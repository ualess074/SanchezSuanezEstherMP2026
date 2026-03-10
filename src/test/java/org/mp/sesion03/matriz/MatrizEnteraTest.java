package org.mp.sesion03.matriz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrizEnteraTest {

    @Test
    void testSuma() {

        MatrizEntera m1 = new MatrizEntera(2,2);
        MatrizEntera m2 = new MatrizEntera(2,2);

        m1.setValor(0,0,1);
        m1.setValor(0,1,2);
        m1.setValor(1,0,3);
        m1.setValor(1,1,4);

        m2.setValor(0,0,1);
        m2.setValor(0,1,1);
        m2.setValor(1,0,1);
        m2.setValor(1,1,1);

        MatrizGenerica<Integer> resultado = m1.sumar(m2);

        assertEquals(2, resultado.getMatriz()[0][0]);
        assertEquals(3, resultado.getMatriz()[0][1]);
    }

    @Test
    void testTransponer() {

        MatrizEntera m = new MatrizEntera(2,3);

        m.setValor(0,1,5);

        MatrizGenerica<Integer> t = m.transponer();

        assertEquals(5, t.getMatriz()[1][0]);
    }
}
