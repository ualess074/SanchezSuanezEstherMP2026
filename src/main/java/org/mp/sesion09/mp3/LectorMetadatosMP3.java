package org.mp.sesion09.mp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LectorMetadatosMP3 {

    public static Cancion leer(String rutaArchivo) throws IOException {

        File archivo = new File(rutaArchivo);

        FileInputStream fis = new FileInputStream(archivo);

        long posicion = archivo.length() - 128;

        fis.skip(posicion);

        byte[] buffer = new byte[128];

        fis.read(buffer);

        fis.close();

        String tag = new String(buffer, 0, 3);

        if (!tag.equals("TAG")) {
            throw new IOException("No contiene etiquetas ID3v1");
        }

        String titulo =
                new String(buffer, 3, 30).trim();

        String artista =
                new String(buffer, 33, 30).trim();

        String album =
                new String(buffer, 63, 30).trim();

        String anio =
                new String(buffer, 93, 4).trim();

        return new Cancion(
                titulo,
                artista,
                album,
                anio,
                rutaArchivo
        );
    }
}
