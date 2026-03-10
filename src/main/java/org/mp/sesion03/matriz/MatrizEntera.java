package org.mp.sesion03.matriz;

public class MatrizEntera extends MatrizGenerica<Integer> {

    public MatrizEntera(int filas, int columnas) {
        super(filas, columnas);
    }

    @Override
    protected MatrizGenerica<Integer> crearMatriz(int filas, int columnas) {
        return new MatrizEntera(filas, columnas);
    }

    @Override
    protected Integer sumarElementos(Integer a, Integer b) {
        return a + b;
    }

    @Override
    protected Integer multiplicarElementos(Integer a, Integer b) {
        return a * b;
    }

    @Override
    protected Integer ceroElemento() {
        return 0;
    }
}
