package poker;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class CardTest {

	@Test(expected = IncorrectInputException.class)
	public void wrongCapitalizationShouldThrowException() {
		Card card = new Card("onehearts");
	}
	
	@Test(expected = IncorrectInputException.class)
	public void rankNotRecognizedShouldThrowException() {
		Card card = new Card("FivSpades");
	}
	
	@Test(expected = IncorrectInputException.class)
	public void suitNotRecognizedShouldThrowException() {
		Card card = new Card("FiveAce");
	}
	
	@Test
	public void cardSuitAndRankCorrectlyInitialized() {
		Card card = new Card("ThreeHearts");
		assertEquals("Three", card.getRank());
		assertEquals("Hearts", card.getSuit());
	}
	
	@Test
	public void cardRankValueCorrectlyInitialized() {
		Card card = new Card("QueenHearts");
		assertEquals(10, card.getRankValue());
	}


}
