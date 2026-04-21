package org.mp.sesion01.listareproduccion;

import java.text.ParseException;

public class CancionParser {

    public static Cancion parse(String datosCancion) throws ParseException {

        if (datosCancion == null) {
            throw new ParseException("Formato incorrecto", 0);
        }

        String[] partes = datosCancion.split(";");

        // Validar formato completo
        if (partes.length != 5) {
            throw new ParseException("Formato incorrecto", 0);
        }

        if (!partes[0].equals("CANCION")) {
            throw new ParseException("Formato incorrecto", 0);
        }

        String titulo = partes[1];
        String artista = partes[2];

        int duracion;
        try {
            duracion = Integer.parseInt(partes[3]);
        } catch (Exception e) {
            throw new ParseException("Duración inválida", 0);
        }

        String genero = partes[4];

        return new Cancion(titulo, artista, duracion, genero);
    }
}


