//package BlackJack;
/**
 * a card should have it value Ace - King, suit, and deckNum for which deck it belong to
 * @author Xu Shi
 * @version 1.0
 */
public class Card {
	private int deckNum;
	private CardSuit suit;
	private int value;
	/**
	 * constructor for the Card
	 */
	public Card(int deckNum, CardSuit suit, int value) {
		this.suit = suit;
		this.value = value;
		this.deckNum = deckNum;
	}
	/**
	 * get the deck number
	 * @return deckNum is the deck's number
	 */
	public int getDeckNum() {
		return deckNum;
	}
	/**
	 * get the card suit
	 * @return suit for the card
	 */
	public CardSuit getSuit() {
		return suit;
	}
	/**
	 * get the card value
	 * @return value for the card
	 */
	public int getValue() {
		return value;
	}
	/**
	 * get the name of the card suit and value
	 */
	public String toString() {
		String s = "";
		s =suit + "-"+ value;
		return s;
	}
}
