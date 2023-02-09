import Grid.Grid;
import Navires.Navire;

/**
 * Création de la classe Player.
 */
public class Player {
    /**
     * Création d'un instance d'objet de type Grid.
     */
    private Grid board;  // Game board for this player
    /**
     * Création d'un instance d'objet de type Navire.
     */
    public Navire navires;
    /**
     * Création d'un entier pour le nombre de navire.
     */
    private int numShips;  // Number of remaining ships for this player

    // Constructor to create a player with a given game board

    /**
     * Constructeur par default.
     * initialisation des variables board,  navires et numShips.
     */
    public Player() {
        board = new Grid();
        navires = new Navire();
        numShips = 10;  // Initialize the number of ships to 5 (this can be changed)
    }

    // Method to allow the player to guess coordinates
    /*public boolean guess(int x, int y) {
        return board.checkGuess(x, y);  // Check the guess with the game board
    }*/

    // Method to check whether the player has any remaining ships

    /**
     * La méthode renvoit 0 s'il y a plus de navires.
     * @return numShips
     */
    public boolean hasShips() {
        return numShips > 0;  // Return true if the number of remaining ships is greater than 0
    }

    // Method to decrement the number of remaining ships for this player
    /**
     * La méthode décrémente le nombre de navires.
     */
    public void ShipAmmount() {
        numShips--;  // Decrement the number of remaining ships
    }
}
