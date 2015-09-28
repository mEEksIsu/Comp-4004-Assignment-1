package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {

	@Test
	public void initializeCorrectNumberOfPlayers() {
		Round round = new Round(4);
		assertEquals(4, round.getNumberOfPlayers());
	}
	
	@Test
	public void shouldParseStringsAndGeneratePlayerHands() {
		Round round = new Round(2);
		round.addHandString("2 AceSpades FiveHearts SixClubs FourDiamonds AceHearts");
		round.addHandString("1 EightClubs NineHearts TenSpades JackDiamonds QueenClubs");
		round.generatePlayerHands(); 
		assertEquals("EightClubs NineHearts TenSpades JackDiamonds QueenClubs ", round.getPlayer(0).getHand().toString());
		assertEquals("AceSpades FiveHearts SixClubs FourDiamonds AceHearts ", round.getPlayer(1).getHand().toString());
	}
	
	@Test(expected = IncorrectInputException.class)
	public void shouldThrowExceptionIfCardIsDuplicate() {
		Round round = new Round(2);
		round.addHandString("2 AceSpades FiveHearts SixClubs FourDiamonds AceHearts");
		round.addHandString("1 AceSpades NineHearts TenSpades JackDiamonds QueenClubs");
		round.generatePlayerHands(); 
	}
	
	@Test(expected = IncorrectInputException.class)
	public void shouldThrowExceptionIfHandHasWrongNumberOfCards() {
		Round round = new Round(2);
		round.addHandString("2 AceDiamonds FiveHearts SixClubs FourDiamonds AceHearts");
		round.addHandString("1 AceSpades NineHearts TenSpades JackDiamonds");
		round.generatePlayerHands(); 
	}
	
	@Test(expected = IncorrectInputException.class)
	public void shouldThrowExceptionIfCardIsInvalid() {
		Round round = new Round(2);
		round.addHandString("2 AfeSfoe FiveHearts SixClubs FourDiamonds AceHearts");
		round.addHandString("1 AceSpades NineHearts TenSpades JackDiamonds");
		round.generatePlayerHands(); 
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfIDComesLater() {
		Round round = new Round(2);
		round.addHandString("AceDiamonds FiveHearts 2 SixClubs FourDiamonds AceHearts");
		round.addHandString("1 AceSpades NineHearts TenSpades JackDiamonds");
		round.generatePlayerHands(); 
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfIDIsInvalid() {
		Round round = new Round(2);
		round.addHandString("3 AceDiamonds FiveHearts SixClubs FourDiamonds AceHearts");
		round.addHandString("1 AceSpades NineHearts TenSpades JackDiamonds");
		round.generatePlayerHands(); 
	}
	
	@Test
	public void shouldGenerateCorrectScoresForHands() {
		Round round = new Round(2);
		round.addHandString("2 AceSpades FiveHearts SixClubs FourDiamonds AceHearts");
		round.addHandString("1 EightClubs NineHearts TenSpades JackDiamonds QueenClubs");
		round.generatePlayerHands(); 
		assertEquals(410000, round.getPlayer(0).getHand().calculateScore());
		assertEquals(101204, round.getPlayer(1).getHand().calculateScore());
	}
	
	@Test
	public void shouldCorrectlyRankPlayers() {
		Round round = new Round(4);
		round.addHandString("2 AceSpades FiveHearts SixClubs FourDiamonds TwoHearts");
		round.addHandString("1 EightClubs NineHearts TenSpades JackDiamonds QueenClubs");
		round.addHandString("3 EightHearts NineClubs TenDiamonds JackClubs QueenHearts");
		round.addHandString("4 EightDiamonds EightSpades TwoSpades JackSpades QueenSpades");
		round.generatePlayerHands(); 
		round.rankPlayers();
		assertEquals(1, round.getPlayer(0).getID());
		assertEquals(3, round.getPlayer(1).getID());
		assertEquals(4, round.getPlayer(2).getID());
		assertEquals(2, round.getPlayer(3).getID());
	}


}
