package org.mp.sesion03.notas;

public class GestionNotasApp {

    public static void main(String[] args) {

        Notas notas = new Notas(5);

        System.out.println("Añadir notas");

        System.out.println(notas.agregarNota("A001", 7.5));
        System.out.println(notas.agregarNota("A002", 8.0));
        System.out.println(notas.agregarNota("A003", 6.5));

        System.out.println("Intentar duplicado");

        System.out.println(notas.agregarNota("A001", 9.0));

        System.out.println("Notas:");

        System.out.println(notas.listarNotas());

        System.out.println("Nota alumno A002:");
        System.out.println(notas.obtenerNota("A002"));

        System.out.println("Media:");
        System.out.println(notas.calcularMedia());
    }
}
