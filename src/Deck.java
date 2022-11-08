import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
* This class initialises the Deck and it's methods.
*
* @author 228027 & 
* @version 1.0
*/
public class Deck {
    private final int deckId;
    private int cards;
    private ArrayList<Card> hand;


    /**
    *A method to create a deck
    *@param deckId the deck's deckId */
    public Deck(int deckId) {
        this.deckId = deckId;
        this.hand = new ArrayList<>();
        this.cards = 0;
    }


    /**
    *This method gets the card from the top of the deck
    *@return the card on the top of the deck*/
    public Card pickUpCard() {
        Card onTop =  this.hand.get(0);   //this.hand[0];
        ArrayList<Card> newHand = new ArrayList<>();
        System.arraycopy(this.hand, 1, newHand, 0, 4);
        this.hand = newHand;
        return onTop;
    }

    /**
    *This method discards the card  */
    public void discardCard(Card card) {
        // Is the array index empty (null) before adding card

        //if (this.hand.get(3) == null) this.hand.get(3) = card;
        //else this.hand.get(4) = card;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    
}
