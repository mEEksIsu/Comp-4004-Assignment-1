package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void playerIDShouldIncrementAutomatically() {
		Player player1 = new Player();
		Player player2 = new Player();
		
		assertEquals(1, player1.getID());
		assertEquals(2, player2.getID());
	}

}
