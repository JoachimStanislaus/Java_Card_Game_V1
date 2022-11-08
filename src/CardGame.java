import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
* This class is used to initialise player threads and controls the logic of the game; distributes cards to players & informing the threads when someone has won.
*
* @author 228027 & 
* @version 1.0
*/

public class CardGame {
    
    public static void main(String[] args){
        try {
            // Request input from the user. 
            System.out.println("Enter the number of players in the game: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int playerNum = Integer.parseInt(in.readLine());
            System.out.println("Enter the filename for a pack of cards: ");
            String filename = in.readLine();
            
            //startGame(playerNum, filename);

        } catch (IOException e) {
            System.out.println("exception: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid(int) number of players");
        }
    }

    public static void startGame(int n, String filename) throws IOException {
        Pack pack = new Pack(filename, n);
        Deck[] decks = new Deck[n];
        Card[] cardsInPack = pack.getCards();
        Player[] players = new Player[n];
        
        for (int i = 0; i <= n; i++) {
            players[i] = new Player(i);
            // Creating thread because Player extends Thread.
            players[i].start(); // start each player thread
            decks[i] = new Deck(i);
        }
        // Distribute the cards to players.
        for (int i = 0; i < 4 * n; i++) {
            players[i % n].getCard().add(cardsInPack[i]);
        }
        // Distribute the cards to decks.
        for (int i = 4 * n; i < 8 * n; i++) {
            decks[i % n].addCard(cardsInPack[i]);
        }

        boolean isWinner = false;

        // this checks if any player has won immediately before the game starts
        for (Player player : players) {
            if (player.checkWin()) {
                System.out.println("Player " + player.getPlayerId() + " has won the game");
                isWinner = true;
            }
        }
        int winner = -1;
        int turns = 0;
        while (!isWinner){
            int playersTurn = turns++ % n;
            int discardToDeck = (playersTurn + 1) % n;
            int pickUpFromDeck = playersTurn;

            // synchronized block used for thread safety
            synchronized (players[playersTurn]) {
                /* The below print statement shows which thread each player runs in */
//                System.out.printf("player %d is running on %s%n", playersTurn + 1, players[playersTurn].getName());

                decks[discardToDeck].discardCard(
                        players[playersTurn].takeTurn(
                                decks[pickUpFromDeck].pickUpCard(), discardToDeck, pickUpFromDeck)
                );
            }

            // checks if player has won at the end of every turn
            if (players[playersTurn].checkWin()) {
                isWinner = true;
                winner = players[playersTurn].getPlayerId();
            }
        }

        // Procedure for when there is a winner.
        // Inform all players of winner.
        // Inform decks of end of game.
        for (short i = 0; i < n; i++) {
            synchronized (players[i]) {
                players[i].informPlayerHasWon(winner);
            }
            decks[i].writeContentsToFile();
        }       
    }
}

