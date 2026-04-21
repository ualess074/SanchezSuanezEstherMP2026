package org.mp.sesion01;

import java.text.ParseException;

import org.mp.sesion01.listareproduccion.Cancion;
import org.mp.sesion01.listareproduccion.CancionParser;
import org.mp.sesion01.listareproduccion.ListaDeReproduccion;

public class GestionCancionesApp {

    public static void main(String[] args) {

        ListaDeReproduccion lista =
                new ListaDeReproduccion("misFavoritas",
                        FuenteDeDatos.DATOS_CANCIONES.length);

        for (String datos : FuenteDeDatos.DATOS_CANCIONES) {
            try {
                Cancion c = CancionParser.parse(datos);
                lista.agregarCancion(c);
            } catch (ParseException e) {
                System.out.println("Error al parsear: " + e.getMessage());
            }
        }

        System.out.println("--- Canciones creadas ---");
        lista.mostrarCanciones();

        lista.ordenarCanciones();

        System.out.println("\n--- Canciones ordenadas ---");
        lista.mostrarCanciones();
    }
}
