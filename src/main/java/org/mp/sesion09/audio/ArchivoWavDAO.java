package org.mp.sesion09.audio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ArchivoWavDAO {

    public static ArchivoWav leer(String ruta) throws IOException {

        FileInputStream fis = new FileInputStream(ruta);

        CabeceraWav cabecera = new CabeceraWav();
        cabecera.leer(fis);

        ArchivoWav wav = new ArchivoWav(cabecera);

        int bytesPorMuestra = cabecera.bitsPorMuestra / 8;

        int numMuestras =
                cabecera.subchunk2Size /
                (cabecera.numeroCanales * bytesPorMuestra);

        byte[] buffer = new byte[2];

        for (int i = 0; i < numMuestras; i++) {

            for (int c = 0; c < cabecera.numeroCanales; c++) {

                if (fis.read(buffer) != 2) {
                    break;
                }

                short muestra = ByteBuffer.wrap(buffer)
                        .order(ByteOrder.LITTLE_ENDIAN)
                        .getShort();

                wav.getCanal(c).addMuestra(muestra);
            }
        }

        fis.close();

        return wav;
    }

    public static void escribir(ArchivoWav wav, String ruta)
            throws IOException {

        wav.updateHeader();

        FileOutputStream fos = new FileOutputStream(ruta);

        wav.getCabecera().escribir(fos);

        int numMuestras = wav.getCanal(0).size();

        for (int i = 0; i < numMuestras; i++) {

            for (int c = 0;
                 c < wav.getCabecera().numeroCanales;
                 c++) {

                short muestra =
                        wav.getCanal(c)
                                .getMuestras()
                                .get(i);

                ByteBuffer bb = ByteBuffer.allocate(2);

                bb.order(ByteOrder.LITTLE_ENDIAN);

                bb.putShort(muestra);

                fos.write(bb.array());
            }
        }

        fos.close();
    }
}