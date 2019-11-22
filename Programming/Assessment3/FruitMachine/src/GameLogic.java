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
    private String[] cards;
    private String[] drawnCards;
    private int balance;


    
    public GameLogic() { // Constructor for GameLogic class
        cards = new String[]{"Ace", "King", "Queen", "Jack", "Joker"}; // Creates an 
        drawnCards = new String[3]; // creates an empty array of length 3 
        balance = 100; // creates the instance variable balance with an initial value of 100
    }

    public String[] getCards() {
        return cards; 
    }

    public int getBalance() {
        return balance;  // returns the balance as an int
    }

    public String getDrawnCardAtX(int x) { // returns a card (String) from the drawnCard array at int x
        return drawnCards[x];  
    }

    public void setBalance(int newBalance) { // sets balance to an int specified by newBalance
        balance = newBalance;             
    }

    public String spin() {

        Random random = new Random(); // creates a new Random object for the random selection of cards
        int jokerCount = 0; // variable to count the number of Jokers 
        for (int i = 0; i < 3; i++) {

            drawnCards[i] = cards[random.nextInt(cards.length)];
            System.out.println(drawnCards[i]);

            if (drawnCards[i].equals("Joker")) {
                balance -= 25;
                jokerCount++;
            }
        }
        if (jokerCount > 1) {
            return jokerCount + " jokers: you lose " + (25 * jokerCount) + " points";
        }
        if (jokerCount != 0) {
            return jokerCount + " joker: you lose " + (25 * jokerCount) + " points";
        }

        if (drawnCards[0].equals(drawnCards[1]) && drawnCards[1].equals(drawnCards[2])) { // detects whether the 3 Strings in the array are the same
            balance += 50; // increases balance by 50
            return "Three of a kind - you win 50 points"; // returns a String 

        } else if (drawnCards[0].equals(drawnCards[1]) || drawnCards[0].equals(drawnCards[2])
                || drawnCards[1].equals(drawnCards[2])) { // detects whether there are two of the same cards in the drawnCards array

            balance += 20; // increases balance by 20 
            return "Two of a kind - you win 20 points"; // returns a String
        }
        return null; // If there are no jokers and no matching pairs / triples null is returned. 
    }
}
