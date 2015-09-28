package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void handShouldBeEmpty() {
		Hand hand = new Hand(); 
		assertEquals(0, hand.size());
	}
	
	@Test
	public void addingInvalidCardHandShouldBeEmpty() {
		Hand hand = new Hand(); 
		hand.addCard("fOurClUbs");
		assertEquals(0, hand.size());
	}
	
	@Test
	public void handShouldContainThreeCards() {
		Hand hand = new Hand(); 
		
		hand.addCard("TwoSpades");
		hand.addCard("ThreeHearts");
		hand.addCard("JackDiamonds");
		
		assertEquals(3, hand.size());
	}
	
	@Test
	public void ifNotFullHandShouldScoreZero() {
		Hand hand = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("FiveSpades");
		hand.addCard("EightHearts");
		
		assertEquals(0, hand.calculateScore());
	}
	
	@Test
	public void noHandShouldScoreHighestCard() {
		Hand hand = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("FiveSpades");
		hand.addCard("EightHearts");
		hand.addCard("JackDiamonds");
		hand.addCard("QueenClubs");
		
		
		assertEquals(10, hand.calculateScore());
	}
	
	@Test
	public void pairShouldBeatNoHand() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("FiveSpades");
		hand.addCard("EightHearts");
		hand.addCard("JackDiamonds");
		hand.addCard("KingClubs");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("EightHearts");
		hand2.addCard("JackDiamonds");
		hand2.addCard("QueenClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highPairShouldBeatLowPair() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("EightHearts");
		hand.addCard("JackDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("AceSpades");
		hand2.addCard("AceHearts");
		hand2.addCard("EightHearts");
		hand2.addCard("JackDiamonds");
		hand2.addCard("QueenClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highKickerShouldWinTiePair() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("EightHearts");
		hand.addCard("JackDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("EightHearts");
		hand2.addCard("JackDiamonds");
		hand2.addCard("KingClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void twoPairShouldBeatOnePair() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("AceSpades");
		hand.addCard("AceDiamonds");
		hand.addCard("EightHearts");
		hand.addCard("JackDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("ThreeHearts");
		hand2.addCard("ThreeDiamonds");
		hand2.addCard("QueenClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highTwoPairShouldBeatLowTwoPair() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("ThreeHearts");
		hand.addCard("ThreeDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("FourHearts");
		hand2.addCard("FourDiamonds");
		hand2.addCard("QueenClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void threeKindShouldBeatTwoPair() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("ThreeHearts");
		hand.addCard("ThreeDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("TwoDiamonds");
		hand2.addCard("FourDiamonds");
		hand2.addCard("QueenClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highThreeKindShouldBeatLowThreeKind() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("TwoHearts");
		hand.addCard("ThreeDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("TenSpades");
		hand2.addCard("TenHearts");
		hand2.addCard("TenDiamonds");
		hand2.addCard("FourDiamonds");
		hand2.addCard("QueenClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void straightShouldBeatThreeKind() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("JackSpades");
		hand.addCard("JackDiamonds");
		hand.addCard("JackHearts");
		hand.addCard("ThreeDiamonds");
		hand.addCard("QueenClubs");
		
		hand2.addCard("TenSpades");
		hand2.addCard("JackHearts");
		hand2.addCard("QueenHearts");
		hand2.addCard("KingDiamonds");
		hand2.addCard("AceClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highStraightShouldBeatLowStraight() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("AceSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("ThreeHearts");
		hand.addCard("FourDiamonds");
		hand.addCard("FiveClubs");
		
		hand2.addCard("TenSpades");
		hand2.addCard("JackHearts");
		hand2.addCard("QueenHearts");
		hand2.addCard("KingDiamonds");
		hand2.addCard("AceClubs");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void flushShouldBeatStraight() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("AceSpades");
		hand.addCard("TwoDiamonds");
		hand.addCard("ThreeHearts");
		hand.addCard("FourDiamonds");
		hand.addCard("FiveClubs");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("FiveSpades");
		hand2.addCard("SixSpades");
		hand2.addCard("EightSpades");
		hand2.addCard("TenSpades");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void fullHouseShouldBeatFlush() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("FiveSpades");
		hand.addCard("SixSpades");
		hand.addCard("EightSpades");
		hand.addCard("TenSpades");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("FiveSpades");
		hand2.addCard("FiveHearts");
		hand2.addCard("FiveDiamonds");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highFullHouseShouldBeatLowFullHouse() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("ThreeSpades");
		hand.addCard("ThreeHearts");
		hand.addCard("FourHearts");
		hand.addCard("FourClubs");
		hand.addCard("FourDiamonds");
		
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("FiveSpades");
		hand2.addCard("FiveHearts");
		hand2.addCard("FiveDiamonds");
		
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void fourKindShouldBeatFullHouse() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("ThreeSpades");
		hand.addCard("ThreeHearts");
		hand.addCard("FourHearts");
		hand.addCard("FourClubs");
		hand.addCard("FourDiamonds");
				
		hand2.addCard("TwoSpades");
		hand2.addCard("TwoHearts");
		hand2.addCard("TwoClubs");
		hand2.addCard("TwoDiamonds");
		hand2.addCard("FiveDiamonds");
			
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void highFourKindShouldBeatLowFourKind() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoHearts");
		hand.addCard("TwoClubs");
		hand.addCard("TwoDiamonds");
		hand.addCard("JackDiamonds");
				
		hand2.addCard("TwoSpades");
		hand2.addCard("FiveHearts");
		hand2.addCard("FiveClubs");
		hand2.addCard("FiveDiamonds");
		hand2.addCard("FiveSpades");
			
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void straightFlushShouldBeatFourKind() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("TwoSpades");
		hand.addCard("TwoHearts");
		hand.addCard("TwoClubs");
		hand.addCard("TwoDiamonds");
		hand.addCard("JackDiamonds");
				
		hand2.addCard("AceSpades");
		hand2.addCard("TwoSpades");
		hand2.addCard("ThreeSpades");
		hand2.addCard("FourSpades");
		hand2.addCard("FiveSpades");
			
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}
	
	@Test
	public void royalFlushShouldBeatStraightFlush() {
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		
		hand.addCard("AceSpades");
		hand.addCard("TwoSpades");
		hand.addCard("ThreeSpades");
		hand.addCard("FourSpades");
		hand.addCard("FiveSpades");
				
		hand2.addCard("TenSpades");
		hand2.addCard("JackSpades");
		hand2.addCard("QueenSpades");
		hand2.addCard("KingSpades");
		hand2.addCard("AceSpades");
			
		assertTrue(hand2.calculateScore() > hand.calculateScore());
	}

}
