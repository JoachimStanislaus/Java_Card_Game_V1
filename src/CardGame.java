import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This is the main CardGame class used to run the game's logic and initialise
 * objects.
 *
 * @author 228027 & 231731
 * @version 1.0
 */

public class CardGame {

    // main run method
    public static void main(String[] args) {
        try {
            // Request input from the user.
            System.out.println("Enter the number of players in the game: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int playerNum = Integer.parseInt(in.readLine());
            System.out.println("Enter the filename for a pack of cards: ");
            String filename = in.readLine();

            // start the game
            startGame(playerNum, filename);

        } catch (FileNotFoundException e) {
            try {
                // Request input from the user if there is no file found.
                System.out.println(
                        "Please enter a valid file name for the pack or Do you want to generate a new pack? (yes/no) ");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String decision = in.readLine();
                if (decision.equals("yes")) {
                    System.out.println("Enter the number of players in the game: ");
                    int playerNum = Integer.parseInt(in.readLine());
                    System.out.println("Enter the filename for a pack of cards: ");
                    String filename = in.readLine();
                    ArrayList<Card> PackOfCards = Generate.generate(playerNum);
                    Generate.writefile(filename, PackOfCards);
                    // start the game
                    CardGame.startGame(playerNum, filename);
                }
            } catch (NumberFormatException a) {
                System.out.println("Please enter a valid(int) number of players");
            } catch (IOException a) {
                System.out.println("Exeception: " + a);
            } catch (InvalidNumberOfCardsException a) {
                System.out.println("Exeception: " + a);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid(int) number of players");
        } catch (IOException e) {
            System.out.println("Exeception: " + e);
        } catch (InvalidNumberOfCardsException e) {
            System.out.println("Exeception: " + e);
        }

    }

    /**
     * Main method to run the game.
     * 
     * @param n        number of players
     * @param packFile filename of the pack
     */
    public static void startGame(int n, String packFile) throws IOException, InvalidNumberOfCardsException {
        Pack pack = new Pack(packFile, n);
        Deck[] decks = new Deck[n];
        Card[] cardsInPack = pack.getCards();
        Player[] players = new Player[n];

        // create players and deck
        players = createPlayers(n);
        decks = createDeck(n);

        // Distribute the cards
        for (int i = 0; i < 4 * n; i++) {
            players[i % n].getHand().add(cardsInPack[i]);
        }

        for (int i = 4 * n; i < 8 * n; i++) {
            decks[i % n].addCard(cardsInPack[i]);
        }

        boolean isWinner = false;

        // check if a player has won before the start of the game.
        checkWinner(players);

        // The game's main logic starts here
        int winner = -1;
        int turns = 0;
        while (!isWinner) {
            int playersTurn = turns++ % n;
            int discardToDeck = (playersTurn + 1) % n;
            int pickUpFromDeck = playersTurn;

            synchronized (players[playersTurn]) {
                Card newCard = decks[pickUpFromDeck].pickUpCard();
                Card discardCard = players[playersTurn].playerTurn(newCard, discardToDeck, pickUpFromDeck);
                decks[discardToDeck].addCard(discardCard);

            }
            if (players[playersTurn].isWinner()) {
                isWinner = true;
                winner = players[playersTurn].getPlayerId();

            }
            // use this function to print the content of decks and players to terminal every
            // round
            /*
             * for (Deck deck : decks) {
             * System.out.println(deck.toString());
             * }
             * for (Player player : players) {
             * System.out.println("player: " + player.toString());
             * }
             */
        }

        // validate if a player has won the game
        for (Player player : players) {
            if (player.isWinner()) {
                System.out.println("Player " + player.getPlayerId() + " has won the game");
            }
        }

        // inform player has won and write content of deck at the end of the game.
        for (int i = 0; i < n; i++) {
            synchronized (players[i]) {
                players[i].informPlayerHasWon(winner);
            }
            decks[i].writeDeckToFile();
        }
    }

    /**
     * Method to create players
     * 
     * @param n number of players
     * @return the number of players
     */
    public static Player[] createPlayers(int n) {
        Player[] players = new Player[n];
        // create players
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i + 1);
            players[i].start();
        }
        return players;
    }

    /**
     * Method to create deck
     * 
     * @param n number of players
     * @return an array of decks
     */
    public static Deck[] createDeck(int n) {
        Deck[] decks = new Deck[n];
        // create decks
        for (int i = 0; i < n; i++) {
            decks[i] = new Deck(i);
        }
        return decks;
    }

    /**
     * Method to check winner before the simulation starts
     * 
     * @param Player[] an array of players
     * @return boolean is winner
     */
    public static boolean checkWinner(Player[] players) {
        boolean isWinner = false;
        for (Player player : players) {
            player.writeToPlayerFile("player " + player.getPlayerId() + " initial hand " + player.getHand());
            if (player.isWinner()) {
                System.out.println("Player " + player.getPlayerId() + " has won the game");
                isWinner = true;
            }
        }
        return isWinner;
    }
}