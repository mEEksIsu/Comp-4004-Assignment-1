package poker;

import java.util.Scanner;

public class Game {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Round currentRound;
		while(true) {
			System.out.print("How many players will be playing this round? (2-4): ");
			int numPlayers = Integer.parseInt(input.nextLine());
			checkPlayerLimit(numPlayers);	
			currentRound = new Round(numPlayers);
			currentRound.play();
			System.out.print("Would you like to stop? (y/n): ");
			String response = input.nextLine(); 
			if (response.equals("y"))
				System.exit(0); 
		}

	}
	
	public static void checkPlayerLimit(int numPlayers) {
		if (numPlayers < 2 || numPlayers > 4)
			throw new IncorrectInputException();
	}

}
