package org.mp.sesion01.listareproduccion;

import java.text.ParseException;

public class CancionParser {

    public static Cancion parse(String datosCancion) throws ParseException {

        String[] partes = datosCancion.split(";");

        if (partes.length != 5 || !partes[0].equals("CANCION")) {
            throw new ParseException("Formato incorrecto: " + datosCancion, 0);
        }

        String titulo = partes[1];
        String artista = partes[2];
        int duracion;

        try {
            duracion = Integer.parseInt(partes[3]);
        } catch (NumberFormatException e) {
            throw new ParseException("Duración inválida: " + datosCancion, 0);
        }

        String genero = partes[4];

        return new Cancion(titulo, artista, duracion, genero);
    }
}


