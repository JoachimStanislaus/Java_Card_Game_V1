import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Test the game as a whole
 * 
 * @author 228027 & 231731
 * @version 1.0
 */

public class CardGameTest {

    @Test
    public void testStartGame() {
        // Create a sample text file for testing
        try {
            int n = (int) Math.round(Math.random() * 20) + 1;
            ArrayList<Card> packCards = Generate.generate(n);
            Generate.writefile("PackTest.txt", packCards);
            CardGame.startGame(n, "PackTest.txt");
            // packCards.clear();
        } catch (IOException e) {
            fail("test has failed due to exception error.");
        }
    }
}
