import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;

/**
* This class is used to generate random pack.txt files.
*
* @author 228027 & 
* @version 1.0
*/

public class Generate {
    static ArrayList<Card> cards = new ArrayList<>(); 

    public static ArrayList<Card> generate(int numberOfPlayers){
        // Generate pack based on number of players
        int maxValueGenerated = 2 * numberOfPlayers;
        for(int i = 1; i<=maxValueGenerated; i++){
            for(int j = 1; j<=4; j++){
                Card tempCard = new Card(j);
                cards.add(tempCard);
            }
        }
        Collections.shuffle(cards);
        return cards;
        
    }

    public static void writefile(String fileName, ArrayList<Card> cards) throws IOException{
        FileWriter writer = new FileWriter(fileName+".txt"); 
        for(Card card : cards) {
            writer.write(card.getValue() + System.lineSeparator());
          }
          writer.close();
    }
}
