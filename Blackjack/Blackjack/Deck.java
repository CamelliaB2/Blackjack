import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private int numPeck;
	private int card = 0;
	
	/**
	 * The constructor for the Deck
	 * @param numPeck
	 */	
	public Deck(int numPeck) {
		this.setNumPeck(numPeck);
		cards = new ArrayList<>();
		createDeck(numPeck);
		mixCards(10);
	}
	
		/**
		 * Create a deck which how many boxes of cards how
		 * @param num the number of how many boxes
		 */
	 public void createDeck(int num) {
		if(num<1) {
			System.out.println("not valued number");
		}
		else{
			for(int i = 0; i < num; i++) {
				for(int j = 1; j <= 13; j++) {
					cards.add(new Card(i,CardSuit.CLUB,j));
					cards.add(new Card(i,CardSuit.DIAMOND,j));
					cards.add(new Card(i,CardSuit.HEART,j));
					cards.add(new Card(i,CardSuit.SPADE,j));
				}
			}
		}
	}
	
		/**
		 * Swaps two cards
		 * @param a card a
		 * @param b card b
		 */
	public void swapCards(int a, int b) {
		Card temp = cards.get(a);
		cards.set(a,cards.get(b));
		cards.set(b,temp);
	}
	
	/**
	 * Mix all of the cards in the deck
	 * @param times of fix the cards
	 */
	public void mixCards(int times) {
		int totalCards = 52* numPeck;
		Random r1 = new Random();
		Random r2 = new Random();
		for(int i = 0; i < totalCards*times; i++) {
			swapCards(r1.nextInt(totalCards), r2.nextInt(totalCards));
		}
	}
	
	/**
	 * Prints cards
	 */
	public void printAll() {
		for(int i = 0; i < cards.size(); i++) {
			System.out.print(cards.get(i).getValue() + ", ");
		}
	}
	
	/**
	 * Get next card in the deck
	 * @return a next card in deck
	 */
	public Card getNextCard() {
		Card c = cards.get(card);
		card++;
		return c;
	}
	
	/**
	 * Get the number of the peck
	 * @return integer number of the deck
	 */
	public int getNumPeck() {
		return numPeck;
	}
	
	/**
	 * Set the card is belong to which deck
	 * @param numPeck
	 */
	public void setNumPeck(int numPeck) {
		this.numPeck = numPeck;
	}
}
