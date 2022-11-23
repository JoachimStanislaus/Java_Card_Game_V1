import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is a generate class is used to generate a new pack files.
 *
 * @author 228027 & 231731
 * @version 1.0
 */

public class Generate {
    static ArrayList<Card> cards = new ArrayList<>();

    /**
     * This method generates a pack of cards based on the number of players
     * 
     * @return cards returns a randomised arrayList of cards.
     */
    public static ArrayList<Card> generate(int numberOfPlayers) {
        // Generate pack based on number of players
        int maxValueGenerated = 2 * numberOfPlayers;
        for (int i = 1; i <= maxValueGenerated; i++) {
            for (int j = 1; j <= 4; j++) {
                Card tempCard = new Card(i);
                cards.add(tempCard);
            }
        }
        Collections.shuffle(cards);
        return cards;

    }

    /**
     * This method writes an arrayList of cards to the pack file.
     */
    public static void writefile(String fileName, ArrayList<Card> cards) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (Card card : cards) {
            writer.write(card.getValue() + System.lineSeparator());
        }
        writer.close();
    }
}
