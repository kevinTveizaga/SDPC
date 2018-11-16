/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.ModeloImagen;
import modelo.ProcesadorDeImagenes;

/**
 *
 * @author Kev
 */
public class AccionAgregar implements ActionListener{
    
    private final JFileChooser fileChooser;
    private ModeloImagen imagen;
    private final ProcesadorDeImagenes proc;
    
    public AccionAgregar(ProcesadorDeImagenes procesador) {
        fileChooser = new JFileChooser();
        proc = procesador;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("imagenes JPG & JPEG", "jpg", "jpeg");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(fileChooser);
        
        if (result != JFileChooser.CANCEL_OPTION) {
            File fileName = fileChooser.getSelectedFile();
            if((fileName == null) || (fileName.getName().equals("")) || (!fileName.isFile())) {
                System.out.println("Archivo incorrecto");
            } else {
                imagen = new ModeloImagen(fileName.getPath());
                proc.agregar(imagen);
            }
            
        }
    }
}
