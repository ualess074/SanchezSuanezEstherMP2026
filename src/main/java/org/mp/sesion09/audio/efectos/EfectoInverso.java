package org.mp.sesion09.audio.efectos;

import org.mp.sesion09.audio.ArchivoWav;
import org.mp.sesion09.audio.CanalAudio;

import java.util.Collections;

public class EfectoInverso implements EfectoAudio {

    @Override
    public void aplicar(ArchivoWav wav) {

        for (CanalAudio canal : wav.getCanales()) {

            Collections.reverse(canal.getMuestras());
        }
    }
}
