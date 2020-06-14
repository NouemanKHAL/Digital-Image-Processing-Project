package DIP;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Flip {

    public static BufferedImage getFlipped(BufferedImage image) {

        // initialisation des variables
        int longueur = image.getHeight();
        int largeur = image.getWidth();

        // parcours de l'image
        for (int i = 0; i < largeur; ++i) {
            for (int j = 0; j < longueur - j - 1; ++j) {

                // obtention du couleur du pixel (i, j)
                Color c = new Color(image.getRGB(i, j));
                
                int symX = largeur - i - 1;
                int symY = longueur - j - 1;
                
                Color sym = new Color(image.getRGB(symX, symY));

                // affectation de la nouvelle couleur au pixel
                image.setRGB(i, j, sym.getRGB());
                image.setRGB(symX, symY, c.getRGB());
            }
        }

        return image;
    }

}
