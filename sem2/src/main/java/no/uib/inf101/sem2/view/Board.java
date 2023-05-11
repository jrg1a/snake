package no.uib.inf101.sem2.view;

import no.uib.inf101.sem2.controller.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Snake;
import no.uib.inf101.sem2.model.Snake_player_two;
import no.uib.inf101.sem2.model.Consumables.SuperFood;

import java.util.List;

public class Board extends JPanel implements PropertyChangeListener {
    private final IGrid<Object> grid;
    private final Snake snake;
    private final List<Food> foods;
    private final int cellSize;
    private Game game;
    private BufferedImage appleImage;
    private BufferedImage appleImageGolden;
    private Snake_player_two snakeTwo;
    private HighScore highScore;

    /**
     * Constructor for Board class.
     * @param grid The grid on which the game is played.
     * @param snake The snake object for player one.
     * @param snakeTwo The snake object for player two.
     * @param foods List of food items on the board.
     * @param cellSize The size of each cell in the grid.
     * @param game The game instance.
     * @param highScore The high score manager.
     */

    public Board(IGrid<Object> grid, Snake snake, Snake_player_two snakeTwo, List<Food> foods, int cellSize, Game game, HighScore highScore) {
        this.grid = grid;
        this.snake = snake;
        this.snakeTwo = snakeTwo;
        this.foods = foods;
        this.cellSize = cellSize;
        this.game = game;
        this.highScore = highScore;
        // food pic
        try {
            appleImage = ImageIO.read(getClass().getResource("/appleimage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // super food pic
        try {
            appleImageGolden = ImageIO.read(getClass().getResource("/goldenapple.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        highScore.addPropertyChangeListener(this);

    }

    /**
     * Draws the score on the game board.
     * @param g Graphics object used to draw on the board.
     * @param score The score to display.
     * @param color The color of the score text.
     * @param yPos The y-position of the score text.
     */

    private void drawScore(Graphics g, int score, Color color, int yPos) {
        g.setColor(color);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Score: " + score, 10, yPos);
    }

    /**
     * Overrides paintComponent method from JPanel to draw snake(s), food, and scores.
     * @param g Graphics object used to draw on the board.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw snake body
        for (CellPosition pos : snake.getBody()) {
            g.setColor(Color.GREEN);
            g.fillRect(pos.col() * cellSize, pos.row() * cellSize, cellSize, cellSize);
        }
        String highScoreString = "High Score: " + highScore.getHighScore();
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        int highScoreYPos;
        if (snakeTwo != null && snakeTwo.isInitialized()) {
            highScoreYPos = 60;
        } else {
            highScoreYPos = 40;
        }
        g.drawString(highScoreString, 10, highScoreYPos);
        if (snakeTwo != null && snakeTwo.isInitialized()) {
            for (CellPosition pos : snakeTwo.getBody()) {
                g.setColor(Color.BLUE);
                g.fillRect(pos.col() * cellSize, pos.row() * cellSize, cellSize, cellSize);
            }
        }

        // Iterate through the foods list and draw each food item
        for (Food food : foods) {
            CellPosition foodPos = food.getPosition();
            if (food instanceof SuperFood) {
                g.drawImage(appleImageGolden, foodPos.col() * cellSize, foodPos.row() * cellSize, cellSize, cellSize, null);
            } else {
                g.drawImage(appleImage, foodPos.col() * cellSize, foodPos.row() * cellSize, cellSize, cellSize, null);
            }
        }
        drawScore(g, game.getScoreSnakeOne(), Color.GREEN, 20);
        if (snakeTwo != null && snakeTwo.isInitialized()) {
            drawScore(g, game.getScoreSnakeTwo(), Color.BLUE, 40);
        }
    }

    /**
     * Handles property change events, in this case, the high score.
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("highScore".equals(evt.getPropertyName())) {
            repaint();
        }
    }
}


