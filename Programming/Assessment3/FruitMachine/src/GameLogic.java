/*
Hugh Winchester
2494047W
 */


import java.util.Random;

public class GameLogic {

    private String[] cards;
    private String[] drawnCards;
    private int balance;

    public GameLogic() {
        cards = new String[]{"Ace", "King", "Queen", "Jack", "Joker"};
        drawnCards = new String[3];
        this.balance = 100;
    }

    public String[] getCards() {
        return cards;
    }

    public int getBalance() {
        return balance;
    }

    public String getDrawnCardAtX(int x) {
        return drawnCards[x];
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public String spin() {

        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 3; i++) {

            drawnCards[i] = cards[random.nextInt(cards.length)];
            System.out.println(drawnCards[i]);

            if (drawnCards[i].equals("Joker")) {
                balance -= 25;
                count++;
            }
        }
        if (count > 1) {
            return count + " jokers: you lose " + (25 * count) + " points";
        }
        if (count != 0) {
            return count + " joker: you lose " + (25 * count) + " points";
        }

        if (drawnCards[0].equals(drawnCards[1]) && drawnCards[1].equals(drawnCards[2])) {
            balance += 50;
            return "Three of a kind - you win 50 points";

        } else if (drawnCards[0].equals(drawnCards[1]) || drawnCards[0].equals(drawnCards[2])
                || drawnCards[1].equals(drawnCards[2])) {

            balance += 20;
            return "Two of a kind - you win 20 points";
        }
        return null;
    }
}
