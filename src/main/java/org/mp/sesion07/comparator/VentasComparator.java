package org.mp.sesion07.comparator;

import java.util.Comparator;

public class VentasComparator implements Comparator<Album> {
    @Override
    public int compare(Album a1, Album a2) {
        return Long.compare(a1.getVentas(), a2.getVentas());
    }
}
