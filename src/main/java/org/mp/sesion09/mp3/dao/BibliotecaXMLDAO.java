package org.mp.sesion09.mp3.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.mp.sesion09.mp3.Biblioteca;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BibliotecaXMLDAO implements BibliotecaDAO {

    @Override
    public void guardar(Biblioteca bib, String ruta)
            throws IOException {

        XStream xstream = new XStream();

        FileWriter writer = new FileWriter(ruta);

        xstream.toXML(bib, writer);

        writer.close();
    }

    @Override
    public Biblioteca cargar(String ruta)
            throws IOException {

        XStream xstream = new XStream();

        xstream.addPermission(AnyTypePermission.ANY);

        FileReader reader = new FileReader(ruta);

        Biblioteca bib =
                (Biblioteca) xstream.fromXML(reader);

        reader.close();

        return bib;
    }
}
