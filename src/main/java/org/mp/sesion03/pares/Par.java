package org.mp.sesion03.pares;

/**
 * Clase genérica que almacena un par de valores.
 * @param <K> tipo del primer valor
 * @param <V> tipo del segundo valor
 */
public class Par<K, V> {

    private K primero;
    private V segundo;

    /**
     * Constructor
     */
    public Par(K primero, V segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public K getPrimero() {
        return primero;
    }

    public V getSegundo() {
        return segundo;
    }

    @Override
    public String toString() {
        return "(" + primero + ", " + segundo + ")";
    }
}