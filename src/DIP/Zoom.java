package DIP;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;

public class Zoom {

    public static BufferedImage getZoomed(String filePath, double x) {
        Mat destination = null;
        try {
            Mat source = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_COLOR);
            destination = new Mat();

            Imgproc.resize(source, destination, destination.size(), x, x, Imgproc.INTER_NEAREST);

            return MatConvToBuff.Mat2BufferedImage(destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
