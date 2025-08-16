# Card Game Simulator

A Java implementation of a simple card game where two players compete by playing cards from their decks.

## Overview

This project simulates a card game between two players (Player A and Player B). Each player starts with half of a shuffled deck, and they play cards in rounds. The player with the higher-value card wins the round and collects the opponent's card. The game continues until one player has all the cards.

## Features

- **Deck Management**: Creates, shuffles, and divides a standard 52-card deck.
- **Player Turns**: Players take turns playing cards from their hands.
- **Win Condition**: Determines the winner of each round based on card values.
- **Game Simulation**: Automatically plays rounds until a winner is declared.

## Classes

- **Main**: Entry point of the application.
- **Player**: Represents a player with a name and a hand of cards.
- **Card**: Represents a single card with a shape (suit) and value.
- **Deck**: Manages a collection of cards, including adding, removing, and retrieving cards.
- **DeckManager**: Handles deck creation, shuffling, and win condition logic.
- **GameManager**: Controls the game flow, including round management and winner determination.
- **Shapes**: Enum representing card suits (Hearts, Diamonds, Spades, Clubs).

## How to Run

1. Ensure you have Java installed on your system.
2. Clone the repository or download the source files.
3. Compile and run the `Main.java` file:
   ```bash
   javac bk/tales/*.java
   java bk.tales.Main
   ```
   
## Example output

```
CURRENTLY PLAYING ROUND: 1
CARDS IN A 26
CARDS IN B 26

CARD PLAYED BY PLAYER A: CARD: 7 of HEARTS
CARD PLAYED BY PLAYER B: CARD: King of DIAMONDS

PLAYER B WON THE ROUND!
ADDING CARD CARD: King of DIAMONDS to PLAYER A
----------------------------------------------------------------------
```

## Rules

- The deck is divided equally between the two players.
- Each round, players play the top card from their deck.
- The player with the higher-value card wins the round and takes the opponent's card.
- If the cards have the same value, they are removed from play ("held").
- The game ends when one player has all the cards.

## Card Values

Cards are ranked from lowest to highest as follows:  
`2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace`

## License

This project is open-source and available under the MIT License.

---

Feel free to contribute or report issues. Enjoy the game!


