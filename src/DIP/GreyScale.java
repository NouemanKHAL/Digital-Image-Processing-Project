package DIP;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class GreyScale {

    public static BufferedImage getGreyScale(BufferedImage image) {

        // initialisation des variables
        int longueur = image.getHeight();
        int largeur = image.getWidth();

        // parcours de l'image
        for (int i = 0; i < largeur; ++i) {
            for (int j = 0; j < longueur; ++j) {

                // obtention du couleur du pixel (i, j)
                Color c = new Color(image.getRGB(i, j));

                // formule RVB ==> Niveau de gris
                int red = (int) (c.getRed() * 0.3);
                int green = (int) (c.getGreen() * 0.6);
                int blue = (int) (c.getBlue() * 0.1);

                int sum = red + green + blue;

                // couleur en niveau de gris
                Color newColor = new Color(sum, sum, sum);

                // affectation de la nouvelle couleur au pixel
                image.setRGB(i, j, newColor.getRGB());
            }
        }

        return image;
    }

}
