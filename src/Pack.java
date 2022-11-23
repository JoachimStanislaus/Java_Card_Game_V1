import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This is a pack class containing pack attributes and its methods.
 *
 * @author 228027 & 231731
 * @version 1.0
 */
public class Pack {
    private final Card[] cards;

    /**
     * Creates a pack and it's related information.
     * To create a pack, the file must contain exactly 8*n cards; where n is the
     * number of players.
     * 
     * @param filename the filename of the pack
     * @param n        number of players
     * @throws InvalidNumberOfCardsException
     */
    public Pack(String filename, int n) throws IOException, InvalidNumberOfCardsException {
        int numberOfCards = 8 * n;
        this.cards = new Card[numberOfCards];
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int index = 0;
        String newline;
        while ((newline = reader.readLine()) != null) {
            if (index == numberOfCards) {
                throw new InvalidNumberOfCardsException(
                        "Too many cards. There should be " + numberOfCards + " for " + n + " number of players.");
            } else {
                Card card = new Card(Integer.parseInt(newline));
                cards[index] = card;
                index++;
            }
        }
        if (index < numberOfCards) {
            throw new InvalidNumberOfCardsException(
                    "Lacking cards. There should be " + numberOfCards + " for " + n + " number of players.");
        }
    }

    /**
     * This method get's the cards in the pack
     * 
     * @return the cards in a pack
     */
    public Card[] getCards() {
        return cards;
    }

}