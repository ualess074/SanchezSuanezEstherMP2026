package org.mp.sesion09.mp3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javazoom.jl.player.Player;

/**
 * Aplicación interactiva para listar y reproducir archivos MP3.
 */
public class MP3App {

    public static void main(String[] args) {
        System.out.println("=== Reproductor Interactivo MP3 (ID3v1 + JLayer) ===");
        
        File carpeta = new File("src/main/resources/audio");
        if (!carpeta.exists()) {
            System.err.println("La carpeta de recursos no existe: " + carpeta.getAbsolutePath());
            System.err.println("Por favor, cree la carpeta y añada archivos .mp3");
            return;
        }
        
        File[] archivos = carpeta.listFiles();
        
        // Filtrado manual para evitar lambdas
        List<File> listaMp3 = new ArrayList<>();
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].getName().toLowerCase().endsWith(".mp3")) {
                    listaMp3.add(archivos[i]);
                }
            }
        }

        if (listaMp3.isEmpty()) {
            System.out.println("No se han encontrado archivos .mp3 en " + carpeta.getAbsolutePath());
            return;
        }

        List<Cancion> biblioteca = new ArrayList<>();
        System.out.println("\nEscaneando biblioteca...\n");
        System.out.printf("%-3s | %-30s | %-20s%n", "ID", "TÍTULO", "ARTISTA");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < listaMp3.size(); i++) {
            try {
                Cancion s = LectorMetadatosMP3.leer(listaMp3.get(i).getAbsolutePath());
                biblioteca.add(s);
                System.out.printf("%02d  | %-30s | %-20s%n", 
                                  (i + 1),
                                  truncar(s.getTitulo(), 30), 
                                  truncar(s.getArtista(), 20));
            } catch (Exception e) {
                System.err.println("Error leyendo " + listaMp3.get(i).getName());
            }
        }

        if (biblioteca.isEmpty()) return;

        // Interacción con el usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduzca el ID de la canción que desea escuchar (0 para salir): ");
        int eleccion = scanner.nextInt();

        if (eleccion > 0 && eleccion <= biblioteca.size()) {
            Cancion seleccionada = biblioteca.get(eleccion - 1);
            reproducir(seleccionada);
        } else {
            System.out.println("Saliendo...");
        }
        scanner.close();
    }

    private static void reproducir(Cancion cancion) {
        System.out.println("\n>>> Reproduciendo: " + cancion.getTitulo() + " - " + cancion.getArtista());
        System.out.println("(La reproducción terminará cuando acabe el archivo o cierre la aplicación)");
        
        try (FileInputStream fis = new FileInputStream(cancion.getRutaArchivo());
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            
            Player player = new Player(bis);
            player.play(); // Esta llamada es bloqueante
            
        } catch (Exception e) {
            System.err.println("Error al reproducir el archivo: " + e.getMessage());
        }
    }

    private static String truncar(String texto, int longitud) {
        if (texto == null) return "";
        return texto.length() <= longitud ? texto : texto.substring(0, longitud - 3) + "...";
    }
}
