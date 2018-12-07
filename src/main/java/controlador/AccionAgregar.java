/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.ProcesadorDeImagenes;

/**
 *
 * @author Kev
 */
public class AccionAgregar implements ActionListener {

    private final JFileChooser fileChooser;
    private final ProcesadorDeImagenes proc;
    private final JLabel imagen;

    public AccionAgregar(ProcesadorDeImagenes procesador, JLabel imagen) {
        fileChooser = new JFileChooser();
        proc = procesador;
        this.imagen = imagen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("imagenes JPG & JPEG", "jpg", "jpeg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(fileChooser);

        if (result != JFileChooser.CANCEL_OPTION) {
            File fileChosen = fileChooser.getSelectedFile();
            if ((fileChosen == null) || (fileChosen.getName().equals("")) || (!fileChosen.isFile())) {
                System.out.println("Archivo incorrecto");
            } else {
                ImageIcon icono = new ImageIcon(fileChosen.getAbsolutePath());
                imagen.setIcon(icono);
                proc.agregar(fileChosen.getAbsolutePath());
            }
        }
    }
}
