package org.mp.sesion03.notas;

import org.mp.sesion03.pares.Par;

public class Notas {

    private Par<String, Double>[] calificaciones;
    private int numCalificaciones;

    @SuppressWarnings("unchecked")
    public Notas(int capacidad) {
        calificaciones = new Par[capacidad];
        numCalificaciones = 0;
    }

    public boolean agregarNota(String idAlumno, Double nota) {

        if (numCalificaciones >= calificaciones.length) {
            return false;
        }

        for (int i = 0; i < numCalificaciones; i++) {
            if (calificaciones[i].getPrimero().equals(idAlumno)) {
                return false;
            }
        }

        calificaciones[numCalificaciones] = new Par<>(idAlumno, nota);
        numCalificaciones++;

        return true;
    }

    public Double obtenerNota(String idAlumno) {

        for (int i = 0; i < numCalificaciones; i++) {

            if (calificaciones[i].getPrimero().equals(idAlumno)) {
                return calificaciones[i].getSegundo();
            }

        }

        return null;
    }

    public Double calcularMedia() {

        if (numCalificaciones == 0) {
            return 0.0;
        }

        double suma = 0;

        for (int i = 0; i < numCalificaciones; i++) {
            suma += calificaciones[i].getSegundo();
        }

        return suma / numCalificaciones;
    }

    public String listarNotas() {

        String resultado = "";

        for (int i = 0; i < numCalificaciones; i++) {
            resultado += calificaciones[i].toString() + "\n";
        }

        return resultado;
    }
}
