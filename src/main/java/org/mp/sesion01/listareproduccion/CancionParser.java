package org.mp.sesion01.listareproduccion;

public class CancionParser {

    public static Cancion parse(String datosCancion) throws ParseException {

        if (datosCancion == null) {
            throw new ParseException("Formato incorrecto");
        }

        String[] partes = datosCancion.split(";");

        if (partes.length != 5) {
            throw new ParseException("Formato incorrecto");
        }

        if (!partes[0].equals("CANCION")) {
            throw new ParseException("Formato incorrecto");
        }

        String titulo = partes[1];
        String artista = partes[2];

        int duracion;
        try {
            duracion = Integer.parseInt(partes[3]);
        } catch (Exception e) {
            throw new ParseException("Duración inválida");
        }

        String genero = partes[4];

        return new Cancion(titulo, artista, duracion, genero);
    }
}


