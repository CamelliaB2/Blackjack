package Blackjack;

public class Player {
	private int bet;
	private int bank;
	private String name;
	private Hand hand;
	
	public Player() {
		bank = 100000;
		hand = new Hand();
	}
	public Player(int bank, String name) {
		this.setBank(bank);
		this.setName(name);
		hand = new Hand();
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// set what if player win loss bust and blackjack the bank will change
	public void blackjack() {
		bank += bet * 1.5;
	}
	public void bust() {
		bank -= bet;
		bet = 0;
	}
	public void win() {
		bank += bet;
		bet = 0;
	}
	public void loss() {
		bank -= bet;
		bet = 0;
	}
	// Sets a player's bet to 0 if the "push". Notice, no bet is added or removed.
	public void push() {
		bet = 0;
	}
	
	// Sets a player's bet
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
	
	// Gets a player's bet
	public int getBet(){
		return this.bet;
	}
	//get the player 's hand
	public Hand getHand() {
		return hand;
	}
	// Gets the player's cards to print as a string
	public String getHandString() {
		String str = "Player Cards:" + hand.toString();

		return str;
	}
		
	// Clears a player's hand
	public void clearPlayerHand() {
		hand.clearHand();
	}
	
	// This sets the player bank to -1. -1 is unreachable and they are removed from the game
	public void removeFromGame() {
		bank = -1;
	}
	
	// This resets the bank to 0. Currently used to reset a removed player's bank from -1 to 0.
	public void resetBank() {
		bank = 0;
	}
}
