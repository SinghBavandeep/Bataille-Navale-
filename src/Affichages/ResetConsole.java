package Affichages;
import java.io.IOException;

//Méthode modifié du ProcessBuilder :
//@https://stackoverflow.com/questions/10241217/how-to-clear-console-in-java


/**
 * Création de la classe ResetConsole.
 */
public class ResetConsole {
    /**
     * Permet de reset, pour cela on suprimme l'historique du console
     */
    static public void FullClear()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
