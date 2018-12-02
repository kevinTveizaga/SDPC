/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_core.cvInRangeS;
import static org.bytedeco.javacpp.opencv_core.cvScalar;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvConvertImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_BGR2HSV;
/**
 *
 * @author Kev
 */
public class ProcesadorDeImagenes {

    private final List<String> imagenes;

    public ProcesadorDeImagenes() {
        imagenes = new ArrayList<>();
    }

    public boolean agregar(String pathImagen) {
        return imagenes.add(pathImagen);
    }

    public IplImage analizar() {
        IplImage resultado = new IplImage();
        for (String current : imagenes) {
            IplImage img = cvLoadImage(current);
            IplImage imgResult = cvCreateImage(cvGetSize(img), 8, 1);
            resultado = cvCreateImage(cvGetSize(img), 8, 1);
            cvConvertImage(img, resultado, COLOR_BGR2HSV);
            cvInRangeS(resultado, cvScalar(253,188,7,0),cvScalar(255,247,0,0),resultado);        
        }
        return resultado;
    }   
}
