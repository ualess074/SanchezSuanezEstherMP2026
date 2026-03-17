package org.mp.sesion03.matriz;

public abstract class MatrizGenerica<T> {

    protected Object[][] matriz; // <-- usar Object en lugar de T[][]
    protected int filas;
    protected int columnas;

    public MatrizGenerica(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;

        matriz = new Object[filas][columnas]; // Object[][] funciona perfectamente

        // Rellenar con ceroElemento()
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                matriz[i][j] = ceroElemento();
    }

    protected abstract MatrizGenerica<T> crearMatriz(int filas, int columnas);

    protected abstract T sumarElementos(T a, T b);
    protected abstract T multiplicarElementos(T a, T b);
    protected abstract T ceroElemento();

    // Setter y getter
    public void setValor(int fila, int columna, T valor) {
        matriz[fila][columna] = valor;
    }

    @SuppressWarnings("unchecked")
    public T getValor(int fila, int columna) {
        return (T) matriz[fila][columna]; // cast seguro
    }

    @SuppressWarnings("unchecked")
    public T[][] getMatriz() {
        return (T[][]) matriz; // cast seguro para uso en tests
    }

    public MatrizGenerica<T> sumar(MatrizGenerica<T> otra) {
        if (otra.filas != filas || otra.columnas != columnas)
            throw new IllegalArgumentException("Dimensiones distintas");

        MatrizGenerica<T> res = crearMatriz(filas, columnas);

        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                res.setValor(i, j, sumarElementos(getValor(i,j), otra.getValor(i,j)));

        return res;
    }

    public MatrizGenerica<T> transponer() {
        MatrizGenerica<T> t = crearMatriz(columnas, filas);

        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                t.setValor(j, i, getValor(i,j));

        return t;
    }
}