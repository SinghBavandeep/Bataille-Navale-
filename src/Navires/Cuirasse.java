package Navires;

/**
 * La classe Cuirasse hérite de navire
 */
public class Cuirasse extends Navire
{
    /**
     * Constructeur par default
     */
    public Cuirasse(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 7;
        boatHp = taille;
        pTire=9;
        pattern = "|U";
    }
    /**
     * Constructeur
     * @param x La coordonnée du navire en X
     * @param y La coordonnée du navire en Y
     * @param orientation L'orientation du navire en Y
     * @param user Si user ou ordinateur
     * @param shipnumb (a changer)
     */

    public Cuirasse(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 7;
        boatHp = taille;
        pTire=9;
        pattern = "|U"+shipnumb;
        if (user) {
            super.positionnement(true);
        }
        else {
            super.positionnementCPU(true);
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }
*/
}
