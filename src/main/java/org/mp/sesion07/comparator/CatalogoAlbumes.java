package org.mp.sesion07.comparator;

import java.util.ArrayList;
import java.util.List;

public class CatalogoAlbumes {

    private List<Album> albumes = new ArrayList<>();

    public void add(Album a) {
        albumes.add(a);
    }

    public List<Album> getAlbumes() {
        return albumes;
    }
}
