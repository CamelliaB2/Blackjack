//package BlackJack;

import java.util.ArrayList;

/**
 * hand in player or dealer. it will within the cards
 * @author Xu Shi
 * @version 1.0
 * @date 2021-12-11
 *
 */
public class Hand
{

	private ArrayList<Card> theHand = new ArrayList<>(); 
	private int numberOfCards;
	
	/**
	 * the constructor for the Hand
	 */
	public Hand() {
		numberOfCards = 0;
	}
	/**
	 * Calculates the total of a hand and also decides whether ace is 1 or 11
	 * @return integer for calculate the total value in this hand 
	 */
	public int calculateTotal() {
		int total =0;
		for(int i = 0; i < numberOfCards; i++) {
			int value = theHand.get(i).getValue();
//			System.out.println(value);   test use
			if(value != 1 && value != 11 && value != 12 && value != 13) {
				total += value;
			}
			else if(value == 11 || value == 12 || value == 13) {
				total += 10;
			}
		}
		for(int i = 0; i < numberOfCards; i++) {
			int value = theHand.get(i).getValue();
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
	
	/**
	 * add one card in this hand
	 * @param card the card need to add in this hand
	 */
	public void addCard(Card card) {
		theHand.add(card);
		numberOfCards++;
		//example: when we need add card to player's hand ,we could call 
		// player.get(i).getHand.get(j).addCard(Deck.getNextCard());
		//i and j are which player and player's which hand, cause player can split the hand to two hand
	}
	
	/**
	 * get the all card in this hand
	 * @return Card[] a array within all card in this hand
	 */
	public ArrayList<Card> getCard() {
		return theHand;
	}
	
	/**
	 * clear all hand
	 */
	public void clearHand() {
		numberOfCards = 0;
		theHand.removeAll(theHand);
	}
	
	/**
	 * print all card in this hand
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < numberOfCards; i++) {
			s += theHand.get(i).toString() +", ";
		}
		return s;
	}
	
	/**
	 * print the dealer's hand
	 * @param hide if need hide one card in dealer's hand
	 * @return all card suit and value in dealer's hand
	 */
	public String dealerToString(boolean hide) {
		String s = theHand.get(0).toString() + ", [Hide]";
		return s;
	}
}
