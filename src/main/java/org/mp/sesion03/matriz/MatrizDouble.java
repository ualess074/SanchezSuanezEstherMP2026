package org.mp.sesion03.matriz;

public class MatrizDouble extends MatrizGenerica<Double> {

    public MatrizDouble(int filas, int columnas) {
        super(filas, columnas);
    }

    @Override
    protected MatrizGenerica<Double> crearMatriz(int filas, int columnas) {
        return new MatrizDouble(filas, columnas);
    }

    @Override
    protected Double sumarElementos(Double a, Double b) {
        return a + b;
    }

    @Override
    protected Double multiplicarElementos(Double a, Double b) {
        return a * b;
    }

    @Override
    protected Double ceroElemento() {
        return 0.0;
    }
}
