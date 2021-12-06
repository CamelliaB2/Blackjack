package Blackjack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class BlackJackGame {
	private Scanner ki = new Scanner(System.in);
	//private String users; 
	private String names;
	private int user;
	private Player[] players;
	private Deck deck;
	private Dealer dealer = new Dealer();
	JFrame frame;
	Container c;
	JButton okay;
	JPanel startPanel;
	JPanel mainText;
	JPanel numPanel;
	Color color = new Color(51, 102, 0);
	String intro = "Rules: \r\n"
			+"-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.\r\n" + 
			"-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.\r\n" + 
			"-The players cards are added up for their total.\r\n" + 
			"-Players Hit to gain another card from the deck. Players Stand to keep their current card total.\r\n" + 
			"-Dealer Hits until they equal or exceed 17.\r\n" + 
			"-The goal is to have a higher card total than the dealer without going over 21.\r\n" + 
			"-If the player total equals the dealer total, it is a Push and the hand ends.\r\n" + 
			"-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get Blackjack which is 21.";
	Font font = new Font("Times New Roman", Font.PLAIN, 18);
	String getNum;
	JTextArea ta;
	JTextArea num;
	int i;
	int j;
	String a;
	JTextField n;
	JButton start;
	
	JPanel p;
	JLabel l;
	
	JButton back;
	JPanel backPanel;
	JPanel betPanel;
	JLabel betLabel;
	JTextArea betText;
	
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	
//	JTextArea p1;
//	JTextArea p2;
//	JTextArea p3;
//	JTextArea p4;
//	JTextArea p5;
//	JTextArea p6;
	JPanel player;
	
	
	public BlackJackGame()
	{
		frame = new JFrame();
		frame.setSize(895, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(color);
		frame.setLayout(null);
		frame.setVisible(true);
		c = frame.getContentPane();
		
		mainText = new JPanel();
		mainText.setBounds(50, 50, 600, 200);
		mainText.setBackground(color);
		frame.add(mainText);
		
		
		
		startPanel = new JPanel();
		startPanel.setBounds(300, 400, 200, 100);
		startPanel.setBackground(color);
		c.add(startPanel);
	}

	// Starts game and displays the rules
	public void initializeGame() {
		
		//String names;
		ta = new JTextArea(intro);
		ta.setBounds(100, 100, 600, 100);
		ta.setBackground(color);
		ta.setForeground(Color.white);
		ta.setFont(font);
		ta.setLineWrap(true);
		ta.setEditable(false);
		ta.setWrapStyleWord(true);
		mainText.add(ta);
		
		//one.start();
		
		p = new JPanel();
		l = new JLabel();
		p.setBounds(50, 300, 500, 100);
		p.setBackground(color);
		c.add(p);
		
		num = new JTextArea("How many players are playing?");
		num.setBounds(100, 300, 150, 100);
		num.setBackground(color);
		num.setForeground(Color.white);
		num.setFont(font);
		num.setLineWrap(true);
		num.setWrapStyleWord(true);
		num.setEditable(false);
		p.add(num);
		
		numPanel = new JPanel();
		numPanel.setBounds(300, 400, 200, 100);
		numPanel.setBackground(color);
		p.add(numPanel);
		
		one = new JButton("One");
		one.setBounds(100, 100, 100, 100);
		one.setBackground(Color.black);
		one.setForeground(Color.white);
		one.setFont(font);
		numPanel.add(one);
		
		two = new JButton("Two");
		two.setBounds(100, 200, 100, 100);
		two.setBackground(Color.black);
		two.setForeground(Color.white);
		two.setFont(font);
		numPanel.add(two);
		
		three = new JButton("Three");
		three.setBounds(100, 300, 100, 100);
		three.setBackground(Color.black);
		three.setForeground(Color.white);
		three.setFont(font);
		numPanel.add(three);
		
		four = new JButton("Four");
		four.setBounds(100, 400, 100, 100);
		four.setBackground(Color.black);
		four.setForeground(Color.white);
		four.setFont(font);
		numPanel.add(four);
		
		five = new JButton("Five");
		five.setBounds(100, 500, 100, 100);
		five.setBackground(Color.black);
		five.setForeground(Color.white);
		five.setFont(font);
		numPanel.add(five);
		
		six = new JButton("Six");
		six.setBounds(100, 100, 100, 100);
		six.setBackground(Color.black);
		six.setForeground(Color.white);
		six.setFont(font);
		numPanel.add(six);
		
		deck = new Deck(6);
		
		
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				user = 1;
				playerNames();
			}
		});
		
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				user = 2;
				playerNames();
			}
			
		});
		
		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				user = 3;
				playerNames();
			}
			
		});
		
		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				user = 4;
				playerNames();
				
			}
			
		});
		
		five.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				user = 5;
				playerNames();
			}
			
		});
		
		six.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				user = 6;
				playerNames();
			}
			
		});
		
		
		
		
		
		
		// Gets the amount of players and creates them
//		do {
//			System.out.print("How many people are playing (1-6)? ");
//			users = ki.nextInt();
//			if(users > 6) {
//				System.out.println("One table max is 6 people.");
//			}
			
//
//		} while (users > 6 || users < 0);
//
		
//
//		// Asks for player names and assigns them
//		for (int i = 0; i < user; i++) {
//			System.out.print("What is player " + (i + 1) + "'s name? ");
//			names = ki.next();
//			players[i] = new Player();
//			players[i].setName(names);
//		}
	}
	
	// Shuffles the deck
	public void shuffle() {
		deck.mixCards(10);
		
	}

	// Gets the bets from the players
	public void getBets(){
//		mainText.setVisible(false);
//		startPanel.setVisible(false);
//		p.setVisible(false);
//		
//		betPanel = new JPanel();
//		betPanel.setBounds(100, 100, 600, 200);
//		betPanel.setBackground(Color.black);
//		c.add(betPanel);
//		
//		betText = new JTextArea("How much do you want to bet?");
//		betText.setBounds(100, 300, 150, 100);
//		betText.setBackground(color);
//		betText.setForeground(Color.white);
//		betText.setFont(new Font("Times New Roman", Font.PLAIN, 30));
//		betText.setLineWrap(true);
//		betText.setWrapStyleWord(true);
//		betText.setEditable(false);
//		betPanel.add(betText);
//		
//		backPanel = new JPanel();
//		backPanel.setBounds(0, 0, 200, 100);
//		backPanel.setBackground(color);
//		c.add(backPanel);
//		
//		back = new JButton("Go Back");
//		back.setBounds(100, 100, 100, 100);
//		back.setBackground(Color.black);
//		back.setForeground(Color.white);
//		back.setFont(font);
//		backPanel.add(back);
//		
//		back.addActionListener(new ActionListener() 
//		{
//			@Override
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				initializeGame();
//			}
//		});
//		
//		
		int betValue;
		
		for (int i = 0; i < user; i++) {  	
			if (players[i].getBank() > 0) {
				do {
					System.out.print("How much do you want to bet " + players[i].getName()  + (" (1-" + players[i].getBank()) + ")? " );
					betValue = ki.nextInt();
					players[i].setBet(betValue);
				} while (!( betValue > 0 && betValue <= players[i].getBank()));
				System.out.println("");
			}

		}

	}
	
	public void playerNames()
	{
		mainText.setVisible(false);
		startPanel.setVisible(false);
		p.setVisible(false);
		JTextArea a = new JTextArea("Type in a name and press 'Okay' after each name");
		a.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		player = new JPanel();
		player.setBounds(0, 0, 500, 500);
		player.setBackground(color);
		a.setBackground(color);
		a.setForeground(Color.white);
		a.setBounds(100, 200, 100, 100);
		//player.setLayout(new GridLayout(6,1));
		c.add(player);
		player.add(a);
		
		JPanel j = new JPanel();
		j.setBounds(500, 500, 100, 100);
		j.setBackground(Color.black);
		c.add(j);
		
		
		JButton b = new JButton("Go back");
		b.setBounds(500, 500, 500, 500);
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		b.setFont(font);
		player.add(b);
		
		for (int i = 0; i < user; i++) {
			//System.out.print("What is player " + (i + 1) + "'s name? ");
//			JTextArea p = new JTextArea("What is player " + (i + 1) + "'s name? ");
//			p.setFont(new Font("Times New Roman", Font.PLAIN, 23));
//			p.setBackground(color);
//			p.setForeground(Color.white);
//			p.setBounds(100, 200, 100, 300);
//			player.add(p);
//			
//			JTextField t = new JTextField(20);
//			player.add(t);
			
			//names = p.getText();
			players[i] = new Player();
			//players[i].setName(names);
		}
}
	
	
	
	// Deals the cards to the players and dealer
	public void dealCards(){
		for (int j = 0; j < 2; j++) {
			for (int i =0; i < user; i++) {
				if(players[i].getBank() > 0)
				{
					players[i].getHand().addCard(deck.getNextCard());
				}
			}
			dealer.getHand().addCard(deck.getNextCard());
		}
	}
	

	// Initial check for dealer or player Blackjack
	public void checkBlackjack(){
		//System.out.println();

		if (dealer.isBlackjack() ) {
			System.out.println("Dealer has BlackJack!");
			for (int i =0; i < user; i++) {
				if (players[i].getHand().calculateTotal() == 21 ) {
					System.out.println(players[i].getName() + " pushes");
					players[i].push();
				} else {
					System.out.println(players[i].getName() + " loses");
					players[i].bust();
				}	
			}
		} else {
			for (int i =0; i < user; i++) {
				if (players[i].getHand().calculateTotal() == 21 ) {
					System.out.println(players[i].getName() + " has blackjack!");
					players[i].blackjack();
				}
			}
		}		
	}
	
	// This code takes the user commands to hit or stand
	public void hitOrStand() {
		String command;
		char c;
		for (int i = 0; i < user; i++) {
			if ( players[i].getBet() > 0 ) {
				System.out.println();
				System.out.println(players[i].getName() + " has " + players[i].getHandString());

				do {
					do {
						System.out.print(players[i].getName() + " [H]it or [S]tand? ");
						command = ki.next();
						c = command.toUpperCase().charAt(0);
					} while ( ! ( c == 'H' || c == 'S' ) );
					if ( c == 'H' ) {
						players[i].getHand().addCard(deck.getNextCard());
						System.out.println(players[i].getName() + " has " + players[i].getHandString());
					}
				} while (c != 'S' && players[i].getHand().calculateTotal() <= 21 );
			}
		}
	}
	
	// Code for the dealer to play
	public void dealerPlays() {
		boolean isSomePlayerStillInTheGame = false;
		for (int i = 0; i < user && isSomePlayerStillInTheGame == false; i++){
			if (players[i].getBet() > 0 && players[i].getHand().calculateTotal() <= 21 ) {
				isSomePlayerStillInTheGame = true;
			}
		}
		if (isSomePlayerStillInTheGame) {

			System.out.println("Dealer has " + dealer.getHand().calculateTotal());
			while (dealer.getHand().calculateTotal() <= 16) {
				System.out.println("Dealer has " + dealer.getHand().calculateTotal()+ " and hits");
				
				dealer.getHand().addCard(deck.getNextCard());
				System.out.println("Dealer " + dealer.getHand().toString());
			} 
			if ( dealer.getHand().calculateTotal() > 21) {
				System.out.println("Dealer busts. " + dealer.getHand().toString());
			} else {
				System.out.println("Dealer stands. " + dealer.getHand().toString());
			}
		}
	}
	// This code calculates all possible outcomes and adds or removes the player bets
	public void settleBets() {
		System.out.println();

		for (int i = 0; i < user; i++) {
			if (players[i].getBet() > 0 ) {
				if( players[i].getHand().calculateTotal() > 21 ) {
					System.out.println(players[i].getName() + " has busted");
					players[i].bust();
				} else if ( players[i].getHand().calculateTotal() == dealer.calculateTotal() ) {
					System.out.println(players[i].getName() + " has pushed");
					players[i].push();
				} else if ( players[i].getHand().calculateTotal() < dealer.calculateTotal() && dealer.calculateTotal() <= 21 ) {
					System.out.println(players[i].getName() + " has lost");
					players[i].loss();
				} else if (players[i].getHand().calculateTotal() == 21) {
					System.out.println(players[i].getName() + " has won with blackjack!");
					players[i].blackjack();
				} else {
					System.out.println(players[i].getName() + " has won");
					players[i].win();
					
				}
			}
		}

	}

	// This prints the players hands
	public void printStatus() {
		for (int i = 0; i < user; i++) {
			if(players[i].getBank() > 0)
			{
				System.out.println(players[i].getName() + " has " + players[i].getHandString());
			}
		}
		System.out.println("Dealer has " + dealer.getHandString(true));
	}
	
	// This prints the players banks and tells the player if s/he is out of the game
	public void printMoney() {
		for (int i = 0; i < user; i++) {
			if(players[i].getBank() > 0)
			{
				System.out.println(players[i].getName() + " has $" + players[i].getBank());
			}
			if(players[i].getBank() == 0)
			{
				System.out.println(players[i].getName() + " has $" + players[i].getBank() + " and is out of the game.");
				players[i].removeFromGame();
			}
		}
	}

	// This code resets all hands
	public void clearHands() {
		for (int i = 0; i < user; i++) {
			players[i].getHand().clearHand();
		}
		dealer.getHand().clearHand();

	}
	
	// This decides to force the game to end when all players lose or lets players choose to keep playing or not
	public boolean playAgain() {
		String command;
		char c;
		Boolean playState = true;
		if(forceEnd()) {
			playState = false;	
		}
		else {
			do {
				System.out.println("");
				System.out.print("Do you want to play again (Y)es or (N)o? ");
				command = ki.next();
				c = command.toUpperCase().charAt(0);
			} while ( ! ( c == 'Y' || c == 'N' ) );
			if(c == 'N')
			{
				playState = false;
			}
		}
		return playState;
	}
	
	// This says true or false to forcing the game to end
	public boolean forceEnd() {
		boolean end = false;
		int endCount = 0;
		
		for (int i = 0; i < user; i++) {
			if(players[i].getBank() == -1)
			{
				endCount++;
			}
		}
		if(endCount == user)
		{
			end = true;
		}
		if(end)
		{
			System.out.println("");
			System.out.println("All players have lost and the game ends.");
		}
		
		return end;
	}
	
	// This is the end game code for when all players are out of the game or players decide to stop playing
	public void endGame() {
		int endAmount;
		String endState = " no change.";
		System.out.println("");
		for (int i = 0; i < user; i++) {
			if(players[i].getBank() == -1)
			{
				players[i].resetBank();
			}
			endAmount = players[i].getBank() - 100;
			if(endAmount > 0)
			{
				endState = " gain of ";
			}
			else if(endAmount < 0)
			{
				endState = " loss of ";
			}
			System.out.println(players[i].getName() + " has ended the game with " + players[i].getBank() + ".");
			if(endState != " no change.")
			{
			System.out.println("A" + endState + Math.abs(endAmount) + ".");
			}
			else
			{
			System.out.println("No change from their starting value.");	
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Thank you for playing!");
	}
	
//	Timer one = new Timer(5, new ActionListener(){
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			char[] character = intro.toCharArray();
//			int arrayNum = character.length;
//			
//			String s = String.valueOf(character[i]);
//			ta.append(s);
//			
//			i++;
//			
//			if (i == arrayNum)
//			{
//				i = 0;
//				one.stop();
//			}
//			
//			
//		}
//	});
//	
//	Timer two = new Timer(10, new ActionListener(){
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			char[] character = getNum.toCharArray();
//			int arrayNum = character.length;
//			
//			String s = String.valueOf(character[i]);
//			ta.append(s);
//			
//			j++;
//			
//			if (j == arrayNum)
//			{
//				j = 0;
//				two.stop();
//			}
//			
//			
//		}
//	});
}
