import org.junit.Test;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;

public class DeckTest {
    private Deck deck;
    private int n;
    Card[] cards;

    @Before
    public void setUp() {
        n = (int) Math.round(Math.random() * 20);
        deck = new Deck((int) 1);
        cards = new Card[n + 1];
        for (int i = 0; i <= n; i++) {
            Card card = new Card(i);
            deck.addCard(card);
            cards[i] = card;
        }
    }

    @Test
    public void testAddCard() {
        Card card = new Card(100);
        deck.addCard(card);
        assertTrue(deck.getCards().contains(card));
    }

    @Test
    public void testGetCards() {
        assertArrayEquals(deck.getCards().toArray(), cards);
    }

    @Test
    public void testPickUpCard() {
        Card card = new Card(1);
        deck = new Deck(2);
        deck.addCard(card);
        deck.addCard(new Card(2));
        deck.addCard(new Card(3));
        deck.addCard(new Card(4));
        assertEquals(deck.pickUpCard(), card);
    }

    @Test
    public void testWriteDeckToFile() { /// fix this
        try {
            Deck deck4 = new Deck(4);
            deck4.addCard(new Card(1));
            deck4.addCard(new Card(2));
            deck4.addCard(new Card(3));
            deck4.addCard(new Card(4));
            deck4.writeDeckToFile();
            File deckFile = new File("log/deck" + (deck4.getDeckId() + 1) + "_output.txt");
            BufferedReader reader = new BufferedReader(new FileReader(deckFile));
            String text = reader.readLine();
            assertEquals("deck" + (deck4.getDeckId() + 1) + " contents:  1 2 3 4", text);
            reader.close();
        } catch (IOException e) {

        }

    }

    @After
    public void deleteOutput() {
        deck = null;
        n = 0;
        cards = null;
    }

}
