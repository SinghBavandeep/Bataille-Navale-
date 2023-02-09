package Navires;

/**
 * La classe destroyer hérite de navire
 */
public class Destroyer extends Navire
{
    /**
     * Constructeur par default
     */
    private Destroyer(){
        x = 0;
        y = 0;
        pTire=1;
        taille = 3;
        boatHp =taille;
        orientation = " ";
        pattern = "|D";
    }
    /**
     * Constructeur
     * @param x La coordonnée du navire en X
     * @param y La coordonnée du navire en Y
     * @param orientation L'orientation du navire en Y
     * @param user Si user ou ordinateur
     * @param shipnumb (a changer)
     */
    public Destroyer(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 3;
        boatHp =taille;
        pTire=1;
        pattern = "|D"+shipnumb;
        if(user){
            super.positionnement(true);
        }else {
            super.positionnementCPU(true);
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }*/
}
