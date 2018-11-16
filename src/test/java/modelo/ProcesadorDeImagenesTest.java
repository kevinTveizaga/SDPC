/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Kev
 */
public class ProcesadorDeImagenesTest {
    
    private ModeloImagen pImagen;
    private ModeloImagen sImagen;
    private ModeloImagen tImagen;
    private ModeloImagen cImagen;
    private ProcesadorDeImagenes procesador;
    
    @Before
    public void setUp() {
        pImagen = new ModeloImagen("1");
        sImagen = new ModeloImagen("2");
        tImagen = new ModeloImagen("3");
        cImagen = new ModeloImagen("4");
        procesador = new ProcesadorDeImagenes();
    }

    /**
     * Test of agregar method, of class ProcesadorDeImagenes.
     */
    @org.junit.Test
    public void testAgregar() {
        boolean result = procesador.agregar(pImagen);
        assertTrue(result);
    }

    /**
     * Test of analizar method, of class ProcesadorDeImagenes.
     */
    @org.junit.Test
    public void testAnalizar() {
        procesador.agregar(pImagen);
        procesador.agregar(sImagen);
        procesador.agregar(tImagen);
        procesador.agregar(cImagen);
        assertTrue(procesador.analizar());
    }
    
}
