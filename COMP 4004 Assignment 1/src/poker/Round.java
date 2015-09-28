package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Round {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	public ArrayList<String> playerHandStrings = new ArrayList<String>();
	
	private int numberOfPlayers;
	
	Scanner input = new Scanner(System.in);
	
	public Round(int numPlayers) {
		numberOfPlayers = numPlayers;
		Player.currentID = 1;
		for (int i = 0; i < numberOfPlayers; ++i)
			players.add(new Player());
	}
	
	public void play() {
		requestPlayerHands();
		generatePlayerHands();
		rankPlayers();
	}
	
	public void requestPlayerHands() {
		for (int i = 0; i < numberOfPlayers; ++i) {
			System.out.print("Enter player ID followed by each card in player's hand (separated by spaces): ");
			playerHandStrings.add(input.nextLine());
		}
	}
	
	public void generatePlayerHands() {
		for (String s: playerHandStrings) {
			String[] splitString = s.split(" ");
			int playerID = Integer.parseInt(splitString[0]);
			Hand newHand = new Hand(); 
			for (int i = 1; i < splitString.length; ++i) {
				newHand.addCard(splitString[i]);
			}
			players.get(playerID-1).setHand(newHand);
		}
	}
	
	public void rankPlayers() {
		Collections.sort(players);
		int rank = 0;
		int lastScore = 0;
		for (Player player: players) {		
			if (lastScore != player.getHand().calculateScore()) {
				rank++;
				lastScore = player.getHand().calculateScore();
			}
			player.rank = rank;
			System.out.println("Rank " + rank + ": Player " + player.getID());
		}
	
	}
	
	public void addHandString(String s) {
		playerHandStrings.add(s);
	}
	
	public int getNumberOfPlayers() {
		return players.size();
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	
	
}
