package org.mp.sesion09.audio.efectos;

import org.mp.sesion09.audio.ArchivoWav;
import org.mp.sesion09.audio.CanalAudio;

import java.util.ListIterator;

public class EfectoVolumen implements EfectoAudio {

    private double factor;

    public EfectoVolumen(double factor) {
        this.factor = factor;
    }

    @Override
    public void aplicar(ArchivoWav wav) {

        for (CanalAudio canal : wav.getCanales()) {

            ListIterator<Short> iterator =
                    canal.getMuestras().listIterator();

            while (iterator.hasNext()) {

                short muestraOriginal = iterator.next();

                int nuevaMuestra =
                        (int) (muestraOriginal * factor);

                if (nuevaMuestra > Short.MAX_VALUE) {
                    nuevaMuestra = Short.MAX_VALUE;
                }

                if (nuevaMuestra < Short.MIN_VALUE) {
                    nuevaMuestra = Short.MIN_VALUE;
                }

                iterator.set((short) nuevaMuestra);
            }
        }
    }
}
