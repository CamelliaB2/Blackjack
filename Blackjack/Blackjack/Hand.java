public class Hand
{

	private Card[] theHand; 
	private int numberOfCards;

	public Hand() {
		theHand = new Card[12];  // at most a hand only can have 12 card--->(1111,2222,3333)
		numberOfCards = 0;
	}
	// Calculates the total of a hand and also decides whether ace is 1 or 11
	public int calculateTotal() {
		int total =0;
		for(int i = 0; i < numberOfCards; i++) {
			int value = theHand[i].getValue();
//			System.out.println(value);   test use
			if(value != 1 && value != 11 && value != 12 && value != 13) {
				total += value;
			}
			else if(value == 11 || value == 12 || value == 13) {
				total += 10;
			}
		}
		for(int i = 0; i < numberOfCards; i++) {
			int value = theHand[i].getValue();
//			System.out.println(value);    test use
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
	
	public void addCard(Card card) {
		theHand[numberOfCards++] = card;
		//example: when we need add card to player's hand ,we could call 
		// player.get(i).getHand.get(j).addCard(Deck.getNextCard());
		//i and j are which player and player's which hand, cause player can split the hand to two hand
	}
	public Card[] getCard() {
		return theHand;
	}
	public void clearHand() {
		numberOfCards = 0;
		theHand = new Card[12];
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < numberOfCards; i++) {
			s += theHand[i].toString() +", ";
		}
		return s;
	}
	public String dealerToString(boolean hide) {
		String s = theHand[0].toString() + ", [Hide]";
		return s;
	}
}
