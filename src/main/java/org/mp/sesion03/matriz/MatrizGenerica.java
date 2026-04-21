package org.mp.sesion03.matriz;

public abstract class MatrizGenerica<T extends Number> {

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
    
    public MatrizGenerica<T> multiplicar(MatrizGenerica<T> otra) {

        if (this.columnas != otra.filas) {
            throw new IllegalArgumentException("Dimensiones incompatibles");
        }

        MatrizGenerica<T> resultado = crearMatriz(this.filas, otra.columnas);

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < otra.columnas; j++) {

                T suma = ceroElemento();

                for (int k = 0; k < this.columnas; k++) {

                    T a = getValor(i, k);
                    T b = otra.getValor(k, j);

                    if (a == null || b == null) {
                        throw new IllegalArgumentException("Elemento nulo");
                    }

                    suma = sumarElementos(suma, multiplicarElementos(a, b));
                }

                resultado.setValor(i, j, suma);
            }
        }

        return resultado;
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

        T[][] copia = (T[][]) new Number[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                copia[i][j] = (T) matriz[i][j];
            }
        }

        return copia;
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