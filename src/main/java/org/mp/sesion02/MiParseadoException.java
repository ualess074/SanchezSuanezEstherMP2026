package org.mp.sesion02;

/**
 * Excepción personalizada para errores de parseo.
 */
public class MiParseadoException extends Exception {

    public MiParseadoException(String message) {
        super(message);
    }

    public MiParseadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
