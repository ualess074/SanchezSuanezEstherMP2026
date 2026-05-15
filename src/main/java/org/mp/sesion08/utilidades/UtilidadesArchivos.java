package org.mp.sesion08.utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesArchivos {

    public static void crearArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        archivo.createNewFile();
    }

    public static boolean verificarExistenciaArchivo(String ruta) {
        return new File(ruta).exists();
    }

    public static boolean eliminarArchivo(String ruta) {
        return new File(ruta).delete();
    }

    public static String obtenerNombreArchivo(String rutaCompleta) {
        return new File(rutaCompleta).getName();
    }

    public static String obtenerRutaPadre(String rutaCompleta) {
        return new File(rutaCompleta).getParent();
    }

    public static void copiarArchivo(String rutaOrigen, String rutaDestino) throws IOException {
        Files.copy(Paths.get(rutaOrigen), Paths.get(rutaDestino),
                StandardCopyOption.REPLACE_EXISTING);
    }

    public static void moverArchivo(String rutaOrigen, String rutaDestino) throws IOException {
        Files.move(Paths.get(rutaOrigen), Paths.get(rutaDestino),
                StandardCopyOption.REPLACE_EXISTING);
    }

    public static long obtenerTamanioArchivo(String ruta) throws IOException {
        return Files.size(Paths.get(ruta));
    }

    public static boolean verificarSiEsDirectorio(String ruta) {
        return Files.isDirectory(Paths.get(ruta));
    }

    public static Path obtenerRutaActual() {
        return Paths.get(System.getProperty("user.dir"));
    }

    public static Path obtenerRutaRaiz() {
        return Paths.get(File.listRoots()[0].getAbsolutePath());
    }

    public static Path obtenerRutaRelativa(Path rutaBase, Path rutaEspecifica) {
        return rutaBase.relativize(rutaEspecifica);
    }

    public static String obtenerStringRuta(Path ruta) {
        return ruta.toString();
    }

    public static boolean compararRutas(Path ruta1, Path ruta2) {
        return ruta1.equals(ruta2);
    }

    public static void copiarDirectorioRecursivamente(String rutaOrigen,
                                                      String rutaDestino) throws IOException {

        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);

        Files.walk(origen).forEach(source -> {

            Path destination = destino.resolve(origen.relativize(source));

            try {
                Files.copy(source, destination,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void copiarArchivosConFiltro(String rutaOrigen,
                                               String rutaDestino,
                                               String filtroNombre) throws IOException {

        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);

        if (!Files.exists(destino)) {
            Files.createDirectories(destino);
        }

        Files.list(origen).forEach(path -> {

            if (path.getFileName().toString().matches(filtroNombre)) {

                try {
                    Files.copy(path,
                            destino.resolve(path.getFileName()),
                            StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static List<File> listarArchivosEnDirectorio(String rutaDirectorio)
            throws IOException {

        List<File> archivos = new ArrayList<>();

        Files.list(Paths.get(rutaDirectorio))
                .forEach(path -> archivos.add(path.toFile()));

        return archivos;
    }

    public static void recorrerDirectorioRecursivamente(String rutaDirectorio,
                                                        FileVisitor<Path> visitor)
            throws IOException {

        Files.walkFileTree(Paths.get(rutaDirectorio), visitor);
    }
}
