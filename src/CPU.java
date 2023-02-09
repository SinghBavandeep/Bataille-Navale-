import java.util.ArrayList;

import java.util.Random;

/**
 * La classe CPU permet de rendre
 */
public class CPU {

    /**
     * Constructeur par défaut
     */
    public CPU(){

    }

    /**
     * Cette méthode permet de générer une liste de cordonnées sans doublon.
     * @return randomValues
     */

    //http://www.fobec.com/java/952/generer-une-suite-aleatoire-chiffre-sans-doublon.html#:~:text=Avec%20la%20fonction%20Random%2C%20les,nombres%20contenus%20dans%20le%20tableau.
    public static int[] CordCPU() {
        ArrayList<Integer> intListx = new ArrayList<Integer>();

        for (int i = 1; i <= 16; i++) {
            intListx.add(i);

        }

        int[] randomValues = new int[intListx.size()];
        Random random = new Random();
        int posx = 0;


        while (intListx.size() > 0) {
            posx = random.nextInt(intListx.size());
            randomValues[intListx.size() - 1] = intListx.get(posx);
            intListx.remove(posx);
        }

        return randomValues;
    }
    private void CheakDamage(){
        // verifie les points de vie des bateau est il vas tirer dans cette zone


    }

}
