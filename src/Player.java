import java.lang.Thread;
import java.util.ArrayList;


/**
* This class is used to create players and it's methods.
*
*
* @author 228027 & 
* @version 1.0
*/

/**
 * Player class is used to represent the players that played the game with the given playerId and card in their hand*/
public class Player extends Thread{
    private int playerId;
    private ArrayList<Card> hand;

    /**
    *creates a player and its related information
    * @param playerId the player's Id*/
    public Player(int playerId){
        this.playerId = playerId;
        this.hand = new ArrayList<>();
    }
    
    /**
    *Get the player's playerId 
    *@return the Player's Id*/
    public int getPlayerId(){
        return playerId;
    }

    /**
    *Get the player's card 
    *@return the player's card*/
    public ArrayList<Card> getCard(){
        return hand;
    }

    /**
    *Check if a player has won during its turn
    *@return return true if all 4 cards has the same value; else return false*/
    public boolean checkWin(){
        int CardInitialvalue = hand.get(0).getValue();
        for(Card card: hand){
            if(CardInitialvalue != card.getValue()){
                return false;
            }
        }
        return true;
    }




}