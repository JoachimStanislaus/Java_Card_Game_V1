import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * This is a deck class containing deck attributes and it's methods.
 *
 * @author 228027 & 231731
 * @version 1.0
 */
public class Deck {
    private final int deckId;
    private ArrayList<Card> cards;

    /**
     * A method to create a deck
     * 
     * @param deckId the deck's deckId
     */
    public Deck(int deckId) {
        this.deckId = deckId;
        this.cards = new ArrayList<>();
    }

    /**
     * This method gets the card from the top of the deck and remove the card
     * 
     * @return the card on the top of the deck
     */
    public Card pickUpCard() {
        Card topCard = cards.get(0);
        cards.remove(0);
        return topCard;
    }

    /**
     * This method add's a card to the deck.
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * This method return the cards in a deck
     * 
     * @return the cards in a deck
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * This method writes the contents of the decks into a file
     */
    public void writeDeckToFile() throws IOException {
        String path = "log" + File.separator + "deck" + (deckId + 1) + "_output.txt";
        StringBuilder output = new StringBuilder("deck" + (deckId + 1) + " contents: ");
        for (Card card : cards) {
            if (card != null)
                output.append(" ").append(card.getValue());
        }
        File f = new File(path);

        f.getParentFile().mkdirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        if (!f.createNewFile()) {
            writer.write("");
        }
        // writer = new BufferedWriter(new FileWriter(path, true));
        writer.write(output.toString());
        writer.newLine();
        writer.close();
    }

    @Override
    public String toString() {
        return "deck" + deckId + ": " + cards.toString();
    }

    /**
     * This method gets the deckId of a deck
     * 
     * @return deckId the deckId of a deck
     */
    public int getDeckId() {
        return deckId;
    }
}
