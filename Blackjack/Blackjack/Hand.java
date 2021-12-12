public class Hand
{

	private Card[] theHand; 
	private int numberOfCards;

	/**
	 * The constructor for the Hand
	 */
	public Hand() {
		theHand = new Card[12];  // at most a hand only can have 12 card--->(1111,2222,3333)
		numberOfCards = 0;
	}
	
	/**
	 * Calculates the total of a hand and also decides whether ace is 1 or 11
	 * @return integer for calculate the total value in this hand 
	 */
	public int calculateTotal() {
		int total =0;
		for(int i = 0; i < numberOfCards; i++) {
			int value = theHand[i].getValue();
			if(value != 1 && value != 11 && value != 12 && value != 13) {
				total += value;
			}
			else if(value == 11 || value == 12 || value == 13) {
				total += 10;
			}
		}
		for(int i = 0; i < numberOfCards; i++) {
			int value = theHand[i].getValue();
			if(value == 1) {
				if(total > 10) {
					total += value;
				}
				else {
					total += 11;
				}
			}
		}
		return total;
	}
	
	/**
	 * Add one card in this hand
	 * @param card the card need to add in this hand
	 */
	public void addCard(Card card) {
		theHand[numberOfCards++] = card;
		//example: when we need add card to player's hand ,we could call 
		// player.get(i).getHand.get(j).addCard(Deck.getNextCard());
		//i and j are which player and player's which hand, cause player can split the hand to two hand
	}
	
	/**
	 * Gets the all card in this hand
	 * @return Card[] a array within all card in this hand
	 */
	public Card[] getCard() {
		return theHand;
	}
	
	/**
	 * Clears all hand
	 */	
	public void clearHand() {
		numberOfCards = 0;
		theHand = new Card[12];
	}
	
	/**
	 * Print all card in Player's hand
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < numberOfCards; i++) {
			s += theHand[i].toString() +", ";
		}
		return s;
	}
	
	/**
	 * Print the dealer's hand
	 * @param hide if need hide one card in dealer's hand
	 * @return all card suit and value in dealer's hand
	 */
	public String dealerToString(boolean hide) {
		String s = theHand[0].toString() + ", [Hide]";
		return s;
	}
}
