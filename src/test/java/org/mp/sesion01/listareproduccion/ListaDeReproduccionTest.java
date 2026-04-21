package org.mp.sesion01.listareproduccion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaDeReproduccionTest {

    private Cancion cancion1, cancion2, cancion3, cancion4;
    // Canción extra para test de ordenación por título
    private Cancion cancion5_mismaDuracion; 

    @BeforeEach
    public void setUp() {
        cancion1 = new Cancion("Imagine", "John Lennon", 183, "Pop");
        cancion2 = new Cancion("Bohemian Rhapsody", "Queen", 355, "Rock");
        cancion3 = new Cancion("Stairway to Heaven", "Led Zeppelin", 482, "Rock");
        cancion4 = new Cancion("Hotel California", "Eagles", 390, "Rock");
        cancion5_mismaDuracion = new Cancion("A day in the life", "The Beatles", 355, "Rock");
    }

    @Test
    public void testCancionParserCorrecto() {
        String datos = "CANCION;Imagine;John Lennon;183;Pop";
        try {
            Cancion cancionParseada = CancionParser.parse(datos);
            assertEquals(cancion1, cancionParseada);
        } catch (ParseException e) {
            fail("No debería lanzar excepción con datos correctos");
        }
    }

    @Test
    public void testCancionParserInvalido() {
        String datos = "FORMATO_INCORRECTO;Imagine;John Lennon;183;Pop";
        try {
            CancionParser.parse(datos);
            fail("Se esperaba una ParseException al parsear datos inválidos.");
        } catch (ParseException e) {
            assertTrue(true); // Excepción capturada correctamente
        }
    }
    
    @Test
    public void testCancionParserDuracionInvalida() {
        String datos = "CANCION;Imagine;John Lennon;CIENTO OCHENTA Y TRES;Pop";
        try {
            CancionParser.parse(datos);
            fail("Se esperaba una ParseException al parsear una duración inválida.");
        } catch (ParseException e) {
            assertTrue(true); // Excepción capturada correctamente
        }
    }

    @Test
    public void testEqualsCancion() {
        Cancion cancionIgual = new Cancion("Imagine", "John Lennon", 183, "Pop");
        assertFalse(cancion1.equals(cancion2));
        assertTrue(cancion1.equals(cancionIgual));
    }
    
    @Test
    public void testCompareTo() {
        // Por duración
        assertTrue(cancion1.compareTo(cancion2) < 0); // 183 vs 355
        assertTrue(cancion3.compareTo(cancion2) > 0); // 482 vs 355
        
        // Misma duración (355s), por título
        // "A day in the life" vs "Bohemian Rhapsody"
        assertTrue(cancion5_mismaDuracion.compareTo(cancion2) < 0); 
        assertTrue(cancion2.compareTo(cancion5_mismaDuracion) > 0);

        // Iguales
        Cancion cancionIgual = new Cancion("Imagine", "John Lennon", 183, "Pop");
        assertEquals(0, cancion1.compareTo(cancionIgual));
    }
    
    @Test
    public void testAgregarCancion() {
        ListaDeReproduccion lista = new ListaDeReproduccion("Mis Favoritas", 5);
        assertEquals(0, lista.getNumCanciones());
        
        lista.agregarCancion(cancion1);
        assertEquals(1, lista.getNumCanciones());
        assertEquals(cancion1, lista.getCanciones()[0]);

        lista.agregarCancion(cancion2);
        assertEquals(2, lista.getNumCanciones());
        assertEquals(cancion2, lista.getCanciones()[1]);
    }
    
    @Test
    public void testAgregarCancionListaLlena() {
        ListaDeReproduccion lista = new ListaDeReproduccion("Mi Unica Cancion", 1);
        lista.agregarCancion(cancion1);
        
        // Lista llena, intentar agregar otra canción
        lista.agregarCancion(cancion2);
        
        assertEquals(1, lista.getNumCanciones(), "El número de canciones no debe cambiar si la lista está llena");
        assertEquals(cancion1, lista.getCanciones()[0], "La canción original debe permanecer");
    }

    @Test
    public void testOrdenarCanciones() {
        ListaDeReproduccion lista = new ListaDeReproduccion("Mis Favoritas", 5);
        
        // Añadimos en desorden
        lista.agregarCancion(cancion3); // 482s
        lista.agregarCancion(cancion1); // 183s
        lista.agregarCancion(cancion4); // 390s
        lista.agregarCancion(cancion2); // 355s

        lista.ordenarCanciones();

        Cancion[] cancionesOrdenadas = lista.getCanciones();
        
        assertEquals(4, lista.getNumCanciones());
        assertEquals(cancion1, cancionesOrdenadas[0], "Pos 0: Imagine (183s)");
        assertEquals(cancion2, cancionesOrdenadas[1], "Pos 1: Bohemian Rhapsody (355s)");
        assertEquals(cancion4, cancionesOrdenadas[2], "Pos 2: Hotel California (390s)");
        assertEquals(cancion3, cancionesOrdenadas[3], "Pos 3: Stairway to Heaven (482s)");
    }
    
    @Test
    public void testOrdenarCancionesConMismaDuracion() {
        ListaDeReproduccion lista = new ListaDeReproduccion("Surtido Rock", 5);
        
        // Añadimos canciones con duraciones iguales y diferentes
        lista.agregarCancion(cancion3);                 // 482s, Stairway...
        lista.agregarCancion(cancion5_mismaDuracion);    // 355s, A day in the life
        lista.agregarCancion(cancion2);                 // 355s, Bohemian Rhapsody

        lista.ordenarCanciones();
        
        Cancion[] cancionesOrdenadas = lista.getCanciones();
        
        assertEquals(3, lista.getNumCanciones());
        // Primero las de 355s, ordenadas por título
        assertEquals(cancion5_mismaDuracion, cancionesOrdenadas[0], "Pos 0: A day in the life (355s)");
        assertEquals(cancion2, cancionesOrdenadas[1], "Pos 1: Bohemian Rhapsody (355s)");
        // Luego la más larga
        assertEquals(cancion3, cancionesOrdenadas[2], "Pos 2: Stairway to Heaven (482s)");
    }
}
