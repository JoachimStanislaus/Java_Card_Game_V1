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
        Generate.writefile("packtest.txt", packOfCards);
        this.pack = new Pack("packtest.txt", n);
    }

    @Test
    public void testGetCards() {
        // System.out.println("sf" + Arrays.toString(pack.getCards()));
        // System.out.println("wqeff" + Arrays.toString(packOfCards.toArray()));
        // assertEquals(Arrays.toString(packOfCards.toArray()),
        // Arrays.toString(pack.getCards()));
        assert (Arrays.toString(packOfCards.toArray()).equals(Arrays.toString(pack.getCards())));

    }

    @After
    public void deleteOutput() {
        pack = null;
        packOfCards.clear();
    }
}
