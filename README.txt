<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/joachimstanislaus/Java_Card_Game_V1.git
   ```

<!-- RUNNING THE GAME -->
## Running The Game

### Run The Game From Jar Release

1. Open terminal/command prompt in the directory where cards.jar is saved
2. Run this command:
```cmd
java -jar cards.jar
```
3. Type the number of players and ENTER (if you want to use the test pack of cards, type 2)
4. Type the filename of the pack of cards (samplepack.txt will work)

### Run The Game From Source Code

To run the game, run the main method of the `CardGame` class. You will be prompted to enter the number of players. If you want to use the test pack of cards, enter 2 for number of players. When asked for the filename of the pack of cards, enter `samplepack.txt`. The game should ensue, and a winner established. Players will output their turns to seperate files under the `log` directory, along with the final state of each card deck.

### Run The Game From Windows Command Line

1. In command prompt, navigate to the root folder of the project (Java_Card_Game_V1)
2. Run the command `javac -cp src;lib/junit-4.13 src/CardGame.java`
3. Run the command `java -cp src;lib/junit-4.13 src/CardGame.java`
4. Type the number of players and ENTER (if you want to use the test pack of cards, type 2)
5. Type the filename of the pack of cards (samplepack.txt will work)

<!-- TESTING -->
## Testing

### Run The Test From VS Code

Use the testing functionality to run tests

### Run The Test Suite

To run the full test suite, compile the `test` folder and then run the `CardGameTestSuite` class. This will automatically run the individual test files for each class.

### Run The Test From Windows Command Line

1. The tests must be run from the `test` directory. To switch to it from the root folder, use:
```cmd
cd test
```
2. Compile the source code to bytecode
```cmd
javac -cp .;../lib/junit-4.13.2.jar CardGameTestSuite.java
```
3. Run the tests with JUnit
```cmd
java -cp .;../lib/junit-4.13.2.jar;../lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore CardGameTestSuite
```
---
The expected output is:
```
JUnit version 4.13.2
.........Player 1 has won the game
.Player 4 has won the game
.....
Time: 0.86

OK (14 tests)
```

<!-- Game functionality -->
## Game functionality

The user can specify the number of players, n.
Each player picks up and discards a card on their turn. 
Players are numbered from 1 to n. 
A player will keep cards that equal their player number. 
If a player gets 4 of the same card, they win the game. 
Players output their moves to text file in the folder `log`