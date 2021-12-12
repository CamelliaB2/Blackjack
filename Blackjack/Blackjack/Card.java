public class Card {
	private int deckNum;
	private CardSuit suit;
	private int value;
	public Card(){
	}
	public Card(int deckNum, CardSuit suit, int value) {
		this.suit = suit;
		this.value = value;
		this.deckNum = deckNum;
	}
	public int getDeckNum() {
		return deckNum;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	public String toString() {
		String s = "";
		s =suit + "-"+ value;
		return s;
	}
}
