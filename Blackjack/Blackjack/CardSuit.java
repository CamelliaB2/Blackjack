//package BlackJack;
/**
 * enum for the card suit
 * @author Xu Shi
 * @version 1.0
 */
public enum CardSuit {
	HEART{
        @Override
        public String toString() {
            return "HEART";
        }
    },SPADE{
        @Override
        public String toString() {
            return "SPADE";
        }
    },CLUB{
        @Override
        public String toString() {
            return "CLUB";
        }
    },DIAMOND{
        @Override
        public String toString() {
            return "DIAMOND";
        }
    }
}
