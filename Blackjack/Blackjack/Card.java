public class Card {
	private int deckNum;
	private CardSuit suit;
	private int value;
	
	public Card(){
	}
	
	//Constructs a Card and initializes variables
	public Card(int deckNum, CardSuit suit, int value) {
		this.suit = suit;
		this.value = value;
		this.deckNum = deckNum;
	}
	
	//Returns the Deck Number
	public int getDeckNum() {
		return deckNum;
	}

	//Returns the card suit
	public CardSuit getSuit() {
		return suit;
	}

	//Returns value
	public int getValue() {
		return value;
	}
	
	//Returns string of the card suit and value
	public String toString() {
		String s = "";
		s =suit + "-"+ value;
		return s;
	}
}
