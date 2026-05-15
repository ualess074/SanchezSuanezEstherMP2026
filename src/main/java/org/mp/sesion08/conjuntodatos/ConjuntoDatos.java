package org.mp.sesion08.conjuntodatos;

import java.io.*;
import java.util.*;

public class ConjuntoDatos {

    private File archivoTexto;
    private String separador;
    private Locale locale;

    private ArrayList<String> cabecera;
    private String[][] datos;

    public ConjuntoDatos(File archivoTexto, String separador, Locale locale) throws IOException {
        this.archivoTexto = archivoTexto;
        this.separador = separador;
        this.locale = locale;

        cargarDatos();
    }

    private void cargarDatos() throws IOException {

        List<String[]> filas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {

            String linea = br.readLine();

            cabecera = new ArrayList<>(Arrays.asList(linea.split(separador)));

            while ((linea = br.readLine()) != null) {
                filas.add(linea.split(separador));
            }
        }

        datos = new String[filas.size()][];

        for (int i = 0; i < filas.size(); i++) {
            datos[i] = filas.get(i);
        }
    }

    public File getArchivoTexto() {
        return archivoTexto;
    }

    public int getNumeroColumnas() {
        return cabecera.size();
    }

    public int getNumeroLineas() {
        return datos.length;
    }

    public String getSeparador() {
        return separador;
    }

    public Locale getLocale() {
        return locale;
    }

    public ArrayList<String> getCabecera() {
        return cabecera;
    }

    public String[][] getDatosString() {
        return datos;
    }

    public String[] getColumna(int indice) {

        if (indice >= getNumeroColumnas()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        String[] columna = new String[getNumeroLineas()];

        for (int i = 0; i < getNumeroLineas(); i++) {
            columna[i] = datos[i][indice];
        }

        return columna;
    }

    public String[] getColumna(String nombreColumna) {

        int indice = cabecera.indexOf(nombreColumna);

        if (indice == -1) {
            return null;
        }

        return getColumna(indice);
    }

    public void exportar(String[] columnas, String archivoSalida, String separadorSalida)
            throws IOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(archivoSalida)))) {

            for (int i = 0; i < columnas.length; i++) {
                pw.print(columnas[i]);

                if (i < columnas.length - 1) {
                    pw.print(separadorSalida);
                }
            }

            pw.println();

            for (int fila = 0; fila < getNumeroLineas(); fila++) {

                for (int col = 0; col < columnas.length; col++) {

                    int indiceOriginal = cabecera.indexOf(columnas[col]);

                    pw.print(datos[fila][indiceOriginal]);

                    if (col < columnas.length - 1) {
                        pw.print(separadorSalida);
                    }
                }

                pw.println();
            }
        }
    }
}
