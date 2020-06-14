package DIP;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.*;

public class EnhanceBrightness {

    public static BufferedImage getBrighter(String filePath, double alpha, double beta) {
        Mat destination = null;
        try {
            Mat source = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_COLOR);
            destination = new Mat(source.rows(), source.cols(), source.type());
            
            // newValue = alpha * x + beta
            source.convertTo(destination, -1, alpha, beta);
            
           

            return MatConvToBuff.Mat2BufferedImage(destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
