package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Hand {
	
	private ArrayList<Card> cards;
	private int score; 
	
	public Hand() {
		cards = new ArrayList<Card>();
		score = 0;
	}
	
	public void addCard(String cardString) {
		Card card; 
		try {
			card = new Card(cardString);
		}
		catch (IncorrectInputException e) {
			System.out.println("Invalid card input!");
			card = null;
		}
		
		if (card != null) 
			cards.add(card);
	}
	
	public int calculateScore() {
		if (size() < 5)
			return 0;
		
		int valueTally[] = new int[13];
		int suitTally[] = new int[4];
		
		for (Card c: cards) {
			valueTally[c.getRankValue()]++;
			suitTally[c.getSuitValue()]++;
		}
		
		int score = 0;
		int highestKickerValue = 0; 
		int pair1 = -1, pair2 = -1, threeKind = -1, fourKind = -1, straight = -1, flush = -1;
			
		for (int i = 12; i >= 0; --i) {
			if (valueTally[i] == 4) {
				fourKind = i;
				break;
			}
			else if (valueTally[i] == 3) {
				threeKind = i; 
			}
			else if (valueTally[i] == 2) {
				if (pair1 == -1)
					pair1 = i;
				else
					pair2 = i;
			}
			else if (valueTally[i] == 1) {
				if (highestKickerValue < i)
					highestKickerValue = i;
			}
		} 
		
		for (int i = 0; i < 9; ++i) {
			if (valueTally[i] == 1 && valueTally[i+1] == 1 && valueTally[i+2] == 1 && valueTally[i+3] == 1 && valueTally[i+4] == 1) {
				straight = i+4; 
			}
		}
		
		if (valueTally[12] == 1 && valueTally[0] == 1 && valueTally[1] == 1 && valueTally[2] == 1 && valueTally[3] == 1) {
			straight = 5; 
		}
		
		for (int i = 0; i < 4; ++i) {
			if (suitTally[i] == 5) {
				flush = 1;
				break;
			}
		}
		
		if (flush >= 0 && straight >= 0)
			score = 800000 + (straight * 1000);
		else if (fourKind >= 0) 
			score = 700000 + (fourKind * 1000) + highestKickerValue;
		else if (threeKind >= 0 && pair1 >= 0)
			score = 600000 + (threeKind * 1000) + (pair1 * 100);
		else if (flush >= 0) 
			score = 500000 + highestKickerValue;
		else if (straight >= 0)
			score = 400000 + (straight * 1000);
		else if (threeKind >= 0)
			score = 300000 + (threeKind * 1000) + highestKickerValue;
		else if (pair2 >= 0 && pair1 >= 0)
			score = 200000 + (pair2 * 1000) + (pair1 * 100) + highestKickerValue;
		else if (pair1 >= 0)
			score = 100000 + (pair1 * 100) + highestKickerValue;	
		else
			score = highestKickerValue;
		
		return score;
		
	}
	
	public int size() { return cards.size(); }
	public int getScore() { return score; }
	public String toString() {
		String s = "";
		for (Card c: cards)
			s += c.toString() + " ";
		return s;
	}
}
