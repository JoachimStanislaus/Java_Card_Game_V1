<a name="readme-top"></a>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/JoachimStanislaus/Java_Card_Game_V1">
    <img src="../assets/images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Java Card Game</h3>

  <p align="center">
    project_description
    <br />
    <a href="https://github.com/JoachimStanislaus/Java_Card_Game_V1"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/JoachimStanislaus/Java_Card_Game_V1/issues">Report Bug</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
        <li><a href="#game-functionality">Game Functionality</a></li>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#running-the-game">Running the game</a></li>
        <ul>
          <li><a href="#running-the-game-from-jar-release">Run the game from JAR release</a></li>
          <li><a href="#running-the-game-from-source-code">Run the game from source code</a></li>
          <li><a href="#running-the-game-from-windows-command-line">Windows command line instructions</a></li>
        </ul>
        <li><a href="#testing">Testing</a></li>
        <ul>
          <li><a href="#run-the-test-suite">Run the test suite</a></li>
          <li><a href="#run-the-test-from-windows-command-line">Windows command line instructions</a></li>
        </ul>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

### Built With

* [![Java][Java.com]][Java-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/joachimstanislaus/Java_Card_Game.git
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- RUNNING THE GAME -->
### Running The Game

#### Run The Game From Jar Release

1. Open terminal/command prompt in the directory where cards.jar is saved
2. Run this command:
```cmd
java -jar cards.jar
```
3. Type the number of players and ENTER (if you want to use the test pack of cards, type 22)
4. Type the filename of the pack of cards (testPack.txt will work)

#### Run The Game From Source Code

To run the game, run the main method of the `CardGame` class. You will be prompted to enter the number of players. If you want to use the test pack of cards, enter 22 for number of players. When asked for the filename of the pack of cards, enter `testPack.txt`. The game should ensue, and a winner established. Players will output their turns to seperate files under the `gameOutput` directory, along with the final state of each card deck.

#### Run The Game From Windows Command Line

1. In command prompt, navigate to the root folder of the project (automated-java-card-game)
2. Run the command `javac -cp src;lib/junit-4.12 src/CardGame.java`
3. Run the command `java -cp src;lib/junit-4.12 src/CardGame.java`
4. Type the number of players and ENTER (if you want to use the test pack of cards, type 22)
5. Type the filename of the pack of cards (testPack.txt will work)

<!-- TESTING -->
### Testing

To run the full test suite, compile the `src` folder and then run the `CardGameTestSuite` class. This will automatically run the individual test files for each class.

#### Run The Test Suite

To run the full test suite, compile the `src` folder and then run the `CardGameTestSuite` class. This will automatically run the individual test files for each class.

#### Run The Test From Windows Command Line

1. The tests must be run from the `src` directory. To switch to it from the root folder, use:
```cmd
cd src
```
2. Compile the source code to bytecode
```cmd
javac -cp .;../lib/junit-4.12.jar CardGameTestSuite.java
```
3. Run the tests with JUnit
```cmd
java -cp .;../lib/junit-4.12.jar;../lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore CardGameTestSuite
```
---
The expected output is:
```
JUnit version 4.12
....Player 1 has won
............Player 42 has won

Time: 0.071

OK (16 tests)
```

<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- Game functionality -->
## Game functionality

The user can specify the number of players, n.
Each player picks up and discards a card on their turn. 
Players are numbered from 1 to n. 
A player will keep cards that equal their player number. 
If a player gets 4 of the same card, they win the game. 
Players output their moves to text file in the folder `gameOutput`

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@twitter_handle](https://twitter.com/joachimmmy) - hello@joachimstanislaus.com

Project Link: [https://github.com/joachimstanislaus/Java_Card_Game](https://github.com/joachimstanislaus/Java_Card_Game)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/joachimstanislaus/Java_Card_Game_V1.svg?style=for-the-badge
[contributors-url]: https://github.com/joachimstanislaus/Java_Card_Game_V1/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/joachimstanislaus/Java_Card_Game_V1.svg?style=for-the-badge
[forks-url]: https://github.com/joachimstanislaus/Java_Card_Game_V1/network/members
[stars-shield]: https://img.shields.io/github/stars/joachimstanislaus/Java_Card_Game_V1.svg?style=for-the-badge
[stars-url]: https://github.com/joachimstanislaus/Java_Card_Game_V1/stargazers
[issues-shield]: https://img.shields.io/github/issues/joachimstanislaus/Java_Card_Game_V1.svg?style=for-the-badge
[issues-url]: https://github.com/joachimstanislaus/Java_Card_Game_V1/issues
[license-shield]: https://img.shields.io/github/license/joachimstanislaus/Java_Card_Game_V1.svg?style=for-the-badge
[license-url]: https://github.com/joachimstanislaus/Java_Card_Game_V1/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/joachimstanislaus
[product-screenshot]: images/logo.png
[Java.com]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/en/
