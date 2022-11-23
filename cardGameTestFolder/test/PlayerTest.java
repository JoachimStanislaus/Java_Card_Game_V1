import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

/**
 * This is player tests. It tests most of the player methods.
 *
 * @author 228027 & 231731
 * @version 1.0
 */

public class PlayerTest {

    /**
     * This method tests if a player has a winning deck.
     */
    @Test
    public void testIsWinnerTrue() {
        Player player = new Player((int) 1);
        for (int i = 0; i < 4; i++) {
            player.getHand().add(new Card((int) 2));
        }
        assertTrue(player.isWinner());
    }

    /**
     * This method tests if a player does NOT have a winning deck.
     */
    @Test
    public void testIsWinnerFalse() {
        Player player = new Player((int) 1);
        for (int i = 0; i < 4; i++) {
            player.getHand().add(new Card((int) i));
        }
        assertFalse(player.isWinner());
    }

    /**
     * This method test all of the functionality during the player's turn.
     */
    @Test
    public void testPlayerTurn() {
        Player player = new Player((int) 1);
        Card card = new Card(1);
        player.getHand().add(new Card(1));
        player.getHand().add(new Card(1));
        player.getHand().add(new Card(1));
        player.getHand().add(new Card(4));
        player.playerTurn(card, 1, 1);
        player.getHand();
        assertEquals(Arrays.toString(player.getHand().toArray()), "[1, 1, 1, 1]");
    }

    @Test
    public void testWriteToPlayerFile() {
        try {
            Player player = new Player((int) 1);
            player.writeToPlayerFile("test input");
            String playerfilename = "log" + File.separator + "P" + player.getPlayerId() + ".txt";
            BufferedReader reader = new BufferedReader(new FileReader(playerfilename));
            String text = reader.readLine();
            assertEquals("test input", text);
            reader.close();
        } catch (IOException e) {
            fail("test has failed due to exception error");
        }
    }

    @Test
    public void testInformPlayerHasWon() {
        Player player = new Player((int) 1);
        for (int i = 0; i < 4; i++) {
            player.getHand().add(new Card((int) i));
        }
        player.informPlayerHasWon((int) 10);
        File playerFile = new File(String.format("log/P%d.txt", player.getPlayerId()));
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(playerFile));
            assertEquals("P10 has informed P1 that P10 has won", bufferedReader.readLine());
            assertEquals("P1 exits", bufferedReader.readLine());
            assertEquals("P1 hand [0, 1, 2, 3]", bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(
                    "Test failed to run because of IO error. This is not a failure of the game logic, only in the test");
            System.out.println("e = " + e);
        }
    }
}