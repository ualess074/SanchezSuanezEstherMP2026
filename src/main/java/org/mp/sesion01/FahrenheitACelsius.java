package org.mp.sesion01;

public class FahrenheitACelsius {

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

