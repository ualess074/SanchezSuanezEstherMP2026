package org.mp.sesion02;

/**
 * Excepción personalizada para errores de parseo.
 */
public class MiParseadoException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public MiParseadoException(String message) {
        super(message);
    }

    public MiParseadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
