package Navires;

/**
 * La classe sous_marin hérite de navire
 */
public class Sous_Marin extends Navire
{
    /**
     * Constructeur par default
     */

    private Sous_Marin(){
        x = 0;
        y = 0;
        pTire=1;
        taille = 1;
        boatHp = taille;
        orientation = " ";
        pattern = "|S";
    }

    /**
     * Constructeur
     * @param x La coordonnée du navire en X
     * @param y La coordonnée du navire en Y
     * @param orientation L'orientation du navire en Y
     * @param user Si user ou ordinateur
     * @param shipnumb (a changer)
     */

    public Sous_Marin(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 1;
        boatHp =taille;
        //By default, pTire = 1
        pTire=1;
        pattern = "|S"+shipnumb;
        if(user){
            super.positionnement(true);
        }else {
            super.positionnementCPU(true);
        }
    }

    /**
     * La La méthode GetNum_Sous_Marin permet de récupérer le numéro du sous-marin.
     * @return entier
     */
    public int GetNum_Sous_Marin(){
        return shipnumb;
    }
    /*

    @Override
    public void Tir(int x, int y) {

    }*/
}
