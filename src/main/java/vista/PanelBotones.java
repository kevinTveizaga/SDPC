/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.AccionAgregar;
import controlador.AccionAnalizar;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import modelo.ProcesadorDeImagenes;

/**
 *
 * @author Kev
 */
public class PanelBotones extends JPanel {

    public PanelBotones(ProcesadorDeImagenes procesador, JLabel imagen) {       
        JButton botonAbrir = new JButton("agregar");
        botonAbrir.setToolTipText("agregar imagenes");
        botonAbrir.addActionListener(new AccionAgregar(procesador, imagen));
        JButton botonAnalizar = new JButton("analizar");
        botonAnalizar.setToolTipText("analizar imagenes");
        botonAnalizar.addActionListener(new AccionAnalizar(procesador));
        
        super.add(botonAbrir);
        super.add(botonAnalizar);
    }

}
