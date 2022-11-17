import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class PackTest {
    Pack pack;
    ArrayList<Card> packOfCards;

    @Before
    public void setUp() throws Exception {
        int n = (int) Math.round(Math.random() * 20) + 1;
        packOfCards = Generate.generate(n);
        Generate.writefile("testpack.txt", packOfCards);
        this.pack = new Pack("testpack.txt", n);
    }

    @Test
    public void testGetCards() {
        assertEquals(Arrays.toString(packOfCards.toArray()), Arrays.toString(pack.getCards()));
    }

    @After
    public void deleteOutput() {
        pack = null;
        packOfCards.clear();
    }
}
