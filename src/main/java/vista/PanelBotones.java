/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.event.ListDataListener;
import modelo.ProcesadorDeImagenes;

/**
 *
 * @author Kev
 */
public class PanelBotones extends JPanel{
    
    private static final int PREF_H = 300;
    private static final int PREF_W = 300;
    
    public PanelBotones(ProcesadorDeImagenes procesador) {
        super.setLayout(new SpringLayout());
        super.setSize(new Dimension(PREF_W, PREF_H));
        
        JList imagenes = new JList();
        
        
        JButton botonAbrir = new JButton("agregar");
        botonAbrir.setToolTipText("agregar imagenes");
        botonAbrir.addActionListener(new AccionAgregar(procesador));
        
        super.add(botonAbrir);
    }    
    
}
