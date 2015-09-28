package poker;

public class Player implements Comparable<Player>{
	public static int currentID = 1;
	private int id; 
	private Hand hand;
	public int rank;
	
	public Player() {
		id = currentID;
		currentID++; 
		rank = 0;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public int getID() {
		return id;
	}

	public Hand getHand() {
		return hand;
	}

	@Override
	public int compareTo(Player p) {
		return p.getHand().calculateScore() - hand.calculateScore();
	}
	
}
