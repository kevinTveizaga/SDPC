/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.CvMemStorage;
import org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_core.cvInRangeS;
import static org.bytedeco.javacpp.opencv_core.cvPoint;
import static org.bytedeco.javacpp.opencv_core.cvScalar;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvConvertImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_BGR2HSV;
import org.bytedeco.javacpp.opencv_imgproc.CvMoments;
import static org.bytedeco.javacpp.opencv_imgproc.cvCircle;
import static org.bytedeco.javacpp.opencv_imgproc.cvGetCentralMoment;
import static org.bytedeco.javacpp.opencv_imgproc.cvGetSpatialMoment;
import static org.bytedeco.javacpp.opencv_imgproc.cvMoments;
/**
 *
 * @author Kev
 */
public class ProcesadorDeImagenes {

    private final List<String> imagenes;
    private CvMoments moments;
    double m10,m01,m_area;
    int posX=0,posY=0;
    
    public ProcesadorDeImagenes() {
        imagenes = new ArrayList<>();
        moments = new CvMoments(Loader.sizeof(CvMoments.class));
    }

    public boolean agregar(String pathImagen) {
        return imagenes.add(pathImagen);
    }

    public IplImage analizar() {
        IplImage img= new IplImage();
        for (String current : imagenes) {
            img = cvLoadImage(current);
            IplImage resultado = cvCreateImage(cvGetSize(img), 8, 1);
            cvConvertImage(img, resultado, COLOR_BGR2HSV);
            cvInRangeS(resultado,cvScalar(102, 0, 255 , 0), cvScalar(255, 255, 0, 0),resultado);        
            cvMoments(resultado, moments,1);
            m10 = cvGetSpatialMoment(moments, 1,0);
            m01 = cvGetSpatialMoment(moments,0,1);
            m_area= cvGetCentralMoment(moments,0,0);
            posX= (int) (m10/m_area);
            posY= (int) (m01/m_area);
            cvCircle(img, cvPoint(posX, posY), 2,cvScalar(0,255,0,0),9,0,0);
                    
        }
        return img;
    }   
}
