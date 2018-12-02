/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelo.ProcesadorDeImagenes;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Frame;

import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

/**
 *
 * @author Kevo
 */
public class AccionAnalizar implements ActionListener {

    ProcesadorDeImagenes proc;
    JLabel img;
    
    public AccionAnalizar(ProcesadorDeImagenes procesador, JLabel imagen) {
        proc = procesador;
        img = imagen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IplImage imagen = proc.analizar();
        ImageIcon imageIcon = new ImageIcon(IplImageToBufferedImage(imagen));
        img.setIcon(imageIcon);
    }

    public static BufferedImage IplImageToBufferedImage(IplImage src) {
        OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
        Frame frame = grabberConverter.convert(src);
        return paintConverter.getBufferedImage(frame,1);
    }
    
}
