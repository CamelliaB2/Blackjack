
public class Dealer {
	private Hand hand;
	private boolean hide;

	public Dealer() {
		hand = new Hand();
		hide = true;
	}
	// Determines if dealer has a blackjack
	public boolean isBlackjack(){
		if (hand.calculateTotal() == 21){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getHide() {
		return hide;
	}
	
	public Hand getHand() {
		return hand;
	}

	// Calculates the dealer's hand total
	public int calculateTotal() {
		return hand.calculateTotal();
	}
	
	// Clears the dealer's hand
	public void clearDealerHand() {
		hand.clearHand();
	}
	
	public String getHandString(boolean hide) {
		String str = "";
		if(hide) {
			str = "Dealer Cards:" + hand.dealerToString(hide);
		}
		else {
			str = "Dealer Cards:" + hand.toString();
		}

		return str;
	}
	
}
