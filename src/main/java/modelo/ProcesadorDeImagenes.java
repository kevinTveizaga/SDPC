/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kev
 */
public class ProcesadorDeImagenes {

    private final List<ModeloImagen> imagenes;

    public ProcesadorDeImagenes() {
        imagenes = new ArrayList<>();
    }

    public boolean agregar(ModeloImagen nImagen) {
        return imagenes.add(nImagen);
    }

    public boolean analizar() {
        boolean resultado = false;
        for (ModeloImagen imagen : imagenes) {
            System.out.println(imagen.getRuta());
            resultado = true;
        }
        return resultado;
    }

}
