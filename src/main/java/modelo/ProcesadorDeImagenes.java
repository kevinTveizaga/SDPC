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
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

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

    public boolean analizar() {
        boolean resultado = false;
        for (String current : imagenes) {
            IplImage img = cvLoadImage(current);
            IplImage imgThreshold = cvCreateImage(cvGetSize(img), 8,1);
        }
        return resultado;
    }

}
