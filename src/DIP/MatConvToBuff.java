package DIP;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.*;

public class MatConvToBuff {

    public static BufferedImage Mat2BufferedImage(Mat matrice) throws IOException {
        MatOfByte MOB = new MatOfByte();
        Imgcodecs.imencode(".jpg", matrice, MOB);
        byte byteArray[] = MOB.toArray();
        BufferedImage res = ImageIO.read(new ByteArrayInputStream(byteArray));
        return res;
    }

        /* Or 
    public static BufferedImage Mat2BufferedImage(Mat m)
    {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (m.channels() > 1)
        {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte[] b = new byte[bufferSize];
        m.get(0, 0, b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);  
        return image;
    }
    */
}
