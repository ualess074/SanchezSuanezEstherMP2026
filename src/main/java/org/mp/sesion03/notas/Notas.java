package org.mp.sesion03.notas;

import org.mp.sesion03.pares.Par;

public class Notas {

    private Par<String, Double>[] calificaciones;
    private int numCalificaciones;

    @SuppressWarnings("unchecked")
    public Notas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser un número positivo.");
        }
        calificaciones = new Par[capacidad];
        numCalificaciones = 0;
    }
    
    public int getNumeroNotas() {
        return numCalificaciones;
    }

    public boolean agregarNota(String idAlumno, Double nota) {

        if (idAlumno == null || idAlumno.isEmpty() || nota == null) {
            return false;
        }

        if (nota < 0 || nota > 10) {
            return false;
        }

        if (numCalificaciones >= calificaciones.length) {
            return false;
        }

        for (int i = 0; i < numCalificaciones; i++) {
            if (calificaciones[i].getPrimero().equals(idAlumno)) {
                return false;
            }
        }

        calificaciones[numCalificaciones++] = new Par<>(idAlumno, nota);
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

        if (numCalificaciones == 0) {
            return "No hay calificaciones registradas.";
        }

        String resultado = "";

        for (int i = 0; i < numCalificaciones; i++) {
            resultado += "Alumno: " 
                + calificaciones[i].getPrimero() 
                + ", Nota: " 
                + calificaciones[i].getSegundo() 
                + "\n";
        }

        return resultado;
    }
}
