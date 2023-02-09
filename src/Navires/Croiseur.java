package Navires;

/**
 * La classe croisseur hérite de la navire.
 */
public class Croiseur extends Navire
{
    /**
     * Constructeur par default
     */
    private Croiseur(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 5;
        boatHp = taille;
        pTire=4;
        pattern = "|C";
    }

    /**
     * Constructeur
     * @param x La coordonnée du navire en X
     * @param y La coordonnée du navire en Y
     * @param orientation L'orientation du navire en Y
     * @param user Si user ou ordinateur
     * @param shipnumb (a changer)
     */

    public Croiseur(int x, int y, String orientation, boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 5;
        boatHp = taille;
        pTire=4;
        pattern = "|C"+shipnumb;
        if(user){
            positionnement(true);
        }else {
            positionnementCPU(true);
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }

 */
}
