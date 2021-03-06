package DIP;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;

public class EnhanceSharpeness {

    public static BufferedImage getSharpened(String filePath) {
        Mat destination = null;
        try {
            Mat source = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_COLOR);
            destination = new Mat(source.rows(), source.cols(), source.type());

            Imgproc.GaussianBlur(source, destination, new Size(0, 0), 10);
            Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);

            return MatConvToBuff.Mat2BufferedImage(destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
