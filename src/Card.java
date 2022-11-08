/**
* This class is used to initialise the new card object and for methods to return objects.
*
* @author 228027 & 
* @version 1.0
*/

public class Card {
    // Each card has a face value of a non-negative integer
    private final int value;

    /**
    *This method creates a card
    *
    *@param value the value of card in integer*/
    public Card(int value) {
        this.value = value;
    }

    /**
    *Get the value of the card 
    *@return the value of the card*/
    public int getValue() {
        return value;
    }

    
    @Override
    public String toString() {
        return "" + value;
    }
}