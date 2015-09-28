package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test(expected = IncorrectInputException.class)
	public void shouldThrowExceptionIfIncorrectNumberOfPlayers() {
		Game game = new Game(); 
		game.checkPlayerLimit(5);
	}

}
