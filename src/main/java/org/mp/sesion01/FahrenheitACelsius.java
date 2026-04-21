package org.mp.sesion01;

public class FahrenheitACelsius {

    public static float convertir(float fahrenheit)
            throws TemperaturaBajoCeroKelvinException {

        if (fahrenheit < -459.67f) {
            throw new TemperaturaBajoCeroKelvinException();
        }

        float celsius = (fahrenheit - 32) * 5 / 9;

        return Math.round(celsius * 100f) / 100f;
    }
}

