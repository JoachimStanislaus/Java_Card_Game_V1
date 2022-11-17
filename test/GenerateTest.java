import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Test;

public class GenerateTest {
    ArrayList<Card> packCards;
    int n;

    // @Before
    // public void setUp() {
    // // to clear pack
    // int n = (int) Math.round(Math.random() * 20) + 1;
    // packCards = Generate.generate(n);
    // packCards.clear();

    // }

    @Test
    public void testGenerate() {
        int n = (int) Math.round(Math.random() * 20) + 1;
        packCards = Generate.generate(n);
        assertEquals(packCards.size(), (n * 8));
    }

    @Test
    public void testWritefile() {
        try {
            int n = (int) Math.round(Math.random() * 20) + 1;
            packCards = Generate.generate(n);
            Generate.writefile("test.txt", packCards);
            Pack pack = new Pack("test.txt", n);
            assertEquals(Arrays.toString(packCards.toArray()), Arrays.toString(pack.getCards()));
        } catch (IOException e) {
        }

    }

    @After
    public void deleteOutput() {
        packCards.clear();
        n = 0;
    }
}
