package Grid;

import java.util.Objects;

/**
 * La classe grid permet de crée un grid sur lequel on aura les navires
 */
public class Grid {

    /**
     * Définition de coordonner X.
     */

    public int x = 16*2;
    /**
     * Définition de coordonner Y.
     */

    public int y = x/2;
    /**
     * Variable pour séparer Grid joueur et Grid ordinateur
     */
    int separateur = x/2 + 1;
    /**
     * Création d'un tableau contenant des String.
     */
    public String [][] grid = new String[x+1][y];

    /**
     * Constructeur de la class Grid.
     * Il permet de créer une Grid joueur/ordinateur
     */
    public Grid() {
        int n = 0;
        //initialize grid
        for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
        {
            // grille USER
            for(int innerLoopValue = 0; innerLoopValue<(x/2);innerLoopValue++)
            {
                grid[innerLoopValue][outerLoopValue]= "|__";
            }
            // Séparation
            for(int innerSepareurValue = x/2; innerSepareurValue < separateur; innerSepareurValue++)
            {

                grid[innerSepareurValue][outerLoopValue]= "|   ";
            }
            // grille CPU
            for(int innerLoopValue = separateur; innerLoopValue<x+1;innerLoopValue++)
            {
                grid[innerLoopValue][outerLoopValue]= "|__";
            }

        }
    }

    /**
     * La méthode AddBoat permet de rajouter des bateaux.
     * On compare la Grid avec la Grid Navire afin d’ajouter les navires aux bons endroits.
     * Pour cela, ont vérifie les casse vide soit (« |__ »), ensuit, on reporte si c’est différent dans Grid.
     * @param Navire Prend une Liste de String
     */
    public void AddBoat(String[][] Navire) {
        int n = 0;
        //initialize grid
        for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
        {
            // grille USER
            for(int innerLoopValue = 0; innerLoopValue<(x/2);innerLoopValue++)
            {
                    /* if navire[x][y]== |## -> grid[x][y] = |##
                        Implémente le bateau dans la grille
                    */
                if (!Objects.equals(Navire[innerLoopValue][outerLoopValue], "|__")){
                    if(Navire[innerLoopValue][outerLoopValue] != null)
                    {
                        grid[innerLoopValue][outerLoopValue] = Navire[innerLoopValue][outerLoopValue];
                    }
                }
            }
        }
    }

    /**
     * La méthode AddTireImpactOnMonitor permet d'ajouter les tires sur la Grid.
     * Selon le type de dégâts/ le type de navire, on a un choix d’affichage.
     * Si un navire est touché alors il y aura « |TT » en rouge
     * Sinon il y aura « |XX » en bleu.
     * Pour le Cuirasse, les premiers dégâts seront en Verte puis en rouge.
     * @param x La coordonnée du navire en X
     * @param type Le type de navire
     * @param y La coordonnée du navire en Y
     */

    public void AddTireImpactOnMonitor(int x, int y, int type) {
        if(type == 1){
            grid[x+separateur][y]= "\033[31m|TT\033[0m";
        } else if (type == 0){
            grid[x+separateur][y]= "\033[34m|XX\033[0m";
        } else {
            grid[x+separateur][y]= "\033[32m|U1\033[0m";
        }

    }
    /**
     * La méthode AddTireImpactOnPlayerGrid permet d'ajouter les tires sur la Grid.
     * Selon le type de dégâts/ le type de navire, on a un choix d’affichage.
     * Si un navire est touché alors il y aura « |TT » en rouge
     * Sinon il y aura « |XX » en bleu.
     * Pour le Cuirasse, les premiers dégâts seront en Verte puis en rouge.
     * @param x La coordonnée du navire en X
     * @param type Le type de navire
     * @param y La coordonnée du navire en Y
     */

    public void AddTireImpactOnPlayerGrid(int x, int y, int type) {
        if(type == 1){
            grid[x][y]= "\033[31m"+grid[x][y]+"\033[0m";
        } else if (type == 0){
            grid[x][y]= "\033[34m|XX\033[0m";
        } else {
            grid[x][y]= "\033[32m|U1\033[0m";
        }

    }

    /**
     *La méthode getGrid.
     *Permet de récupérer la Grid.
     * @return grid
     */

    public String[][] getGrid() {
        return grid;
    }

    /**
     * La méthode getX.
     * Permet de récupérer la cordonne X de la Grid.
     * @return X
     */
    public int getX() {
        return x;
    }
    /**
     * La méthode getY.
     * Permet de récupérer la cordonne Y de la Grid.
     * @return Y
     */

    public int getY() {
        return y;
    }
}
