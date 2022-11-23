/**
 * This class is a card object
 *
 * @author 228027 & 231731
 * @version 1.0
 */

public class Card {
    // Each card has a face value of a non-negative integer
    private final int value;

    /**
     * This method creates a card
     * 
     * @param value value of card in integer
     */
    public Card(int value) {
        this.value = value;
    }

    /**
     * Get the value of the card
     * 
     * @return the value of the card as an int
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the value of the card
     * 
     * @return the value of the card as a string
     */
    @Override
    public String toString() {
        return "" + value;
    }
}