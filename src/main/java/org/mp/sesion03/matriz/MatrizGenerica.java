package org.mp.sesion03.matriz;

public abstract class MatrizGenerica<T extends Number> {

    protected T[][] matriz;
    protected int filas;
    protected int columnas;

    @SuppressWarnings("unchecked")
    public MatrizGenerica(int filas, int columnas) {

        this.filas = filas;
        this.columnas = columnas;

        matriz = (T[][]) new Number[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ceroElemento();
            }
        }
    }

    public void setValor(int fila, int columna, T valor) {
        matriz[fila][columna] = valor;
    }

    public T[][] getMatriz() {
        return matriz;
    }

    public MatrizGenerica<T> sumar(MatrizGenerica<T> otra) {

        MatrizGenerica<T> resultado = crearMatriz(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                resultado.matriz[i][j] =
                        sumarElementos(matriz[i][j], otra.matriz[i][j]);

            }
        }

        return resultado;
    }

    public MatrizGenerica<T> multiplicar(MatrizGenerica<T> otra) {

        MatrizGenerica<T> resultado = crearMatriz(filas, otra.columnas);

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < otra.columnas; j++) {

                T suma = ceroElemento();

                for (int k = 0; k < columnas; k++) {

                    suma = sumarElementos(
                            suma,
                            multiplicarElementos(
                                    matriz[i][k],
                                    otra.matriz[k][j]
                            )
                    );
                }

                resultado.matriz[i][j] = suma;
            }
        }

        return resultado;
    }

    public MatrizGenerica<T> transponer() {

        MatrizGenerica<T> resultado = crearMatriz(columnas, filas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[j][i] = matriz[i][j];
            }
        }

        return resultado;
    }

    @Override
    public String toString() {

        String texto = "";

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {
                texto += matriz[i][j] + " ";
            }

            texto += "\n";
        }

        return texto;
    }

    protected abstract MatrizGenerica<T> crearMatriz(int filas, int columnas);

    protected abstract T sumarElementos(T a, T b);

    protected abstract T multiplicarElementos(T a, T b);

    protected abstract T ceroElemento();
}
