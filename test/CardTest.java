import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class CardTest {
    Card card;

    @Test
    public void testGetValue() {
        int n = (int) Math.round(Math.random() * 100);
        card = new Card(n);
        assertEquals(n, card.getValue());
    }

    @Test
    public void testToString() {
        int n = (int) Math.round(Math.random() * 100);
        card = new Card(n);
        assertEquals(Integer.toString(n), card.toString());
    }

    @After
    public void deleteOutput() {
        card = null;
    }
}
