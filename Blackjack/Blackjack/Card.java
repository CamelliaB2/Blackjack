public class Card {
	private int deckNum;
	private CardSuit suit;
	private int value;
	
	public Card(){
	}
	
	/**
	 * Constructor for the Card
	 */
	public Card(int deckNum, CardSuit suit, int value) {
		this.suit = suit;
		this.value = value;
		this.deckNum = deckNum;
	}
	
	/**
	 * Get the deck number
	 * @return deckNum is the deck's number
	 */
	public int getDeckNum() {
		return deckNum;
	}

	/**
	 * Get the card suit
	 * @return suit for the card
	 */
	public CardSuit getSuit() {
		return suit;
	}

	/**
	 * Get the card value
	 * @return value for the card
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Get the name of the card suit and value
	 */
	public String toString() {
		String s = "";
		s =suit + "-"+ value;
		return s;
	}
}
