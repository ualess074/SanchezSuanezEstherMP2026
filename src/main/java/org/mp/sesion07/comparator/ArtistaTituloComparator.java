package org.mp.sesion07.comparator;

import java.util.Comparator;

public class ArtistaTituloComparator implements Comparator<Album> {
    @Override
    public int compare(Album a1, Album a2) {
        int cmp = a1.getArtista().compareTo(a2.getArtista());
        if (cmp == 0) {
            return a1.getNombre().compareTo(a2.getNombre());
        }
        return cmp;
    }
}
