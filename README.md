# Snake Game

This is a simple and fun Snake game implemented in Java, using a grid-based design to handle the game logic and UI elements. Players can control the snake using the arrow keys to move it around the grid, eating food to grow in size and gain points.

## Features

- Single-player and two-player modes
- Classic snake movement and growth
- Food and SuperFood items for the snake to eat
- Adjustable game speed
- Pause and restart functionality
- Game over detection and score tracking
- High score tracking and display

## How to Play

1. Compile and run the game.
2. Choose between single-player or two-player mode.
3. Control the snake(s) using the arrow keys (for player 1) and W, A, S, D keys (for player 2, if applicable).
4. Eat food and SuperFood items to grow the snake(s) and increase the score. SuperFood items provide double points and have a limited lifespan.
5. Avoid colliding with the grid boundaries and the snake's own body.
6. Press Spacebar to pause or resume the game.
7. When the game is over, press Enter to restart.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed

### Running the Game

1. Clone the repository or download the source files.
2. Navigate to the project directory.
3. Compile the Java source files:
```
javac no/uib/inf101/sem2/controller/Game.java
```
4. Run the compiled Java program:
```
java no.uib.inf101.sem2.controller.Game <numPlayers>
```
Replace `<numPlayers>` with either `1` for single-player mode or `2` for two-player mode.

## Customization

You can adjust various settings in the `Game` class, such as the number of rows and columns in the grid, cell size, and the number of food and SuperFood items. Please refer to the source code for the specific variables to change.

## License

This project is open-source and available for personal and educational use. Please provide appropriate credit if you use any part of this project in your own work.

Enjoy the game!

Here is a video of the application:
https://www.youtube.com/watch?v=hgqXngQuM3o



*Kind regards, **Jørgen***
