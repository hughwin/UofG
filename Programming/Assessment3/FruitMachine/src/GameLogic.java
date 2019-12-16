/*
Hugh Winchester
2494047W
 */

import java.util.Random;

public class GameLogic {

    /*
        The GameLogic class contains the code determining the game's functionality.
        The class is responsible for drawing cards when the user clicks spin, and
        determining the change in balance.

        I considered creating a separate class for cards (for the purpose of
        extensibility of the program), but this I believe would add unnecessary
        complexity to my code as the cards don’t need to be instantiated or have their own behaviour.
        Should the program be extended in the future, it is fairly trivial to put the cards in their own class.
         */

    // instance variable declaration
    private UserInterfaceFrame userInterfaceFrame;
    private String[] cards;
    private String[] drawnCards;
    private int balance;

    public GameLogic(UserInterfaceFrame userInterfaceFrame) { // Constructor for GameLogic class
        this.userInterfaceFrame = userInterfaceFrame;
        cards = new String[]{"Ace", "King", "Queen", "Jack", "Joker"}; // Creates an array filled with the cards as Strings
        drawnCards = new String[3]; // creates an empty array of length 3 
        balance = 100; // creates the instance variable balance with an initial value of 100 (at the start of the game). 
    }



    public void setBalanceLabel() {  // sets the value of balanceLabel in the view to the current value of Balance
        userInterfaceFrame.getBalanceLabel().setText("Balance is " + balance); // uses getBalanceLabel() from the view to get the label and to set it to the value of balance.
    }

    public void setCardsLabels() { // sets the labels of the cards according to the drawnCards array
        userInterfaceFrame.getCard1Label().setText(drawnCards[0]);
        userInterfaceFrame.getCard2Label().setText(drawnCards[1]);
        userInterfaceFrame.getCard3Label().setText(drawnCards[2]);
    }

    public void setBalance(int newBalance) { // sets balance to an int specified by newBalance
        balance = newBalance;
        setBalanceLabel();
    }

    public void spin() {

        Random random = new Random(); // creates a new Random object for the random selection of cards
        int jokerCount = 0; // variable to count the number of Jokers 
        for (int i = 0; i < 3; i++) { // Iterates over the drawnCards array 

            drawnCards[i] = cards[random.nextInt(cards.length)]; // Assign drawnCards[i] to a random card
            System.out.println(drawnCards[0] + " " + drawnCards[1] + " " + drawnCards[2]);

            if (drawnCards[i].equals("Joker")) { // If the card is a joker
                balance -= 25; // deducts 25 from balance
                jokerCount++; // increases the number of jokers
            }

        }
        if (jokerCount > 1) { // if jokerCount is over 0
            userInterfaceFrame.getCardsLabel().setText(jokerCount + " jokers: you lose " + (25 * jokerCount) + " points"); // Sets the number of jokers and points.
            return;
        }
        if (jokerCount != 0) { // if jokerCount is 1, returns the string below
            userInterfaceFrame.getCardsLabel().setText(jokerCount + " joker: you lose " + (25 * jokerCount) + " points");
            return;
        }

        if (drawnCards[0].equals(drawnCards[1]) && drawnCards[1].equals(drawnCards[2])) { // detects whether the 3 Strings in the array are the same
            balance += 50; // increases balance by 50
            userInterfaceFrame.getCardsLabel().setText("Three of a kind - you win 50 points"); // Sets the getCardsLabel
            return;

        } else if (drawnCards[0].equals(drawnCards[1]) || drawnCards[0].equals(drawnCards[2])
                || drawnCards[1].equals(drawnCards[2])) { // detects whether there are two of the same cards in the drawnCards array

            balance += 20; // increases balance by 20
            userInterfaceFrame.getCardsLabel().setText("Two of a kind - you win 20 points"); // Sets the getCardsLabel
            return;
        } else {
            userInterfaceFrame.getCardsLabel().setText("Balance unchanged");
        }// If there are no jokers and no matching pairs, a message is returned to the player informing them the balance is unchanged.
    }


    public void checkWinLoss() { // Checks whether the player has won or lost
        if (balance < 0) {       // If the balance is less than 0
            userInterfaceFrame.getSpinButton().setEnabled(false); // Disables the spin button
            userInterfaceFrame.getResetButton().setEnabled(true); // Enables the reset button
            userInterfaceFrame.getWinLoseLabel().setText("You lose!"); // Sets the WinLose JLabel to "You lose!"
        }
        if (balance >= 150) { // If balance is 150 or greater
            userInterfaceFrame.getSpinButton().setEnabled(false); // Disables the spin button
            userInterfaceFrame.getResetButton().setEnabled(true); // Enables the reset button
            userInterfaceFrame.getWinLoseLabel().setText("You win!"); // Sets the WinLose JLabel to "You win!"

        }
    }

    public void reset() { // Resets the game if a player wins / loses
        setBalance(100); // Sets the balance back to the starting balance of 100
        userInterfaceFrame.getResetButton().setEnabled(false); // Disables the reset button
        userInterfaceFrame.getSpinButton().setEnabled(true);   // Sets the spin button to enabled
        userInterfaceFrame.getCardsLabel().setText("Welcome!"); // Sets the cards label to "Welcome!"
        userInterfaceFrame.getWinLoseLabel().setText("");       // Functionally removes the win loss label on reset
    }

}
