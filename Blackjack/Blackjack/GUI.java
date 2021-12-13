//package BlackJack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;



import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * GUI for the blackJack
 */
public class GUI extends JFrame {
	JTextArea j = new JTextArea();
	// set window size
	int width = 1280;
	int height = 800;
	// colors
	Color background = new Color(39, 119, 20);
	Color colorButton = new Color(204, 204, 0);
	// buttons
	JButton pHit = new JButton();
	JButton pStand = new JButton();
	JButton pDouble = new JButton();
	JButton pYes = new JButton();
	JButton pNo = new JButton();
	JButton pTip = new JButton();
	JButton about = new JButton();
	JButton rules = new JButton();
	JToggleButton music = new JToggleButton();
	JButton b = new JButton();
	// game phases booleans
	boolean bool_hit_stand = true;
	boolean bool_dealer_play = false;
	boolean bool_play_more = false;
	// questions message
	String play_more_question = "Play again?";
	// list of messages
	ArrayList<Message> Log = new ArrayList<Message>();
	// fonts
	Font fontButton = new Font("Times New Roman", Font.PLAIN, 28);
	Font fontCard = new Font("Times New Roman", Font.BOLD, 20);
	Font fontQuestion = new Font("Times New Roman", Font.PLAIN, 40);
	Font fontLog = new Font("Times New Roman", Font.ITALIC, 20);
	// Log message colors
	Color cDealer = Color.red;
	Color cPlayer = Color.black;
	// card grid positioning and dimensions
	int gridX = 50;
	int gridY = 50;
	int gridW = 900;
	int gridH = 400;
	// totals and hit-stand positioning and dimensions
	int hsX = gridX + gridW + 50;
	int hsY = gridY;
	int hsW = 230;
	int hsH = 400;
	// play more question grid positioning and dimensions
	int pmX = hsX;
	int pmY = hsY + hsH + 10;
	int pmW = hsW;
	int pmH = 200;
	// card dimensions and spacing
	int cardEdgeSofting = 10;

	int cardSpacing = 10;
	int cardTW = gridW / 6;
	int cardTH = gridH / 2;
	int cardAW = cardTW - 2 * cardSpacing;
	int cardAH = cardTH - 2 * cardSpacing;
	// create deck, player and dealer
	Deck deck = new Deck(6);
	Player player = new Player();
	Dealer dealer = new Dealer();
	// polygons for diamond shapes
	int[] polyX = new int[4];
	int[] polyY = new int[4];
	//music
	String mu = ".//music//jazz.wav";
	Music m = new Music();
	String onOff = "off";
	
    //Create a class music
    public class Music
    {
    	Clip clip;
    	public void setFile(String soundFileName)
    	{
    		try
    		{
    			File file = new File(soundFileName);
    			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
    			clip = AudioSystem.getClip();
    			clip.open(sound);
    			
    		}
    		catch (Exception e)
    		{
    			
    		}
    	}
    	
    	//Plays music
    	public void play()
    	{
    		clip.setFramePosition(0);
    		clip.start();
    	}
    	
    	//Stops playing music
    	public void stop()
    	{
    		clip.stop();
    		clip.close();
    	}
    }

	public GUI() {
		this.setSize(width + 6, height + 29);
		this.setTitle("BlackJackTraining");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Board board = new Board();
		this.setContentPane(board);
		this.setLayout(null);

		ActHit hit = new ActHit();
		pHit.addActionListener(hit);
		pHit.setBounds(hsX + 55, hsY + 10, 120, 50);
		pHit.setBackground(colorButton);
		pHit.setText("HIT");
		pHit.setFont(fontButton);
		board.add(pHit);

		ActStand aStand = new ActStand();
		pStand.addActionListener(aStand);
		pStand.setBounds(hsX + 55, hsY + 100, 120, 50);
		pStand.setBackground(colorButton);
		pStand.setText("Stand");
		pStand.setFont(fontButton);
		board.add(pStand);

		ActDouble aDouble = new ActDouble();
		pDouble.addActionListener(aDouble);
		pDouble.setBounds(hsX + 55, hsY + 190, 120, 50);
		pDouble.setBackground(colorButton);
		pDouble.setText("Double");
		pDouble.setFont(fontButton);
		board.add(pDouble);

		ActYes aYes = new ActYes();
		pYes.addActionListener(aYes);
		pYes.setBounds(pmX + 10, pmY + 130, 100, 50);
		pYes.setBackground(colorButton);
		pYes.setText("YES");
		pYes.setFont(fontButton);
		board.add(pYes);

		ActNo aNo = new ActNo();
		pNo.addActionListener(aNo);
		pNo.setBounds(pmX + 120, pmY + 130, 100, 50);
		pNo.setBackground(colorButton);
		pNo.setText("NO");
		pNo.setFont(fontButton);
		board.add(pNo);

		ActTip aTip = new ActTip();
		pTip.addActionListener(aTip);
		pTip.setBounds(hsX + 55, hsY + 300, 120, 50);
		pTip.setBackground(colorButton);
		pTip.setText("Tip");
		pTip.setFont(fontButton);
		board.add(pTip);
		
		about.setBounds(800, 500, 120, 50);
		about.setBackground(colorButton);
		about.setText("About");
		about.setFont(fontButton);
		board.add(about);
		
		rules.setBounds(800, 560, 120, 50);
		rules.setBackground(colorButton);
		rules.setText("Rules");
		rules.setFont(fontButton);
		board.add(rules);
		
		music.setBounds(800, 620, 120, 50);
		music.setBackground(colorButton);
		music.setText("Music");
		music.setFont(fontButton);
		board.add(music);
		
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				About a = new About();
				a.show();
			}
			
		});
		
		rules.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Rules r = new Rules();
				r.show();
			}
			
		});
		
		music.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String clickedButton = e.getActionCommand();
				switch (clickedButton)
				{
					case "Music":
						if (onOff.equals("off")) //If the button is not clicked on yet
						{
							m.setFile(mu);
		    				m.play();
		    				onOff = "on";
						}
						else if (onOff.equals("on")) //If the button has been clicked already
						{
							m.stop();
							onOff = "off";
						}
				}
			}
			
		});
	}
	


	/**
	 * Deals the cards to the players and dealer
	 */
	public void dealCards() {
		for (int j = 0; j < 2; j++) {
			if (player.getBank() > 0) {
				player.getHand().addCard(deck.getNextCard());

			}
			dealer.getHand().addCard(deck.getNextCard());

		}
	}

	/**
	 * refresh the data
	 */
	public void refresher() {
		// button visibility checker
		if (bool_hit_stand == true) {
			pHit.setVisible(true);
			pStand.setVisible(true);
			pDouble.setVisible(true);
			pYes.setVisible(true);
			pNo.setVisible(true);
		} else if (bool_dealer_play == true) {
			pHit.setVisible(false);
			pStand.setVisible(false);
			pDouble.setVisible(false);
			pYes.setVisible(true);
			pNo.setVisible(true);
		} else if (bool_play_more == true) {
			pHit.setVisible(false);
			pStand.setVisible(false);
			pDouble.setVisible(false);
			pYes.setVisible(true);
			pNo.setVisible(true);
		}

		repaint();
	}

	/**
	 * Board for the blackjack
	 */
	public class Board extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(background);
			g.fillRect(0, 0, width, height);

			// temporary grid painting
			g.setColor(Color.black);
			g.drawRect(gridX, gridY, gridW, gridH);
			// temporary log borders painting
			g.drawRect(gridX, gridY + gridH + 10, gridW, 500);
			// temporary total and button grid
			g.drawRect(hsX, hsY, hsW, hsH);
			// temporary play more grid
			g.drawRect(pmX, pmY, pmW, pmH);
			g.setFont(fontQuestion);
			g.drawString(play_more_question, pmX + 25, pmY + 60);
			// temporary card grid
			for (int i = 0; i < 6; i++) {
				g.drawRect(gridX + i * cardTW + cardSpacing, gridY + cardSpacing, cardAW, cardAH);
				g.drawRect(gridX + i * cardTW + cardSpacing, gridY + cardSpacing + cardTH, cardAW, cardAH);
			}

			// draw player card
			int i = 0;
			for (Card c : player.getHand().getCard()) {
				g.setColor(Color.white);
				g.fillRect(gridX + i * cardTW + cardSpacing, gridY + cardSpacing, cardAW, cardAH);
				g.setColor(Color.black);
				if (c.getSuit().toString().equals("HEART") || c.getSuit().toString().equals("DIAMOND")) {
					g.setColor(Color.red);
				}
				g.setFont(fontCard);
				g.drawString(c.toString(), gridX + i * cardTW + cardSpacing, gridY + cardSpacing + cardAH);

				if (c.getSuit().toString().equals("Hearts")) {
					g.fillOval(gridX + cardTW * i + 42, gridY + 70, 35, 35);
					g.fillOval(gridX + cardTW * i + 73, gridY + 70, 35, 35);
					g.fillArc(gridX + cardTW * i + 30, gridY + 90, 90, 90, 51, 78);
				} else if (c.getSuit().toString().equals("DIAMOND")) {
					polyX[0] = gridX + cardTW * i + 75;
					polyX[1] = gridX + cardTW * i + 50;
					polyX[2] = gridX + cardTW * i + 75;
					polyX[3] = gridX + cardTW * i + 100;
					polyY[0] = gridY + 60;
					polyY[1] = gridY + 100;
					polyY[2] = gridY + 140;
					polyY[3] = gridY + 100;
					g.fillPolygon(polyX, polyY, 4);
				} else if (c.getSuit().toString().equals("SPADE")) {
					g.fillOval(gridX + cardTW * i + 42, gridY + 90, 35, 35);
					g.fillOval(gridX + cardTW * i + 73, gridY + 90, 35, 35);
					g.fillArc(gridX + cardTW * i + 30, gridY + 15, 90, 90, 51 + 180, 78);
					g.fillRect(gridX + cardTW * i + 70, gridY + 100, 10, 40);
				} else {
					g.fillOval(gridX + cardTW * i + 40, gridY + 90, 35, 35);
					g.fillOval(gridX + cardTW * i + 75, gridY + 90, 35, 35);
					g.fillOval(gridX + cardTW * i + 58, gridY + 62, 35, 35);
					g.fillRect(gridX + cardTW * i + 70, gridY + 75, 10, 70);
				}
				i++;
			}

			// only draw the not hide dealer card
			Card showDealerCard = dealer.getHand().getCard().get(0);
			g.setColor(Color.white);
			g.fillRect(gridX + cardSpacing, gridY + cardSpacing + cardTH, cardAW, cardAH);
			g.setColor(Color.black);
			g.fillRect(gridX + cardSpacing + cardTW, gridY + cardSpacing + cardTH, cardAW, cardAH);

			g.setColor(Color.black);
			if (showDealerCard.getSuit().toString().equals("HEART")
					|| showDealerCard.getSuit().toString().equals("DIAMOND")) {
				g.setColor(Color.red);
			}
			g.setFont(fontCard);
			g.drawString(showDealerCard.toString(), gridX + cardSpacing, gridY + cardSpacing + cardTH + 180);
			if (showDealerCard.getSuit().toString().equals("Hearts")) {
				g.fillOval(gridX + 42, gridY + 70 + cardTH, 35, 35);
				g.fillOval(gridX + 73, gridY + 70 + cardTH, 35, 35);
				g.fillArc(gridX + 30, gridY + 90 + cardTH, 90, 90, 51, 78);
			} else if (showDealerCard.getSuit().toString().equals("DIAMOND")) {
				polyX[0] = gridX + 75;
				polyX[1] = gridX + 50;
				polyX[2] = gridX + 75;
				polyX[3] = gridX + 100;
				polyY[0] = gridY + 60 + cardTH;
				polyY[1] = gridY + 100 + cardTH;
				polyY[2] = gridY + 140 + cardTH;
				polyY[3] = gridY + 100 + cardTH;
				g.fillPolygon(polyX, polyY, 4);
			} else if (showDealerCard.getSuit().toString().equals("SPADE")) {
				g.fillOval(gridX + 42, gridY + 90 + cardTH, 35, 35);
				g.fillOval(gridX + 73, gridY + 90 + cardTH, 35, 35);
				g.fillArc(gridX + 30, gridY + 15 + cardTH, 90, 90, 51 + 180, 78);
				g.fillRect(gridX + 70, gridY + 100 + cardTH, 10, 40);
			} else {
				g.fillOval(gridX + 40, gridY + 90 + cardTH, 35, 35);
				g.fillOval(gridX + 75, gridY + 90 + cardTH, 35, 35);
				g.fillOval(gridX + 58, gridY + 62 + cardTH, 35, 35);
				g.fillRect(gridX + 70, gridY + 75 + cardTH, 10, 70);
			}
			// draw dealer card
			if (bool_dealer_play == true) {
				i = 0;
				for (Card c : dealer.getHand().getCard()) {
					g.setColor(Color.white);
					g.fillRect(gridX + i * cardTW + cardSpacing, gridY + cardSpacing + cardTH, cardAW, cardAH);
					g.setColor(Color.black);
					if (c.getSuit().toString().equals("HEART") || c.getSuit().toString().equals("DIAMOND")) {
						g.setColor(Color.red);
					}
					g.setFont(fontCard);
					g.drawString(c.toString(), gridX + i * cardTW + cardSpacing, gridY + cardSpacing + cardAH + cardTH);

					if (c.getSuit().toString().equals("Hearts")) {
						g.fillOval(gridX + cardTW * i + 42, gridY + 70 + cardTH, 35, 35);
						g.fillOval(gridX + cardTW * i + 73, gridY + 70 + cardTH, 35, 35);
						g.fillArc(gridX + cardTW * i + 30, gridY + 90 + cardTH, 90, 90, 51, 78);
					} else if (c.getSuit().toString().equals("DIAMOND")) {
						polyX[0] = gridX + cardTW * i + 75;
						polyX[1] = gridX + cardTW * i + 50;
						polyX[2] = gridX + cardTW * i + 75;
						polyX[3] = gridX + cardTW * i + 100;
						polyY[0] = gridY + 60 + cardTH;
						polyY[1] = gridY + 100 + cardTH;
						polyY[2] = gridY + 140 + cardTH;
						polyY[3] = gridY + 100 + cardTH;
						g.fillPolygon(polyX, polyY, 4);
					} else if (c.getSuit().toString().equals("SPADE")) {
						g.fillOval(gridX + cardTW * i + 42, gridY + 90 + cardTH, 35, 35);
						g.fillOval(gridX + cardTW * i + 73, gridY + 90 + cardTH, 35, 35);
						g.fillArc(gridX + cardTW * i + 30, gridY + 15 + cardTH, 90, 90, 51 + 180, 78);
						g.fillRect(gridX + cardTW * i + 70, gridY + 100 + cardTH, 10, 40);
					} else {
						g.fillOval(gridX + cardTW * i + 40, gridY + 90 + cardTH, 35, 35);
						g.fillOval(gridX + cardTW * i + 75, gridY + 90 + cardTH, 35, 35);
						g.fillOval(gridX + cardTW * i + 58, gridY + 62 + cardTH, 35, 35);
						g.fillRect(gridX + cardTW * i + 70, gridY + 75 + cardTH, 10, 70);
					}
					i++;
				}
			}
			// draw player hand total value
			g.setColor(Color.white);
			g.fillRect(1090, 300, 50, 50);
			g.setColor(Color.black);
			g.drawString("value:", 1020, 330);
			g.drawString(String.valueOf(player.getHand().calculateTotal()), 1100, 330);
			//how many percent will bust
			g.setColor(Color.white);
			g.fillRect(1090, 400, 50, 50);
			g.setColor(Color.black);
			double percent = (21 - (double)player.getHand().calculateTotal())/13;
			g.drawString(Double.toString(percent), 1100, 430);
			g.drawString("busting:", 1020, 430);
			// Log"
			g.setFont(fontLog);
			int logIndex = 0;
			for (Message L : Log) {
				if (L.getWho().equalsIgnoreCase("Dealer")) {
					g.setColor(cDealer);
				} else {
					g.setColor(cPlayer);
				}
				g.drawString(L.getMessage(), gridX + 20, gridY + 480 + logIndex * 35);
				logIndex++;
			}
			
		}

	}

	/**
	 * Code for the dealer to play
	 */
	public void dealerPlays() {

		System.out.println("Dealer has " + dealer.getHand().calculateTotal());
		String mess = "Dealer has " + dealer.getHand().calculateTotal();
		Log.add(new Message(mess, "Player"));
		while (dealer.getHand().calculateTotal() <= 16) {
			System.out.println("Dealer hits");
			mess = "Dealer hits";
			Log.add(new Message(mess, "Player"));
			dealer.getHand().addCard(deck.getNextCard());
			System.out.println("Dealer " + dealer.getHand().toString());
			mess = "Dealer " + dealer.getHand().toString();
			Log.add(new Message(mess, "Player"));
		}
		if (dealer.getHand().calculateTotal() > 21) {
			System.out.println("Dealer busts. ");
			mess = "Dealer busts. ";
			Log.add(new Message(mess, "Player"));
		} else {
			System.out.println("Dealer stands. Dealer final have:" + dealer.getHand().calculateTotal());
			mess = "Dealer stands. Dealer final have:" + dealer.getHand().calculateTotal();
			Log.add(new Message(mess, "Player"));
		}
	}

	/**
	 * This code calculates all possible outcomes and adds or removes the player
	 * bets
	 */
	public void settleBets() {
		// check who wins and sent massage to the text board
		String mess = "";
		if (player.getHand().calculateTotal() > 21) {
			System.out.println("player has busted");
			mess = "player has busted";
		} else if (player.getHand().calculateTotal() == dealer.calculateTotal()) {
			System.out.println("player has pushed");
			mess = "player has pushed";
		} else if (player.getHand().calculateTotal() < dealer.calculateTotal() && dealer.calculateTotal() <= 21) {
			System.out.println("player has lost");
			mess = "player has lost";
		} else if (player.getHand().calculateTotal() == 21) {
			System.out.println("player has won with blackjack!");
			mess = "player has won with blackjack!";
		} else {
			System.out.println("player has won");
			mess = "player has won";
		}
		Log.add(new Message(mess, "Player"));
	}

	/**
	 * Code for the play strategy, will tell player what the next move should be.
	 * 
	 * @param i       player number
	 * @param showtip on/off for the tip
	 */
	public String playStrategy() {
		String s = "";
		Hand playerHand = player.getHand();
		Hand dealerHand = dealer.getHand();
		int total = playerHand.calculateTotal();
		Card dealerCard = dealerHand.getCard().get(0);
		ArrayList<Card> playerCard = playerHand.getCard();
		Card anotherCard;
		// if there are 2 card in player hand, else is for more than 2 cards
		if (playerHand.getCard().size() == 2) {
			// if player have an ace in hand
			if (playerHand.getCard().get(0).getValue() == 1 || playerHand.getCard().get(1).getValue() == 1) {
				if (playerCard.get(0).getValue() == 1) {
					anotherCard = playerCard.get(1);
				} else {
					anotherCard = playerCard.get(0);
				}
				if (anotherCard.getValue() == 2) {
					if (dealerCard.getValue() == 5 || dealerCard.getValue() == 6) {
						s = "total is 13, you should double!";
						System.out.println("total is 13, you should double!");
					} else {
						s = "total is 13, you should hit!";
						System.out.println("total is 13, you should hit!");
					}
				}
				if (anotherCard.getValue() == 3) {
					if (dealerCard.getValue() == 5 || dealerCard.getValue() == 6) {
						s = "total is 14, you should double!";
						System.out.println("total is 14, you should double!");
					} else {
						s = "total is 14, you should double!";
						System.out.println("total is 14, you should hit!");
					}
				}
				if (anotherCard.getValue() == 4) {
					if (dealerCard.getValue() == 4 || dealerCard.getValue() == 5 || dealerCard.getValue() == 6) {
						s = "total is 15, you should double!";
						System.out.println("total is 15, you should double!");
					} else {
						s = "total is 15, you should hit!";
						System.out.println("total is 15, you should hit!");
					}
				}
				if (anotherCard.getValue() == 5) {
					if (dealerCard.getValue() == 4 || dealerCard.getValue() == 5 || dealerCard.getValue() == 6) {
						s = "total is 16, you should double!";
						System.out.println("total is 16, you should double!");
					} else {
						s = "total is 16, you should hit!";
						System.out.println("total is 16, you should hit!");
					}
				}
				if (anotherCard.getValue() == 6) {
					if (dealerCard.getValue() == 3 || dealerCard.getValue() == 4 || dealerCard.getValue() == 5
							|| dealerCard.getValue() == 6) {
						s = "total is 17, you should double!";
						System.out.println("total is 17, you should double!");
					} else {
						s = "total is 17, you should hit!";
						System.out.println("total is 17, you should hit!");
					}
				}
				if (anotherCard.getValue() == 7) {
					if (dealerCard.getValue() == 7 || dealerCard.getValue() == 8) {
						s = "total is 18, you should stand!";
						System.out.println("total is 18, you should stand!");
					} else if (dealerCard.getValue() == 9 || dealerCard.getValue() == 10
							|| dealerCard.getValue() == 1) {
						s = "total is 18, you should hit!";
						System.out.println("total is 18, you should stand!");
					} else {
						s = "total is 18, you should double!";
						System.out.println("total is 18, you should double!");
					}
				}
				if (anotherCard.getValue() == 8) {
					if (dealerCard.getValue() == 6) {
						s = "total is 19, you should double!";
						System.out.println("total is 19, you should double!");
					} else {
						s = "total is 19, you should stand!";
						System.out.println("total is 19, you should stand!");
					}
				}
				if (anotherCard.getValue() == 9) {
					s = "total is 20, you should stand!";
					System.out.println("total is 20, you should stand!");
				}
			}
		}
		// if player have more than two cards
		else {
			if (total == 8) {
				s = "total is 8, you should hit!";
				System.out.println("total is 8, you should hit!");
			}
			if (total == 9) {
				if ((dealerCard.getValue() >= 1 && dealerCard.getValue() <= 2)
						|| (dealerCard.getValue() >= 7 && dealerCard.getValue() <= 10)) {
					s = "total is 9, you should hit!";
					System.out.println("total is 9, you should hit!");
				} else {
					s = "total is 9, you should double!";
					System.out.println("total is 9, you should double!");
				}
			}
			if (total == 10) {
				if ((dealerCard.getValue() >= 1 && dealerCard.getValue() <= 9) || dealerCard.getValue() == 10) {
					s = "total is 10, you should hit!";
					System.out.println("total is 10, you should hit!");
				} else {
					s = "total is 10, you should double!";
					System.out.println("total is 10, you should double!");
				}
			}
			if (total == 11) {
				s = "total is 11, you should double!";
				System.out.println("total is 11, you should double!");
			}
			if (total == 12) {
				if ((dealerCard.getValue() >= 1 && dealerCard.getValue() <= 3)
						|| (dealerCard.getValue() >= 7 && dealerCard.getValue() <= 10)) {
					s = "total is 12, you should hit!";
					System.out.println("total is 12, you should hit!");
				} else {
					s = "total is 12, you should stand!";
					System.out.println("total is 12, you should stand!");
				}
			}
			if (total == 13) {
				if ((dealerCard.getValue() >= 7 && dealerCard.getValue() <= 10) || dealerCard.getValue() == 1) {
					s = "total is 13, you should hit!";
					System.out.println("total is 13, you should hit!");
				} else {
					s = "total is 13, you should stand!";
					System.out.println("total is 13, you should stand!");
				}
			}
			if (total == 14) {
				if ((dealerCard.getValue() >= 7 && dealerCard.getValue() <= 10) || dealerCard.getValue() == 1) {
					s = "total is 14, you should hit!";
					System.out.println("total is 14, you should hit!");
				} else {
					s = "total is 14, you should stand!";
					System.out.println("total is 14, you should stand!");
				}
			}
			if (total == 15) {
				if ((dealerCard.getValue() >= 7 && dealerCard.getValue() <= 10) || dealerCard.getValue() == 1) {
					s = "total is 15, you should hit!";
					System.out.println("total is 15, you should hit!");
				} else {
					s = "total is 15, you should stand!";
					System.out.println("total is 15, you should stand!");
				}
			}
			if (total == 16) {
				if ((dealerCard.getValue() >= 7 && dealerCard.getValue() <= 10) || dealerCard.getValue() == 1) {
					s = "total is 16, you should hit!";
					System.out.println("total is 16, you should hit!");
				} else {
					s = "total is 16, you should stand!";
					System.out.println("total is 16, you should stand!");
				}
			}
			if (total == 17) {
				s = "total is 17, you should stand!";
				System.out.println("total is 17, you should stand!");
			}
			if (total == 18) {
				s = "total is 18, you should stand!";
				System.out.println("total is 18, you should stand!");
			}
			if (total == 19) {
				s = "total is 19, you should stand!";
				System.out.println("total is 19, you should stand!");
			}
			if (total == 20) {
				s = "total is 20, you should stand!";
				System.out.println("total is 20, you should stand!");
			}
			if (total == 21) {
				s = "total is 21, you should stand!";
				System.out.println("total is 21, you should stand!");
			}
		}
		return s;
	}

	public class ActTip implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// set tips if there have one to the text board
			String mess = playStrategy();
			Log.add(new Message(mess, "Player"));
		}

	}

	public class ActHit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// player hit
			String mess = "You decided to hit!";
			Log.add(new Message(mess, "Player"));
			if (player.getHand().calculateTotal() < 21) {
				player.getHand().addCard(deck.getNextCard());
			}
			if (player.getHand().calculateTotal() > 21) {
				bool_hit_stand = false;
				bool_dealer_play = true;
				dealerPlays();
			}
		}

	}

	public class ActStand implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// player stand
			String mess = "You decided to Stand!";
			Log.add(new Message(mess, "Player"));
			bool_hit_stand = false;
			bool_dealer_play = true;
			dealerPlays();
			bool_play_more = true;
			settleBets();
		}

	}

	public class ActDouble implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// player double
			String mess = "You decided to Double!";
			Log.add(new Message(mess, "Player"));
			bool_hit_stand = false;
			player.getHand().addCard(deck.getNextCard());
			bool_dealer_play = true;
			dealerPlays();
			bool_play_more = true;
			settleBets();
		}

	}

	public class ActYes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println("You clicked 'YES'");
			//player choose keep play
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			Log.clear();

			bool_play_more = false;
			bool_hit_stand = true;
			bool_dealer_play = false;
			dealCards();

		}

	}

	public class ActNo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println("You clicked 'NO'");
			//player choose exit
			dispose();
		}

	}

}
