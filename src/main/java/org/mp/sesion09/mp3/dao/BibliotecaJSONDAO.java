package org.mp.sesion09.mp3.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mp.sesion09.mp3.Biblioteca;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BibliotecaJSONDAO implements BibliotecaDAO {

    @Override
    public void guardar(Biblioteca bib, String ruta)
            throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter(ruta);

        gson.toJson(bib, writer);

        writer.close();
    }

    @Override
    public Biblioteca cargar(String ruta)
            throws IOException {

        Gson gson = new Gson();

        FileReader reader = new FileReader(ruta);

        Biblioteca bib =
                gson.fromJson(reader, Biblioteca.class);

        reader.close();

        return bib;
    }
}
