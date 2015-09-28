package poker;

import java.util.Arrays;

public class Card {

		private final String[] RANKS = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
		                       "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		
		private final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
		
		private String rank;
		private String suit; 
		private int rankValue;
		private int suitValue;
		
		public Card(String cardString) {
			String[] splitString = cardString.split("(?<=.)(?=\\p{Lu})");

			if (splitString.length != 2) {
				throw new IncorrectInputException();
			}
			String r = splitString[0];
			String s = splitString[1];
			
			if (!Arrays.asList(RANKS).contains(r)) { 
				throw new IncorrectInputException();
			}
			
			else if (!Arrays.asList(SUITS).contains(s)) { 
				throw new IncorrectInputException();
			}
			
			else {
				rank = r;
				suit = s;
				
				for (int i = 0; i < RANKS.length; ++i) {	
					if (RANKS[i].equals(rank)) {
						rankValue = i; 
						break;
					}
				}
				
				for (int i = 0; i < SUITS.length; ++i) {	
					if (SUITS[i].equals(suit)) {
						suitValue = i; 
						break;
					}
				}
			}
		}

		public String getRank() {
			return rank;
		}
		
		public String getSuit() {
			return suit;
		}

		public int getRankValue() {
			return rankValue;
		}
		
		public int getSuitValue() {
			return suitValue;
		}
		
		public String toString() {
			return rank + suit; 
		}
		
		
}
