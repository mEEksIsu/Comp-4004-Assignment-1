package poker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CardTest.class, GameTest.class, HandTest.class, PlayerTest.class, RoundTest.class })
public class AllTests {

}
