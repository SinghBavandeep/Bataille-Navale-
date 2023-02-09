import Affichages.MenuGame;
import Affichages.ResetConsole;
import Navires.Navire;

import java.util.Random;

/**
 * Création de la classe Game.
 */
public class Game {
    /**
     * Création d'un instance d'objet de type Player.
     */
    Player player,CPU;
    /**
     * Création d'un instance d'objet de type MenuGame.
     */
    MenuGame menugame;

    /**
     * Création de variable cheat et nuke de type boolean .
     */
    boolean cheat,nuke;

    /**
     * Création d'un constructeur par default.
     * Initialisation des variables player, CPU et menugame.
     */
    Game()  {
        //nouvelle classe starting game pour rendre le constructeur game utilisable dans un chargement de partie
        player = new Player();
        CPU = new Player();
        menugame = new MenuGame();
        cheat = false;
    }

    /**
     * La méthode Starting_GAME permet de lancer le jeu en créant les navires.
     * @param ChoixUser true si joueur
     * @throws Exception Exception
     */
    public void Starting_GAME (boolean ChoixUser) throws Exception {
        while (ChoixUser) {
            player.navires.SpawnBoat(true);
            CPU.navires.SpawnBoat(false);
            ChoixUser = false;
        }
    }

    /**
     * La méthode IN_GAME permet de vérifier la vie des navires.
     *
     * @param ChoixUser utilisateur
     * @return True si victoire
     */
    public boolean IN_GAME(boolean ChoixUser){
        while(ChoixUser){
            // Move or Shoot according to the player's choice
            controllerChoice();
            GameplayCPU();
            player.navires.checkAllboatLife(true);
            CPU.navires.checkAllboatLife(false);
            if (win()){
                return true;
            }else if(lose()){
                return false;
            }
        }
        return false;
    }

    /**
     * La méthode charToInt permet de convertir un caractère en entier.
     * @param input Caractère
     * @return Entier
     */

    private int charToInt(char input){
        int n = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (c==input){
                //System.out.println(input+" = "+n);
                return n;
            }
            n++;
        }
        return 0;
    }

    /**
     * La méthode clearConsole permet de supprimer l'historique du console.
     */
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    /**
     * La méthode Tire permet de lancer les méthodes pour réaliser une tire.
     * @param bato Navire
     */

    private void Tire(Navire bato){
        Object[] coord = menugame.CoordonatesShoots();
        /*
         * charToInt(coord[1].toString().charAt(0))
         *   --> Convert Object containing a char to char
         *       --> then convert that char to its int equivalent
         */
        ResetConsole.FullClear();
        int x = (int)coord[0];
        int y = charToInt(coord[1].toString().charAt(0));
        bato.CheckImpact(x,y,true);
        player.navires.PrintGrid(true);
        if (cheat) {
            CPU.navires.PrintGrid(false);
        }
    }
    /**
     * La méthode Move permet de lancer les méthodes pour réaliser un déplacement .
     * @param bato Navire
     */

    private void Move(Navire bato){
        boolean direction;
        direction = menugame.WichDirection(bato.getOrientation());
        if (!bato.Deplacement(direction)){
            //afficher message d'erreur déplacement impossible
            menugame.printMoveError();
        }
        ResetConsole.FullClear();
        player.navires.PrintGrid(true);
        if (cheat) {
            CPU.navires.PrintGrid(false);
        }
    }

    /**
     * La méthode controllerChoice permet de lancer les méthodes de choix (menu).
     */

    private void controllerChoice(){
        boolean direction;
        int[] playerschoice = menugame.SelectBoat();
        switch(playerschoice[0]){
            case 1 :
                switch(playerschoice[1]){
                    case 1 :
                        if (menugame.ShootOrMove()){
                            //option 1
                            Move(player.navires.Sous_Marin);
                        }else{
                            //tire
                            Tire(player.navires.Sous_Marin);
                        }
                        break;
                    case 2 :
                        if (menugame.ShootOrMove()){
                            Move(player.navires.Sous_Marin1);
                        }else {
                            //tire
                            Tire(player.navires.Sous_Marin1);
                        }
                        break;
                    case 3:
                        if (menugame.ShootOrMove()){
                            Move(player.navires.Sous_Marin2);
                        }else{
                            //tire
                            Tire(player.navires.Sous_Marin2);
                        }
                        break;
                    case 4:
                        if (menugame.ShootOrMove()){
                            Move(player.navires.Sous_Marin3);
                        }else{
                            //tire
                            Tire(player.navires.Sous_Marin3);
                        }
                        break;
                }
                break;
            case 2:
                switch(playerschoice[1]){
                    case 1 :
                        if (menugame.ShootOrMove()){
                            Move(player.navires.destroyer);
                        }else{
                            //tire
                            Tire(player.navires.destroyer);
                        }
                        break;
                    case 2 :
                        if (menugame.ShootOrMove()){
                            Move(player.navires.destroyer1);
                        }else {
                            //tire
                            Tire(player.navires.destroyer1);
                        }
                        break;
                    case 3:
                        if (menugame.ShootOrMove()){
                            Move(player.navires.destroyer2);
                        }else{
                            //tire
                            Tire(player.navires.destroyer2);
                        }
                        break;
                }
                break;
            case 3:
                switch(playerschoice[1]) {
                    case 1:
                        if (menugame.ShootOrMove()) {
                            Move(player.navires.croiseur);
                        } else {
                            //tire
                            Tire(player.navires.croiseur);
                        }
                        break;
                    case 2:
                        if (menugame.ShootOrMove()) {
                            Move(player.navires.croiseur1);
                        } else {
                            //tire
                            Tire(player.navires.croiseur1);
                        }
                        break;
                }
                break;
            case 4:
                if (menugame.ShootOrMove()) {
                    Move(player.navires.cuirasse);
                } else {
                    //tire
                    Tire(player.navires.cuirasse);
                }
                break;
            case 123:
                cheat = !cheat;
                break;
            case 666:
                player.navires.nuke();
                ResetConsole.FullClear();
                player.navires.PrintGrid(true);
                break;
        }
    }

    /**
     * La méthode GameplayCPU permet de lancer les attaques et le déplacement.
     */

    private void GameplayCPU(){ //commande de jeu CPU (full aléatoire)
        Random random = new Random();
        int x = random.nextInt(16);//génération des coordonées aléatoires de tire
        int y = random.nextInt(16);
        int numboat = random.nextInt(4); //génère un nombre en 0 et 3 pour le type du bateau
        int selectBoat;
        boolean ShotOrMove = random.nextBoolean();
        boolean direction = random.nextBoolean();

        switch (numboat) { //Selection du type de bateau
            case 0 -> {
                selectBoat = random.nextInt(4); //génère en 0 et 3 pour choisir le sous-marin
                switch (selectBoat) {
                    case 0 -> subShootOrMoveCPU(CPU.navires.Sous_Marin, ShotOrMove, x, y, direction);
                    case 1 -> subShootOrMoveCPU(CPU.navires.Sous_Marin1, ShotOrMove, x, y, direction);
                    case 2 -> subShootOrMoveCPU(CPU.navires.Sous_Marin2, ShotOrMove, x, y, direction);
                    case 3 -> subShootOrMoveCPU(CPU.navires.Sous_Marin3, ShotOrMove, x, y, direction);
                }
            }
            case 1 -> {
                selectBoat = random.nextInt(3); //génère en 0 et 2 pour choisir le destroyer
                switch (selectBoat) {
                    case 0 -> subShootOrMoveCPU(CPU.navires.destroyer, ShotOrMove, x, y, direction);
                    case 1 -> subShootOrMoveCPU(CPU.navires.destroyer1, ShotOrMove, x, y, direction);
                    case 2 -> subShootOrMoveCPU(CPU.navires.destroyer2, ShotOrMove, x, y, direction);
                }
            }
            case 2 -> {
                selectBoat = random.nextInt(2); //génère en 0 et 1 pour choisir le croiseur
                switch (selectBoat) {
                    case 0 -> subShootOrMoveCPU(CPU.navires.croiseur, ShotOrMove, x, y, direction);
                    case 1 -> subShootOrMoveCPU(CPU.navires.croiseur1, ShotOrMove, x, y, direction);
                }
            }
            case 3 -> subShootOrMoveCPU(CPU.navires.cuirasse, ShotOrMove, x, y, direction);
        }
    }

    /**
     * La méthode subShootOrMove permet de choisir si on les navires doivent tirer ou se déplacer de l'ordinateur.
     * @param bato Type navire
     * @param ShotOrMove Type boolean
     * @param x Coordonnée en X
     * @param y Coordonnée en Y
     * @param direction Type boolean
     */
    private void subShootOrMoveCPU(Navire bato, Boolean ShotOrMove, int x, int y, boolean direction){
        if(ShotOrMove) // une chance sur deux de tirer
        {
            bato.CheckImpact(x,y,false);
        }else{
            bato.Deplacement(direction);
        }
    }

    /**
     * La méthode win permet en cas de victoir
     * @return True si tous les navires de l'ordinateur sont détruis. Sinon false
     */

    private boolean win(){
        return CPU.navires.IsAllBoatDead();
    }
    /**
     * La méthode lose permet en cas de victoir
     * @return True si tous les navires du joueur sont détruis. Sinon false
     */

    private boolean lose(){
        return player.navires.IsAllBoatDead();
    }

}
