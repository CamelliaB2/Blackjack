//package BlackJack;
/**
 * dealer, one of the character in the blackjack game
 * @author Xu Shi
 * @version 1.0
 * @date 2021-12-11
 *
 */
public class Dealer {
	private Hand hand;
	private boolean hide;

	/**
	 * the constructor for the Dealer
	 */
	public Dealer() {
		hand = new Hand();
		hide = true;
	}
	/**
	 * Determines if dealer has a blackjack
	 * @return true/ false for is this hand is a blackjack
	 */
	public boolean isBlackjack(){
		if (hand.calculateTotal() == 21){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * card should hide or shown
	 * @return true/false does card need hide
	 */
	public boolean getHide() {
		return hide;
	}
	/**
	 * get the hand form dealer
	 * @return hand of the dealer
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * Calculates the dealer's hand total
	 * @return integer of the total value of dealer's hand
	 */
	public int calculateTotal() {
		return hand.calculateTotal();
	}
	
	/**
	 * Clears the dealer's hand
	 */
	public void clearDealerHand() {
		hand.clearHand();
	}
	
	/**
	 * print the dealer's hand
	 * @param hide does dealer's hand need hide or all shown
	 * @return string for the dealer's hand
	 */
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
