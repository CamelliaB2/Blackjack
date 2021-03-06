//package BlackJack;

/**
 * player in the blackjack game
 * @author Xu Shi
 * @version 1.0
 * @date 2021-12-11
 *
 */
public class Player {
	private int bet;
	private int bank;
	private String name;
	private Hand hand;
	
	/**
	 * the constructor for the player with bank and hand
	 * set the start bank is 1000
	 */
	public Player() {
		bank = 1000;
		hand = new Hand();
	}
	
	/**
	 * another constructor for the player
	 * can set player's bank and name
	 * @param bank
	 * @param name
	 */
	public Player(int bank, String name) {
		this.setBank(bank);
		this.setName(name);
		hand = new Hand();
	}

	/**
	 * get the bank of the player
	 * @return integer of bank's money
	 */
	public int getBank() {
		return bank;
	}

	/**
	 * set the bank to which amount
	 * @param bank the amount of the bank
	 */
	public void setBank(int bank) {
		this.bank = bank;
	}

	/**
	 * get the name of the player
	 * @return String of the player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the player's name
	 * @param name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * set what if player win loss bust and blackjack the bank will change
	 */
	public void blackjack() {
		bank += bet * 1.5;
	}
	/**
	 * set what if player bust
	 */
	public void bust() {
		bank -= bet;
		bet = 0;
	}
	/**
	 * set what if player win
	 */
	public void win() {
		bank += bet;
		bet = 0;
	}
	/**
	 * set what if player loss
	 */
	public void loss() {
		bank -= bet;
		bet = 0;
	}
	/**
	 * Sets a player's bet to 0 if the "push". Notice, no bet is added or removed.
	 */
	public void push() {
		bet = 0;
	}
	
	/**
	 * Sets a player's bet
	 * @param newBet for set
	 * @return true/ false if bank has that money
	 */
	public boolean setBet(int newBet) {
		if(newBet <= bank) {
			bet = newBet;
			return true;
		}
		else {
			System.out.println("you dont have that much money more than you have, please set you bet.");
			return false;
		}
	}
	
	/**
	 * Gets a player's bet
	 * @return bet of the player
	 */
	public int getBet(){
		return this.bet;
	}
	
	/**
	 * get the player 's hand
	 * @return Hand of the player's hand
	 */
	public Hand getHand() {
		return hand;
	}
	/**
	 * Gets the player's cards to print as a string
	 * @return String of player's hand cards
	 */
	public String getHandString() {
		String str = "Player Cards:" + hand.toString();

		return str;
	}
		
	/**
	 * Clears a player's hand
	 */
	public void clearPlayerHand() {
		hand.clearHand();
	}
	
	/**
	 * This sets the player bank to -1. -1 is unreachable and they are removed from the game
	 */
	public void removeFromGame() {
		bank = -1;
	}
	
	/**
	 * This resets the bank to 0. Currently used to reset a removed player's bank from -1 to 0.
	 */
	public void resetBank() {
		bank = 0;
	}
}
