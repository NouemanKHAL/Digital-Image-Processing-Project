package DIP;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class N_NiveauDeGris {

    public static BufferedImage getNNiveau(BufferedImage image, int nbr) {

        int longueur = image.getHeight();
        int largeur = image.getWidth();
        int valeur[] = new int[256];

        // obtention de l'image en niveau de gris
        image = GreyScale.getGreyScale(image);

        // Reduction de la quantification
        int pas = 256 / nbr;

        // Affectation des valeurs pas, 2*pas, 3*pas...n*pas
        for (int i = 0; i <= 255; ++i) {
            valeur[i] = (i / pas)  * pas;
        }

        // parcours de l'image
        for (int i = 0; i < largeur; ++i) {
            for (int j = 0; j < longueur; ++j) {

                // obtention de la couleur du pixel 
                Color c = new Color(image.getRGB(i, j));

                int red = (int) (c.getRed());
                int newVal = valeur[red];

                Color newColor = new Color(newVal, newVal, newVal);

                image.setRGB(i, j, newColor.getRGB());
            }
        }

        return image;
    }

}
