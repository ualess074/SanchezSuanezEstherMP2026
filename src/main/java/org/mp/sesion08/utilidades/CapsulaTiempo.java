package org.mp.sesion08.utilidades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.mp.sesion07.comparator.Cancion;

public class CapsulaTiempo {

    public static void guardarPlaylist(List<Cancion> playlist,
                                       String ruta) throws IOException {

        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(ruta)))) {

            for (Cancion c : playlist) {

                pw.println(c.getArtista() + ";"
                        + c.getTitulo() + ";"
                        + c.getDuracion());
            }
        }
    }

    public static List<Cancion> cargarPlaylist(String ruta)
            throws IOException {

        List<Cancion> playlist = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");

                String artista = partes[0];
                String titulo = partes[1];
                int duracion = Integer.parseInt(partes[2]);

                playlist.add(new Cancion(artista, titulo, duracion));
            }
        }

        return playlist;
    }
}
