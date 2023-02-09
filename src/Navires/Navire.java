package Navires;

import Global.Model;


import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Création de la classe Navire qui hérite de Model
 */
public class Navire implements Model {

    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux

    /**
     * Récupère la valeur de XMax dans Grid.
     */
    int xMax = Grid.getX()/2;
    /**
     * Récupère la valeur de Ymax dans Grid.
     */
    int yMax = Grid.getY();
    /**
     * Création de variable x,y,tempx,tempy,taille,pTire, boatHp et shipnumb de type entier.
     */
    int x,y,tempx,tempy,taille,pTire, boatHp,shipnumb;
    /**
     * Création de variable direction et IsDMG de type boolean.
     */
    boolean direction, IsDMG, IsDead;
    /**
     * Création de la variable orientation de type chaine de caractaire.
     */
    public String orientation;
    /**
     * Création de la variable pattern de type chaine de caractaire.
     */
    String pattern;
    /**
     * Création de tableau bateau et tireB de type chaine de caractaire.
     */
    String[][] bateau,tireB;
    /**
     * Création d'un instance d'objet de type Cuirasse.
     */
    public Cuirasse cuirasse;
    /**
     * Création d'un instance d'objet de type Croiseur.
     */
    public Croiseur croiseur,croiseur1;
    /**
     * Création d'un instance d'objet de type Destroyer.
     */
    public Destroyer destroyer,destroyer1,destroyer2;
    /**
     * Création d'un instance d'objet de type Sous_Marin.
     */
    public Sous_Marin Sous_Marin,Sous_Marin1,Sous_Marin2,Sous_Marin3;

    /**
     * Constructeur par default.
     * Initialisation des variable x,y,shipnumb,direction,orientation,pattern,bateau,tireB et IsDMG
     */

    public Navire(){
        x = 0;
        y = 0;
        shipnumb = 0;
        direction = false;
        orientation = "";
        pattern = "";
        bateau = new String[Grid.x/2][Grid.y];
        tireB = new String[Grid.x/2][Grid.y];
        IsDMG = false;
    }

    /**
     * Move the boat to the given coordonates
     * @param direction need the direction of the boat
     * @return false si navire et toucher
     */
    public boolean Deplacement(boolean direction){
        if (!IsDMG) {
            this.direction = direction;
            tempx = x;
            tempy = y;
            IncrementCoord();
            return AddMoveToGrid();
        }else {
            return false;
        }
    }

    /**
     * Try to execute move and register
     * @return boolean reprensenting the possibility of the move
     */
    private boolean AddMoveToGrid(){
        if (Objects.equals(orientation, "vertical")) {
            if (y >= 0 & (y+taille) <= yMax){
                if (!positionnement(false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            if (x >= 0 & (x+taille) <= xMax){
                if (!positionnement(false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Méthode positionnement pour joueur permet de positionner les bateaux selon leur orientation dans la Grid
     * @param init (Déplacement ??)
     * @return true si on a effacé les bateaux sinon false
     */
    public boolean positionnement(boolean init) {

        if (CheckSpace(orientation,y,x,taille)) {
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y; i < (y + taille); i++) {
                    bateau[x][i] = pattern;

                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            Grid.AddBoat(bateau);
            if (!init){
                clearBoat();
            }
            clearBateau();
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            x = coord[0];
            y = coord[1];
            positionnement(true);
        }
        return false;
    }

    /**
     * Méthode positionnement pour ordinateur permet de positionner les bateaux selon leur orientation dans la Grid
     * @param init (Déplacement ??)
     * @return true si on a effacé les bateaux sinon false
     */
    public boolean positionnementCPU(boolean init) {
        if (CheckSpaceCPU(orientation,y,x,taille)) {
            //bateau[x][y] = "|0" + shipnumb;
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y; i < (y + taille); i++) {
                    bateau[x][i] = pattern;
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            GridCPU.AddBoat(bateau);
            if (!init){
                clearBoat();
            }
            clearBateau();
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            x = coord[0];
            y = coord[1];
            positionnementCPU(true);
        }
        return false;
    }

    /**
     * La méthode CheckSpace permet de vérifier si un navire et présent sur la Grid du joueur.
     * @param orientation L'orientation du navire
     * @param y La coordonnée du navire en Y
     * @param x La coordonnée du navire en X
     * @param taille La taille du navire
     * @return false si pas de navire
     */
    private boolean CheckSpace(String orientation, int y, int x, int taille){
        if (Objects.equals(orientation, "vertical")) {
            for (int i = y; i < (y + taille); i++) {
                if (!Objects.equals(Grid.grid[x][i], "|__") & (!Objects.equals(Grid.grid[x][i], pattern))){
                    return false;
                }
            }
        }
        else if (Objects.equals(orientation, "horizontal")) {
            for (int i = x; i < (x + taille); i++) {
                if (!Objects.equals(Grid.grid[i][y], "|__") & (!Objects.equals(Grid.grid[i][y], pattern))){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * La méthode CheckSpaceCPU permet de vérifier si un navire et présent sur la Grid de l'ordinateur.
     * @param orientation L'orientation du navire
     * @param y La coordonnée du navire en Y
     * @param x La coordonnée du navire en X
     * @param taille La taille du navire
     * @return false si pas de navire
     */
    private boolean CheckSpaceCPU(String orientation, int y, int x, int taille){
        if (Objects.equals(orientation, "vertical")) {
            for (int i = y; i < (y + taille); i++) {
                if (!Objects.equals(GridCPU.grid[x][i], "|__")) {
                    return false;
                }
            }
        }
        else if (Objects.equals(orientation, "horizontal")) {
            for (int i = x; i < (x + taille); i++) {
                if (!Objects.equals(GridCPU.grid[i][y], "|__")){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * La méthode permet de faire apparaître des navires sur la Gird
     * @param user Si user = joueur alors on faire apparaître des navires sur la Gird du joueur. Sinon celle de l'ordinateur
     * @throws Exception (y a rien)
     */

    public void SpawnBoat(boolean user) throws Exception {
        // Chaque joueur possède une flotte de 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous-marins/

        GenerateCroiseur(user);
        GenerateDestroyer(user);
        GenerateCuirrasse(user);
        GenerateSous_Marin(user);
        if (user) {
            PrintGrid(true);
        }

    }

    /**
     * La méthode RanCoord permet de générer des coordonner au hasard.
     * @param orientation L'orientation du navire
     * @param taille La taille du navire
     * @return Une entier
     */
    private int[] RandCoord(String orientation, int taille){
        int borneInf= 0;
        int borneSup= Grid.y;
        int[] nb = new int[2];
        Random random= new Random();
        if (Objects.equals(orientation, "horizontal")) {
            // Generate x
            nb[0] = borneInf + random.nextInt((borneSup - taille) - borneInf);
            // Generate y
            nb[1] = borneInf + random.nextInt(borneSup - borneInf);
        }
        else{
            // Generate x
            nb[0] = borneInf+random.nextInt(borneSup - borneInf);
            // Generate y
            nb[1] = borneInf+random.nextInt((borneSup-taille) - borneInf);
        }
        return nb;
    }

    /**
     * La méthode RandOrientation permet de générer une orientation au hasard.
     * @return un String
     */
    private String RandOrientation(){
        String orientation="";
        int borneInf= 1;
        int borneSup= 3;
        int nb;
        Random random= new Random();
        nb = borneInf+random.nextInt(borneSup-borneInf);
        if(nb==1){
            orientation = "vertical";
        } else {
            orientation = "horizontal";
        }

        return orientation;
    }

    /**
     * La méthode GenerateCuirrasse permet de générer un cuirrasse dans une Grid
     * @param user Si user = player alors on ajoute un cuirasse dans la Grid joueur. Sinon on le met dans la Gris de l'ordinateur
     */
    private void GenerateCuirrasse(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,7);
        cuirasse = new Cuirasse(coord[0], coord[1], orientation,user,1);
    }

    /**
     * La méthode GenerateCroiseur permet de générer un croiseur dans une Grid
     * @param user Si user = player alors on ajoute un croiseur dans la Grid joueur. Sinon on le met dans la Gris de l'ordinateur
     */
    private void GenerateCroiseur(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,5);
        croiseur = new Croiseur(coord[0], coord[1], orientation, user,1);
        orientation = RandOrientation();
        coord = RandCoord(orientation,5);
        croiseur1 = new Croiseur(coord[0], coord[1], orientation,user,2);
    }

    /**
     * La méthode GenerateDestroyer permet de générer un destroyer dans une Grid
     * @param user Si user = player alors on ajoute un destroyer dans la Grid joueur. Sinon on le met dans la Gris de l'ordinateur
     */
    private void GenerateDestroyer(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,3);
        destroyer = new Destroyer(coord[0], coord[1], orientation,user,1);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        destroyer1 = new Destroyer(coord[0], coord[1], orientation,user,2);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        destroyer2 = new Destroyer(coord[0], coord[1], orientation,user,3);

    }

    /**
     * La méthode GenerateSous_Marin permet de générer un sous_marin dans une Grid
     * @param user Si user = player alors on ajoute un sous_marin  dans la Grid joueur. Sinon on le met dans la Gris de l'ordinateur
     */
    private void GenerateSous_Marin(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,1);
        Sous_Marin = new Sous_Marin(coord[0], coord[1], orientation,user,1);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin1 = new Sous_Marin(coord[0], coord[1], orientation,user,2);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin2 = new Sous_Marin(coord[0], coord[1], orientation,user,3);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin3 = new Sous_Marin(coord[0], coord[1], orientation,user,4);
    }

    /**
     * La méthode IncrementCoord permet d'incrementer les coordonner
     */

    private void IncrementCoord(){
        if (Objects.equals(orientation, "vertical")) {
            if (direction){
                y-=1;
            }else {
                y+=1;
            }

        }
        if (Objects.equals(orientation, "horizontal")) {
            if (direction){
                x+=1;
            }else {
                x-=1;
            }
        }
    }

    /**
     * La méthode ResetCoord permet de reset les coordonner
     */

    private void ResetCoord(String orientation,boolean direction){
        if (Objects.equals(orientation, "vertical")) {
            if (direction){
                y+=1;
            }else {
                y-=1;
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            if (direction){
                x+=1;
            }else {
                x-=1;
            }
        }
    }

    /**
     * La méthode CheckImpact permet de vérifier si un navire est présent sur la Grid de l'ordinateur ou joueur.
     * @param x Coordonnées en X
     * @param y Coordonnées en Y
     * @param user Si user= playeur alors on check la Grid de l'ordinateur. Sinon on check celle du joueur
     */
    public void CheckImpact(int x, int y,boolean user) {
        if (!IsDMG) {
            switch (pTire) {
                case 1:
                    if (user) {
                        subCheckImpact(y, x);
                    } else {
                        subCheckImpactCPU(y, x);
                    }
                    break;
                case 4:
                    for (int i = x - 1; i < x + 2; i++) {
                        if (i < xMax & i >= 0) {
                            if (user) {
                                subCheckImpact(y, i);
                            } else {
                                subCheckImpactCPU(y, i);
                            }
                        }
                    }
                    for (int i = y - 1; i < y + 2; i++) {
                        if (i != y & i < yMax & i >= 0) {
                            if (user) {
                                subCheckImpact(i, x);
                            } else {
                                subCheckImpactCPU(i, x);
                            }
                        }
                    }
                    break;
                case 9:
                    for (int i = x - 1; i < x + 2; i++) {
                        for (int j = y - 1; j < y + 2; j++) {
                            if (i < xMax & j < yMax & i >= 0 & j >= 0) {
                                if (user) {
                                    subCheckImpact(j, i);
                                } else {
                                    subCheckImpactCPU(j, i);
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }

    /**
     * La méthode subCheckImpact permet d'afficher les tires sur la Grid de l'ordinateur
     * @param y Coordonnées en Y
     * @param x Coordonnées en X
     */
    private void subCheckImpact(int y, int x) {
        if (IsBoat(x,y)){
            //Add impact on boat
            System.out.println("Impact Confirmed");
            if (Objects.equals(GridCPU.grid[x][y], "|U1") & !IsCuirasseAlreadyDMG(x,y)){
                Grid.AddTireImpactOnMonitor(x,y,2);
                GridCPU.AddTireImpactOnPlayerGrid(x,y,2);
            } else{
                Grid.AddTireImpactOnMonitor(x,y,1);
                GridCPU.AddTireImpactOnPlayerGrid(x,y,1);
            }
        }else {
            //Add impact in water
            Grid.AddTireImpactOnMonitor(x,y,0);
        }
    }

    /**
     * La méthode subCheckImpact permet d'afficher les tires sur la Grid du joueur
     * @param y Coordonnées en Y
     * @param x Coordonnées en X
     */
    private void subCheckImpactCPU(int y, int x) {
        if (IsBoatCPU(x,y)){
            //Add impact on boat
            System.out.println("Impact Confirmed");
            if (Objects.equals(Grid.grid[x][y], "|U1") & !IsCuirasseAlreadyDMG(x,y)){
                GridCPU.AddTireImpactOnMonitor(x,y,2);
                Grid.AddTireImpactOnPlayerGrid(x,y,2);
            } else{
                GridCPU.AddTireImpactOnMonitor(x,y,1);
                Grid.AddTireImpactOnPlayerGrid(x,y,1);
            }
        }else {
            //Add impact in water
            GridCPU.AddTireImpactOnMonitor(x,y,0);
        }
    }

    /**
     * La méthode IsCuirasseAlreadyDMG Vérifie si le cuirasse ne soit pas endommagée
     * @param x Coordonnées en X
     * @param y Coordonnées en Y
     * @return
     */

    private boolean IsCuirasseAlreadyDMG(int x,int y){
        return (Objects.equals(Grid.grid[x + 17][y], "\033[32m|U1\033[0m")|Objects.equals(Grid.grid[x + 17][y], "\033[31m|TT\033[0m"));
    }

    /**
     * La méthode IsBoat permet de check si un navire et présent dans la Grid de l'ordinateur.
     * @param x Coordonnées en X
     * @param y Coordonnées en Y
     * @return True si un navire est présent
     */
    private boolean IsBoat(int x,int y){
        /*
        System.out.println("Checking impact");
        System.out.println("GridCPU["+x+"]["+y+"]= "+GridCPU.grid[x][y]);
        */
        return !Objects.equals(GridCPU.grid[x][y], "|__");
    }
    /**
     * La méthode IsBoat permet de check si un navire et présent dans la Grid du joueur.
     * @param x Coordonnées en X
     * @param y Coordonnées en Y
     * @return True si un navire est présent
     */

    private boolean IsBoatCPU(int x,int y){
        /*
        System.out.println("Checking impact");
        System.out.println("GridCPU["+x+"]["+y+"]= "+GridCPU.grid[x][y]);
        */
        return !Objects.equals(Grid.grid[x][y], "|__");
    }

    private boolean IsRocket(int x,int y){
        return Objects.equals(tireB[x][y], "|XX");
    }

    /**
     * La méthode checkAllboatLife vérifie la vie des navires.
     *
     * @return
     */

    public boolean checkAllboatLife(boolean user){
        Sous_Marin.checkBoatLife(user);
        Sous_Marin1.checkBoatLife(user);
        Sous_Marin2.checkBoatLife(user);
        Sous_Marin3.checkBoatLife(user);
        destroyer.checkBoatLife(user);
        destroyer1.checkBoatLife(user);
        destroyer2.checkBoatLife(user);
        croiseur.checkBoatLife(user);
        croiseur1.checkBoatLife(user);
        cuirasse.checkBoatLife(user);
        return false;
    }

    /**
     * La méthode checkAllboatLife vérifie la vie des navires.
     */
    protected void checkBoatLife(boolean user){
        String[][] grid;
        if (user) {
            grid = Grid.getGrid();
        } else{
            grid = GridCPU.getGrid();
        }
        int count = 0;
        for (int x=0; x < xMax;x++){
            for (int y=0; y < yMax;y++){
                if (Objects.equals(grid[x][y], pattern)){
                    count ++;
                }
            }
        }
        IsDead = (count == 0);
        IsDMG =  (count != boatHp);
    }

    /**
     * La méthode clearBoat suprime les navires de la Grid.
     */
    private void clearBoat(){
        if (Objects.equals(orientation, "horizontal")){
            if (direction){
                Grid.grid[x-1][y] = "|__";
            }
            else {
                Grid.grid[x+taille][y] = "|__";

            }
        } else {
            if (direction){
                Grid.grid[x][tempy+taille-1] = "|__";
            }
            else {
                Grid.grid[x][tempy] = "|__";
            }
        }
    }

    /**
     * La méthode clearBoat suprime les navires de la Grid.
     */
    private void clearBateau(){
        for (int x = 0; x < bateau.length;x++){
            Arrays.fill(bateau[x], "|__");
        }
    }

    /**
     * La méthode IsAllBoatDead permet de vérifier si les navires sont détruits.
     * @return True si tout les navires sont détruits.
     */
    public boolean IsAllBoatDead(){
        if (Sous_Marin.IsDead & Sous_Marin1.IsDead & Sous_Marin2.IsDead & Sous_Marin3.IsDead){
            if (destroyer.IsDead & destroyer1.IsDead & destroyer2.IsDead){
                if (croiseur.IsDead & croiseur1.IsDead){
                    return cuirasse.IsDead;
                }
            }
        }
        return false;
    }

    /**
     * La méthode nuke permet de terminer la partie
     */

    public void nuke(){
        for (int x = 0; x < xMax;x++){
            for (int y = 0; y < yMax; y++){
                subNuke(x,y);
            }
        }
    }
    /**
     * La méthode subNuke permet de terminer la partie
     */

    private void subNuke(int x,int y){
        if (IsBoat(x,y)){
            //Add impact on boat
            Grid.AddTireImpactOnMonitor(x,y,1);
            GridCPU.AddTireImpactOnPlayerGrid(x,y,1);
        }else {
            //Add impact in water
            Grid.AddTireImpactOnMonitor(x,y,0);
        }
    }

    /**
     * La méthode  PrintGrid permet d'afficher la Grid.
     * @param player Soit player = joueur ou ordinateur
     */
    public void PrintGrid(boolean  player){
        if (player) {
            Screen.Nom_Grille(Grid.getX());
            Screen.PrintHeader(Grid.getX());
            Screen.PrintGrid(Grid.getGrid(), Grid.getX(), Grid.getY());
        } else {
            Screen.Nom_Grille(GridCPU.getX());
            Screen.PrintHeader(GridCPU.getX());
            Screen.PrintGrid(GridCPU.getGrid(), GridCPU.getX(), GridCPU.getY());
        }
    }

    /**
     * La méthode getOrientation permet de récupérer l'orientation d'un navire
     * @return String
     */
    public String getOrientation() {
        return orientation;
    }


}

