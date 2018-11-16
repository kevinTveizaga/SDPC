/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import modelo.ProcesadorDeImagenes;

/**
 *
 * @author Kev
 */
public class MainWindow {
    
    private static final String NOMBRE_APLICACION = "Sistema de deteccion de puntos calientes";
    private static ProcesadorDeImagenes procesador;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame(NOMBRE_APLICACION);
        frame.setSize(500, 500);
        procesador = new ProcesadorDeImagenes();
        initComponents(frame);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void initComponents(JFrame frame) {
        JLayeredPane mainPanel = new JLayeredPane();
        mainPanel.setBounds(0,0,500,500);
        JPanel botonesPanel = new PanelBotones(procesador);
        mainPanel.add(botonesPanel, 1, 1);
        frame.add(mainPanel);        
    }
}
