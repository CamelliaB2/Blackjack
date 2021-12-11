public class Card {
//	public static final int ACE = 1;
//	public static final int TWO = 2;
//	public static final int THREE = 3;
//	public static final int FOUR = 4;
//	public static final int FIVE = 5;
//	public static final int SIX = 6;
//	public static final int SEVEN = 7;
//	public static final int EIGHT = 8;
//	public static final int NINE = 9;
//	public static final int TEN = 10;
//	public static final int J = 11;
//	public static final int Q = 12;
//	public static final int K = 13;
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
