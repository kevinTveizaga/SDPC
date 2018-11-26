/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ProcesadorDeImagenes;

/**
 *
 * @author Kevo
 */
public class AccionAnalizar implements ActionListener{

    ProcesadorDeImagenes proc;
    
    public AccionAnalizar(ProcesadorDeImagenes procesador) {
        proc = procesador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        proc.analizar();
    }
    
}
