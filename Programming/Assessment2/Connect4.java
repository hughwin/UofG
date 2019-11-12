/*
Hugh Winchester 2494047W
 */

import java.util.Random;

public class Connect4 {

    public static void main(String[] args) {

        play(6, 7); // Starts the game on a board of board the size of 6 and 7. 

    }

    public static void play(int rows, int columns) { // Starts the game and specifies a board size of int.

        Player a = new Player("Hugh", 'x'); // Creates a reference (a) to a new Player object and gives the player a
        // name and a symbol as required.
        Player b = new Player("Kala", 'o');

        Counter playerACounter = new Counter(a); // Creates a reference (playerACounter) to a new Counter object.
        Counter playerBCounter = new Counter(b); // Creates a reference (playerACounter) to a new Counter object.

        Board playingBoard = new Board(rows, columns); // Creates a reference (playingBoard) to a new Board object.

        Random random = new Random(); // Creates a new random object

        while (!playingBoard.isFull()) { // Ensures that the game is played until playingBoard.isFull() returns true.

            int rand1 = random.nextInt(columns); // Generates a random number between 0 and columns (including 0, exclusive of columns).

            if (!playingBoard.add(playerACounter, rand1)) { // If the playingBoard.add() method returns false
                // the computer continues to random generate numbers until if finds the one that is required.   
                while (true) {
                    rand1 = random.nextInt(columns);
                    if (playingBoard.add(playerBCounter, rand1)) {
                        break;  // breaks out of the while loop and allows the program to continue
                    }
                }
            }

            if (playingBoard.testWinConditions(playerACounter)) { // Tests to see if there is a winning position that has been played by Player a/
                System.out.println(a.getName() + " is the winner"); // if the method returns true, the name of the player is returned + " is the winner" 
                System.out.println(playingBoard.toString()); // The game board is printed out to the console. 
                break; // the while loop is broken out of if there is a winner. 
            }
            System.out.println(playingBoard.toString()); // Prints out the board after first player has had their go

            int rand2 = random.nextInt(columns);

            if (!playingBoard.add(playerBCounter, rand2)) { // As above. 
                while (true) {
                    rand2 = random.nextInt(columns);
                    if (playingBoard.add(playerBCounter, rand2)) {
                        break;
                    }
                }
            }

            if (playingBoard.testWinConditions(playerBCounter)) {
                System.out.println(b.getName() + " is the winner");
                System.out.println(playingBoard.toString());
                break;
            }

            System.out.println(playingBoard.toString());

        }

    }
}
