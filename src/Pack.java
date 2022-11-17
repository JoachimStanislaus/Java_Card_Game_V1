import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This class is used to create packs. The pack file is provided by the user and
 * must contain 8*player cards.
 * Players are distributed 4 cards each in a round robin method from the pack at
 * the start.
 * An acceptable input pack is a txt file with each row containing a single
 * non-negative integer value and has 8*player rows.
 *
 *
 * @author 228027 & 231731
 * @version 1.0
 */
public class Pack {
    private final Card[] cards;

    /**
     * Creates a pack and it's related information
     * 
     * @param filename the filename of the pack
     * @param n        number of players
     */
    public Pack(String filename, int n) throws IOException {
        int numberOfCards = 8 * n;
        this.cards = new Card[numberOfCards];
        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int index = 0;
            String newline;
            while ((newline = reader.readLine()) != null) {
                if (index == numberOfCards) {
                    System.out.println(
                            "Too many cards. There should be " + numberOfCards + " for " + n + " number of players.");
                    System.exit(1);
                    break;
                } else {
                    Card card = new Card(Integer.parseInt(newline));
                    cards[index] = card;
                    index++;
                }
            }
            if (index < numberOfCards) {
                System.out.println(
                        "Lacking cards. There should be " + numberOfCards + " for " + n + " number of players.");
                System.exit(1);
            }
            reader.close();
        } catch (NumberFormatException e) {
            System.out.println("Pack file should only contain Integers.");
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