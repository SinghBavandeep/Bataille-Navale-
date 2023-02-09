import Affichages.Defeat;
import Affichages.Menu;
import Affichages.Victory;

import javax.management.DescriptorAccess;
import java.io.IOException;

/**
 * Main
 */
public class Main {
    /**
     * Main
     * @param args arguemnt
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        Game Game = new Game();
        Menu menu = new Menu();
        Victory victory = new Victory();
        Defeat defeat = new Defeat();
        if(menu.print()){
            Game.Starting_GAME(true);
            if(Game.IN_GAME(true)){
                victory.print();
            } else{
                defeat.print();
            }
        }
    }
}