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
        if (drawnCards[x].equals("0") || drawnCards[x].equals("1") || drawnCards[x].equals("2")) {
            return "Joker";
        }
        return drawnCards[x];
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public void spin() {

        Random random = new Random();
        for (int i = 0; i < 3; i++) {

            drawnCards[i] = cards[random.nextInt(cards.length)];
            System.out.println(drawnCards[i]);
            if (drawnCards[i].equals("Joker")) {
                balance -= 25;
                drawnCards[i] = i + ""; //
            }

        }
        if (drawnCards[0].equals(drawnCards[1]) && drawnCards[1].equals(drawnCards[2])) {
            balance += 50;
        } else if (drawnCards[0].equals(drawnCards[1]) || drawnCards[0].equals(drawnCards[2])
                || drawnCards[1].equals(drawnCards[2])) {

            balance += 20;
        }
        System.out.println(balance);
    }

    public boolean hasWon() {

        if (balance > 150) {
            return true;
        }
        return false;

    }

    public boolean hasLost() {

        if (balance < 0) {
            return true;
        }
        return false;

    }
}
