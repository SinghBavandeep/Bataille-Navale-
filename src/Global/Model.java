package Global;

import Affichages.Affichage;
import Grid.Grid;

/**
 * Interface model
 */
public interface Model {
    /**
     * Création d’instance d’objet de la classe Grid
     * On  utilise cette Grid général pour l’affichage des bateaux et des tire du joueur.
     */

    Grid Grid = new Grid();
    /**
     * Création d’instance d’objet de la classe Grid
     * On  utilise cette Grid général pour l’affichage des bateaux et des tire de l'ordinateur .
     */
    Grid GridCPU = new Grid();

    /**
     * Création d’instance d’objet de la classe Affichage
     */
    Affichage Screen = new Affichage();
}
