package org.mp.sesion01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FahrenheitACelsiusTest {

    @Test
    void testTemperaturaAmbiente() throws Exception {
        assertEquals(20.00f, FahrenheitACelsius.convertir(68f));
    }

    @Test
    void testCongelacion() throws Exception {
        assertEquals(0.00f, FahrenheitACelsius.convertir(32f));
    }

    @Test
    void testEbullicion() throws Exception {
        assertEquals(100.00f, FahrenheitACelsius.convertir(212f));
    }

    @Test
    void testTemperaturaNegativa() throws Exception {
        assertEquals(-40.00f, FahrenheitACelsius.convertir(-40f));
    }

    @Test
    void testCeroAbsoluto() throws Exception {
        assertEquals(-273.15f, FahrenheitACelsius.convertir(-459.67f));
    }

    @Test
    void testTemperaturaAlta() throws Exception {
        assertEquals(537.78f, FahrenheitACelsius.convertir(1000f));
    }

    @Test
    void testExcepcion() {
        assertThrows(TemperaturaBajoCeroKelvinException.class,
                () -> FahrenheitACelsius.convertir(-500f));
    }
}

