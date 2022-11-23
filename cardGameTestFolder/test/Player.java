import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used to create players and it's methods.
 *
 *
 * @author 228027 & 231731
 * @version 1.0
 */
public class Player extends Thread {
    private int playerId;
    private ArrayList<Card> hand;
    private final String path;

    /**
     * creates a player and its related information
     * 
     * @param playerId the player's Id
     */
    public Player(int playerId) {
        this.playerId = playerId;
        this.hand = new ArrayList<>();
        this.path = "log" + File.separator + "P" + this.playerId + ".txt";
        try {
            File f = new File(this.path);
            f.getParentFile().mkdirs();
            if (!f.createNewFile()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                writer.write("");
            }
        } catch (IOException e) {
            System.out.printf("Failed to create player output file for player %d", playerId);
        }
    }

    /**
     * Get the player's playerId
     * 
     * @return the Player's Id
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Get the player's card
     * 
     * @return the player's card
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Check if a player has won during its turn
     * 
     * @return return true if all 4 cards has the same value; else return false
     */
    public boolean isWinner() {
        int CardInitialvalue = hand.get(0).getValue();
        for (Card card : hand) {
            if (CardInitialvalue != card.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * playerTurn method handles all of the player actions when it is there turn in
     * the game.
     *
     * @param pickUp        the card picked up from the deck on players left
     * @param discardDeckNo the deckNo to discard the card
     * @param pickUpDeckNo  the deckNo to pick up the card
     * @return card put down (discarded) by player.
     */
    public Card playerTurn(Card pickUp, int discardDeckNo, int pickUpDeckNo) {
        boolean isSame = true;
        Random random = new Random();
        Card currentCard = pickUp;
        int randIndex;

        while (isSame) {
            randIndex = random.nextInt(4);
            currentCard = hand.get(randIndex);
            if (currentCard.getValue() != playerId) {
                isSame = false;
            }
        }
        // increment drawing and discard deck numbers
        pickUpDeckNo++;
        discardDeckNo++;

        hand.remove(hand.indexOf(currentCard));
        hand.add(pickUp);

        writeToPlayerFile("Player " + this.playerId + " draws " + pickUp.getValue() + " from deck " + pickUpDeckNo);
        writeToPlayerFile(
                "Player " + this.playerId + " discards " + currentCard.getValue() + " to deck " + discardDeckNo);
        writeToPlayerFile("Player " + this.playerId + " current hand " + getHand().toString());

        return currentCard;
    }

    /**
     * This method writes contents to a player file.
     * 
     * @param output the contents that we want to write to a player file.
     */
    public void writeToPlayerFile(String output) {
        // open, write to, and close players file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(output);
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.printf("Could not find the file for player %d at %s%n", playerId, path);
        } catch (IOException e) {
            System.out.printf("Error writing to player%d file (%s)%n", playerId, path);
        }
    }

    /**
     * This method informs other players that the player has won.
     * 
     * @param playerId the playerId of the player.
     */
    public void informPlayerHasWon(int playerId) {
        StringBuilder winOutput = new StringBuilder();
        // check if player number is self
        if (playerId == this.playerId) {
            winOutput.append("P").append(playerId).append(" wins");
        } else {
            winOutput.append("P").append(playerId).append(" has informed P")
                    .append(this.playerId).append(" that P").append(playerId).append(" has won");
        }
        writeToPlayerFile(winOutput.toString());
        writeToPlayerFile("P" + this.playerId + " exits");

        StringBuilder handOutput = new StringBuilder("P").append(this.playerId).append(' ');
        if (playerId == this.playerId) {
            handOutput.append("final ");
        }
        handOutput.append("hand ").append(hand.toString());
        writeToPlayerFile(handOutput.toString());

    }

    @Override
    public String toString() {
        return "deck" + playerId + ": " + hand.toString();
    }

}