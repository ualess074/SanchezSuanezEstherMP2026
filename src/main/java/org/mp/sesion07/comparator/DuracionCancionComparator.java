package org.mp.sesion07.comparator;

import java.util.Comparator;

public class DuracionCancionComparator implements Comparator<Cancion> {

    @Override
    public int compare(Cancion c1, Cancion c2) {
        return Integer.compare(c1.getDuracion(), c2.getDuracion());
    }
}
