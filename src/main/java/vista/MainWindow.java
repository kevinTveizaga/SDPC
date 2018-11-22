/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        JPanel main = new JPanel(new GridLayout());
        main.setAutoscrolls(true);
        main.setBackground(Color.red);

        GridBagConstraints limitesBotones = new GridBagConstraints();
        limitesBotones.gridx = 0;
        limitesBotones.gridy = 1;
        limitesBotones.gridheight = 100;
        limitesBotones.gridwidth = 200;
        limitesBotones.fill = GridBagConstraints.BOTH;

        GridBagConstraints limitesImagen = new GridBagConstraints();
        limitesImagen.gridx = 1;
        limitesImagen.gridy = 0;
        limitesImagen.gridheight = 400;
        limitesImagen.gridwidth = 400;
        limitesImagen.fill = GridBagConstraints.BOTH;

        JPanel panelImagen = new JPanel();
        JLabel imagen = new JLabel();
        JPanel botones = new PanelBotones(procesador, imagen);

        panelImagen.add(imagen);

        main.add(botones, limitesBotones);
        main.add(panelImagen, limitesImagen);

        frame.add(main);
    }
}
