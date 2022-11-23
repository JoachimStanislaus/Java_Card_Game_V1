import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;

/**
 * Test the game as a whole
 * 
 * @author 228027 & 231731
 * @version 1.0
 */

public class CardGameTest {

    /*
     * Generates a random pack using n which has a range of 1-101. Writes generated
     * pack to file and use it to run an instance of the game.
     * catch any exceptions
     */
    @Test
    public void testStartGame() {
        try {
            int n = (int) Math.round(Math.random() * 100) + 1;
            ArrayList<Card> packCards = Generate.generate(n);
            Generate.writefile("PackTest.txt", packCards);
            CardGame.startGame(n, "PackTest.txt");
            packCards.clear();
        } catch (Exception e) {
            System.out.println(e);
            fail("test has failed due to exception error.");
        }
    }

    /*
     * Creates a random number of player from a range of 1-101 and checks if the
     * number of players created is as expected.
     */
    @Test
    public void testCreatePlayers() {
        int n = (int) Math.round(Math.random() * 100) + 1;
        Player[] players = CardGame.createPlayers(n);
        assertTrue(players.length == n);
        // assert true check is alive
    }

    /*
     * Creates a random number of decks from a range of 1-101 and checks if the
     * number of players created is as expected.
     */
    @Test
    public void testCreateDeck() {
        int n = (int) Math.round(Math.random() * 100) + 1;
        Deck[] decks = CardGame.createDeck(n);
        assertTrue(decks.length == n);
    }

    /*
     * Created 4 players p1-p4 and give p1-p3 cards of different values whilst
     * giving p4 a winning hand
     * Check if checkWinner method works by using it to check if there is a winner
     * in players list.
     */
    @Test
    public void testCheckWinnerTrue() {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);
        Player p4 = new Player(4);
        Player[] players = { p1, p2, p3, p4 };

        for (int i = 0; i <= 4; i++) {
            p1.getHand().add(new Card(i));
            p2.getHand().add(new Card(i));
            p3.getHand().add(new Card(i));
        }
        for (int i = 0; i <= 4; i++) {
            p4.getHand().add(new Card(10));
        }
        assertTrue(CardGame.checkWinner(players));
    }

    /*
     * Created 4 players p1-p4 and give them all cards of different values
     * Check if checkWinner method works by using it to check if there is NO winner
     * in players list.
     */
    @Test
    public void testCheckWinnerFalse() {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);
        Player p4 = new Player(4);
        Player[] players = { p1, p2, p3, p4 };

        for (int i = 0; i <= 4; i++) {
            p1.getHand().add(new Card(i));
            p2.getHand().add(new Card(i));
            p3.getHand().add(new Card(i));
            p4.getHand().add(new Card(i));
        }

        assertFalse(CardGame.checkWinner(players));
    }
}
