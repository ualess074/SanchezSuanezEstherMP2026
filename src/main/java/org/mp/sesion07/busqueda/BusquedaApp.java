package org.mp.sesion07.busqueda;

public class BusquedaApp {

    public static void main(String[] args) {

        try {
            // Crear problema de búsqueda con 10 elementos
            Busqueda<Integer> busqueda = new Busqueda<>(10);

            // Mostrar datos
            System.out.println(busqueda);

            // 🔍 Búsqueda lineal
            int posLineal = SolucionesBusqueda.busquedaLineal(busqueda);
            System.out.println("Posición (Lineal): " + posLineal);

            // 🔍 Búsqueda binaria iterativa
            int posBinIter = SolucionesBusqueda.busquedaBinariaIter(busqueda);
            System.out.println("Posición (Binaria Iterativa): " + posBinIter);

            // 🔍 Búsqueda binaria recursiva
            int posBinRec = SolucionesBusqueda.busquedaBinariaRec(busqueda);
            System.out.println("Posición (Binaria Recursiva): " + posBinRec);

            // 🔍 Arrays.binarySearch
            int posArrays = SolucionesBusqueda.busquedaArraysBinarySearch(busqueda);
            System.out.println("Posición (Arrays.binarySearch): " + posArrays);

        } catch (ElementoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}