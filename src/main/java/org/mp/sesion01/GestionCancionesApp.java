package org.mp.sesion01;

import java.text.ParseException;

import org.mp.sesion01.listareproduccion.Cancion;
import org.mp.sesion01.listareproduccion.CancionParser;
import org.mp.sesion01.listareproduccion.ListaDeReproduccion;

/**
 * Clase principal para la gestión de canciones.
 * <p>
 * Esta aplicación crea una lista de reproducción a partir de un conjunto de
 * datos predefinidos, agrega las canciones parseadas, muestra las canciones
 * originales y luego muestra las canciones ordenadas.
 * </p>
 * 
 * @author SanchezSuanezEsther
 * @version 1.0
 */
public class GestionCancionesApp {

    /**
     * Método principal que ejecuta la aplicación de gestión de canciones.
     * <p>
     * Se encarga de:
     * <ul>
     *   <li>Crear la lista de reproducción</li>
     *   <li>Parsear los datos de las canciones y agregarlas a la lista</li>
     *   <li>Mostrar las canciones creadas</li>
     *   <li>Ordenar la lista de canciones y mostrarlas ordenadas</li>
     * </ul>
     */
     
    
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
