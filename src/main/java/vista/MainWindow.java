/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.ProcesadorDeImagenes;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core;

/**
 *
 * @author Kev
 */
public class MainWindow {

    private static final String NOMBRE_APLICACION = "Sistema de deteccion de puntos calientes";
    private static ProcesadorDeImagenes procesador;

    public static void main(String[] args) {     
      
        JFrame frame = new JFrame(NOMBRE_APLICACION);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setMinimumSize(frame.getPreferredSize());
        frame.pack();
        procesador = new ProcesadorDeImagenes();
        initComponents(frame);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void initComponents(JFrame frame) {      
        JPanel main = new JPanel(new GridBagLayout());
        JPanel panelImagen = new JPanel();
        JLabel imagen = new JLabel();
        JPanel panelBotones = new PanelBotones(procesador, imagen);
        panelImagen.add(imagen);
        
        GridBagConstraints limitesBotones = new GridBagConstraints();
        limitesBotones.weightx = 0.5;
        limitesBotones.fill = GridBagConstraints.VERTICAL;
        limitesBotones.gridx = 0;
        limitesBotones.gridy = 0;
        
        GridBagConstraints limitesImagen = new GridBagConstraints();
        limitesImagen.weightx = 0.5;
        limitesImagen.fill = GridBagConstraints.BOTH;
        limitesImagen.gridx = 1;
        limitesImagen.gridy = 0;
        
        main.add(panelBotones, limitesBotones);
        main.add(panelImagen, limitesImagen);
        
        frame.add(main);
    }
}
