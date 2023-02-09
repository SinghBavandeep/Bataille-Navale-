package Navires;


import Affichages.Affichage;
import Grid.Grid;

/**
 * Interface Navire
 */

public interface I_Navire {
    /**
     * Instance d'objet de la classe Grid.
     * Création d'une Grid joueur.
     */

    Grid Plateau = new Grid();
    /**
     * Instance d'objet de la classe Grid.
     * Création d'une Grid ordinateur.
     */
    Grid PlateauCPU = new Grid();

    /**
     * Méthode positionnement joueur
     * @param orientation orientation du navire
     * @param y La coordonnée du navire en Y
     * @param x La coordonnée du navire en X
     * @param taille Taille du navire
     * @param pattern Le patterne du navire
     * @param init init
     * @return  true
     */
    boolean positionnement(String orientation, int y, int x, int taille,String pattern, boolean init);

    /**
     *Méthode positionnement ordinateur
     * @param orientation orientation du navire
     * @param y La coordonnée du navire en Y
     * @param x La coordonnée du navire en X
     * @param taille Taille du navire
     * @param pattern Le patterne du navire
     * @param init init
     * @return  true
     */
    boolean positionnementCPU(String orientation, int y, int x, int taille, String pattern, boolean init);

}
