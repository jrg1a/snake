package no.uib.inf101.sem2.controller;


    // Game.java

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Snake;
import no.uib.inf101.sem2.model.Snake_player_two;
import no.uib.inf101.sem2.model.Consumables.SuperFood;
import no.uib.inf101.sem2.view.Board;
import no.uib.inf101.sem2.view.HighScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JFrame implements ActionListener, KeyListener {
    private final int ROWS = 40;
    private final int COLS = 40;
    private final int CELL_SIZE = 20;
    private final int NUM_FOODS = 50;
    private final int NUM_SUPERFOODS = 10;
    private final int UPDATE_INTERVAL = 144;
    private boolean isPaused;
    private IGrid<Object> grid;
    private Snake snake;
    private Snake_player_two snake_two;
    private List<Food> foods;
    private Board board;
    private Timer timer;
    private int score;
    private boolean isGameOver;
    private final int INITIAL_SNAKE_ROW = 10;
    private final int INITIAL_SNAKE_COL = 10;
    private boolean snakeOneDead = false;
    private boolean snakeTwoDead = false;
    private int scoreSnakeOne;
    private int scoreSnakeTwo;
    private HighScore highScore = new HighScore();
    private final int BASE_SPEED = 100;
    private Controller controller;



    /**
     * Constructs a new Game instance with the specified number of players
     * @param numPlayers The number of players (1 or 2).
     */
    public Game(int numPlayers) {
        grid = new Grid<>(ROWS, COLS);
        isPaused = false;
        isGameOver = false;
        addKeyListener(this);
        snake = new Snake(grid, this);
        if (numPlayers == 2) {
            snake_two = new Snake_player_two(grid, this);
        } else {
            snake_two = null;
        }
        controller = new Controller(this, snake, snake_two);

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        foods = new ArrayList<>();
    }

    /**
     * Initializes the game state, creating the grid, snakes, and UI elements.
     */

    public void initialize() {
        //Initialize the snake with a random position
        int snakeStartRow = new Random().nextInt(ROWS - 4) + 2;
        int snakeStartCol = new Random().nextInt(COLS - 4) + 2;
        snake.init(snakeStartRow, snakeStartCol);
        if (snake_two != null) {
            snake_two.init(snakeStartRow+3, snakeStartCol+3);
        }

        for (int i = 0; i < NUM_FOODS; i++) {
            Food food = new Food(grid, snake);
            food.generate();
            foods.add(food);
        }
        // Create and generate superfoods
        for (int i = 0; i < NUM_SUPERFOODS; i++) {
            SuperFood superFood = new SuperFood(grid, snake, 10000); // 10 seconds lifespan
            superFood.generate();
            foods.add(superFood);
        }

        board = new Board(grid, snake, snake_two, foods, CELL_SIZE, this, highScore);
        add(board);

        timer = new Timer(UPDATE_INTERVAL, this);
        timer.start();

        setTitle("Snake Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
        Insets insets = getInsets();
        int width = COLS * CELL_SIZE + insets.left + insets.right;
        int height = ROWS * CELL_SIZE + insets.top + insets.bottom;
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * @return A List of Food objects (currently in the game).
     */
    public List<Food> getFoods() {
        return foods;
    }

    /**
     * Handles the game over condition for snake.
     * @param snake The snake that has caused the game over.
     */
    public void gameOver(Snake snake) {
        if (snake instanceof Snake_player_two) {
            snakeTwoDead = true;
        } else {
            snakeOneDead = true;
        }
        if (snake_two == null) {
            snakeTwoDead = true;
        }
        if (snakeOneDead && snakeTwoDead) {
            isGameOver = true;
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over! Press Enter to restart", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            board.repaint();
            highScore.addScore(score);
        } else {
            snake.setDead(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isPaused && snake.isInitialized()) {
            snake.move();
            if (snake_two != null && snake_two.isInitialized()) {
                snake_two.move();
            }
            timer.setDelay((int) (BASE_SPEED / snake.getSpeed()));
            updateSuperFoods();
            board.repaint();
        }

    }

    /**
     * Restarts the game.
     */

    public void restart() {
        isGameOver = false;
        snakeOneDead = false;
        snakeTwoDead = false;
        score = 0;
        scoreSnakeOne = 0;
        scoreSnakeTwo = 0;
        snake.init(INITIAL_SNAKE_ROW, INITIAL_SNAKE_COL);
        if (snake_two != null) {
            snake_two.init(INITIAL_SNAKE_ROW + 3, INITIAL_SNAKE_COL + 3);
        }
        for (Food food : foods) {
            food.generate();
        }
        clearGrid();
        timer.start();
    }


    /**
     * Toggles the pause state of the game.
     */
    public void togglePause() {
        isPaused = !isPaused;
    }


    /**
     * Used by game class to clear the grid!
     */
    private void clearGrid() {
        for (int row = 0; row < grid.rows(); row++) {
            for (int col = 0; col < grid.cols(); col++) {
                CellPosition position = new CellPosition(row, col);
                grid.set(position, null);
            }
        }
    }

    /**
     * Increases the game score by the specified number of points.
     * @param points The number of points to increase the score by.
     */
    public void increaseScore(int points) {
        score += points;
    }

    /**
     * @return The current game score.
     */

    public int getScore() {
        return score;
    }

    /**
     * Updates the superfoods in the game, regenerating them if they have expired.
     */
    private void updateSuperFoods() {
        for (Food food : foods) {
            if (food instanceof SuperFood) {
                SuperFood superFood = (SuperFood) food;
                if (superFood.hasExpired()) {
                    superFood.generate();
                }
            }
        }
    }

    /**
     * @return The number of columns.
     */
    public int getCols() {
        return COLS;
    }

    /**
     * @return The number of rows.
     */
    public int getRows() {
        return ROWS;
    }

    /**
     * Increases the score for the first snake player by the specified number of points.
     * @param points The number of points to increase the score by.
     */
    public void increaseScoreSnakeOne(int points) {
        scoreSnakeOne += points;
    }

    /**
     * Increases the score for the second snake player by the specified number of points.
     * @param points The number of points to increase the score by.
     */

    public void increaseScoreSnakeTwo(int points) {
        scoreSnakeTwo += points;
    }

    /**
     * @return The current score for the first snake player.
     */
    public int getScoreSnakeOne() {
        return scoreSnakeOne;
    }

    /**
     * @return The current score for the second snake player.
     */
    public int getScoreSnakeTwo() {
        return scoreSnakeTwo;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       controller.handleKeyEvent(e.getKeyCode(), isGameOver);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}




