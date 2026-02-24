package org.mp.sesion01;

/**
 * Clase que proporciona la conversión de temperaturas de Fahrenheit a Celsius.
 * <p>
 * Esta clase incluye un método que verifica que la temperatura no esté por
 * debajo del cero absoluto antes de realizar la conversión.
 * </p>
 * 
 * @author SanchezSuanezEsther
 * @version 1.0
 */
public class FahrenheitACelsius {

    /**
     * Convierte una temperatura de Fahrenheit a Celsius.
     * <p>
     * La fórmula utilizada es: (Fahrenheit - 32) * 5 / 9.
     * Además, se redondea el resultado a 2 decimales.
     * </p>
     * 
     * @param fahrenheit la temperatura en grados Fahrenheit
     * @return la temperatura convertida en grados Celsius, redondeada a 2 decimales
     * @throws TemperaturaBajoCeroKelvinException si la temperatura está por debajo del cero absoluto (-459.67°F)
     */
    public static float convertir(float fahrenheit) 
            throws TemperaturaBajoCeroKelvinException {

        // Verificar cero absoluto
        if (fahrenheit < -459.67f) {
            throw new TemperaturaBajoCeroKelvinException();
        }

        // Aplicar fórmula
        float celsius = (fahrenheit - 32) * 5 / 9;

        // Redondear a 2 decimales
        celsius = Math.round(celsius * 100f) / 100f;

        return celsius;
    }
}

