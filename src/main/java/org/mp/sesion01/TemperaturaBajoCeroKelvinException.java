package org.mp.sesion01;

public class TemperaturaBajoCeroKelvinException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public TemperaturaBajoCeroKelvinException() {
        super("¡La temperatura no puede estar por debajo de 0 K!");
    }
}
