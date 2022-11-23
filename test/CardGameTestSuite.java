import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This is a test suite that combines all of the tests.
 *
 * @author 228027 & 231731
 * @version 1.0
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ PlayerTest.class,
                DeckTest.class, CardGameTest.class,
                GenerateTest.class })
public class CardGameTestSuite {
}
