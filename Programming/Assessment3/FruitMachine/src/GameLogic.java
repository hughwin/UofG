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

        I considered creating a separate class for cards, but this I believe
        would add unnecessary complexity to my code: the cards don’t need to be
        instantiated as they don’t have their own properties.
         */
    // instance variable declaration
    private UserInterfaceFrame userInterfaceFrame;
    private String[] cards;
    private String[] drawnCards;
    private int balance;

    public GameLogic(UserInterfaceFrame userInterfaceFrame) { // Constructor for GameLogic class
        this.userInterfaceFrame = userInterfaceFrame;
        cards = new String[]{"Ace", "King", "Queen", "Jack", "Joker"}; // Creates an 
        drawnCards = new String[3]; // creates an empty array of length 3 
        balance = 100; // creates the instance variable balance with an initial value of 100 (at the start of the game). 
    }

    public String[] getCards() {
        return cards;
    }

    public void getBalance() {
        userInterfaceFrame.getBalanceLabel().setText("Balance: " + balance);
    }

    public void setCardsLabels() { // returns a card (String) from the drawnCard array at int x
        userInterfaceFrame.getCard1Label().setText(drawnCards[0]);
        userInterfaceFrame.getCard2Label().setText(drawnCards[1]);
        userInterfaceFrame.getCard3Label().setText(drawnCards[2]);
    }

    public void setBalance(int newBalance) { // sets balance to an int specified by newBalance
        balance = newBalance;
    }

    public void spin() {

        Random random = new Random(); // creates a new Random object for the random selection of cards
        int jokerCount = 0; // variable to count the number of Jokers 
        for (int i = 0; i < 3; i++) { // Iterates over the drawnCards array 

            drawnCards[i] = cards[random.nextInt(cards.length)]; // Assign drawnCards[i] to a random card

            if (drawnCards[i].equals("Joker")) { // If the card is a joker
                balance -= 25; // deducts 25 from balance
                jokerCount++; // increases the number of jokers
            }
        }
//        if (jokerCount > 1) { // if jokerCount is over 0
//            return jokerCount + " jokers: you lose " + (25 * jokerCount) + " points"; // returns the string with the number of jokers and points.
//        }
//        if (jokerCount != 0) { // if jokerCount is 1, returns the string below
//            return jokerCount + " joker: you lose " + (25 * jokerCount) + " points";
//        }
//
//        if (drawnCards[0].equals(drawnCards[1]) && drawnCards[1].equals(drawnCards[2])) { // detects whether the 3 Strings in the array are the same
//            balance += 50; // increases balance by 50
//            return "Three of a kind - you win 50 points"; // returns a String
//
//        } else if (drawnCards[0].equals(drawnCards[1]) || drawnCards[0].equals(drawnCards[2])
//                || drawnCards[1].equals(drawnCards[2])) { // detects whether there are two of the same cards in the drawnCards array
//
//            balance += 20; // increases balance by 20
//            return "Two of a kind - you win 20 points"; // returns a String
//        }
//        return "Balance unchanged"; // If there are no jokers and no matching pairs, a message is returned to the player informing them the balance is unchanged.
    }

    public boolean hasWon() { // if balance is greater than 150, hasWon() returns true. 
        return balance >= 150;
    }

    public boolean hasLost() { // if balance is less than 0, hasLost returns true. 
        return balance < 0;
    }

}
