/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kev
 */
public class ModeloImagen {
    private String ruta;
    
    public ModeloImagen(String ruta){
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }    

    @Override
    public String toString() {
        return ruta;
    }
    
}
