import java.util.Random;

public class GameLogic {

	private String[] cards;
	private int balance;

	public GameLogic(){
		cards = new String[] { "Ace", "King", "Queen", "Jack", "Joker" };
		this.balance = 100;
	}


	public String[] getCards() {
		return cards;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int newBalance){
	    balance = newBalance;
    }

	public void spin() {

		String[] drawnCards = new String[3];
        Random random = new Random();
		for (int i = 0; i < 3; i++) {


			drawnCards[i] = cards[random.nextInt(cards.length)] ;
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
