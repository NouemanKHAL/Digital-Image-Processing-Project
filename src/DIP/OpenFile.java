/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DIP;

/**
 *
 * @author Ilyas El Bani
 */
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFile {

    JFileChooser fileChooser = new JFileChooser("C:\\Users\\Nihaaw\\Pictures\\Wallpapers");
    public java.io.File file;
    public BufferedImage image;

    public void PickMe() throws Exception {
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            //get The File
            file = fileChooser.getSelectedFile();

            //create a scanner for the file
            image = ImageIO.read(file);

            //read image from file
        } else {
            System.err.println("Impossible");
        }
    }
}
