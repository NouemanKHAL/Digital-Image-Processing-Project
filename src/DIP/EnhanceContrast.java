package DIP;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;

public class EnhanceContrast {

    public static BufferedImage getContrasted(String filePath) {
        Mat destination = null;
        try {
            Mat source = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_GRAYSCALE);
            destination = new Mat(source.rows(), source.cols(), source.type());

            Imgproc.equalizeHist(source, destination);

            return MatConvToBuff.Mat2BufferedImage(destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
