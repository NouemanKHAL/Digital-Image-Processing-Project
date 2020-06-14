package DIP;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;

public class GaussianFilter {

    public static BufferedImage gaussianBlur(String filePath, int r) {
        Mat destination = null;
        try {
            Mat source = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_COLOR);
            destination = new Mat(source.rows(), source.cols(), source.type());

            Imgproc.GaussianBlur(source, destination, new Size(r, r), 0);

            return MatConvToBuff.Mat2BufferedImage(destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
