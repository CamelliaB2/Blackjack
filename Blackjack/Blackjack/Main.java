//package BlackJack;

public class Main implements Runnable{

	static GUI gui = new GUI();
	public static void main(String[] args) {
		new Thread(new Main()).start();
		gui.dealCards();
	}
	@Override
	public void run() {
		while(true) {
			gui.refresher();
			gui.repaint();
		}
	}

}
