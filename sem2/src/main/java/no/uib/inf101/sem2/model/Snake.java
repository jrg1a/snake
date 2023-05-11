package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.controller.Game;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Consumables.SuperFood;

import java.util.LinkedList;
import java.util.List;

public class Snake implements ISnake {
    protected final Game game;
    protected final IGrid<Object> grid;
    protected LinkedList<CellPosition> body;
    private boolean isInitialized = false;
    private double speed = 1.0;
    protected int dx = 0;
    protected int dy = 0;
    protected boolean isDead = false;

    /**
     * Constructs new Snake object.
     * @param grid The grid on which the snake moves.
     * @param game The Game object to interact with the game state.
     */
    public Snake(IGrid<Object> grid, Game game) {
        this.grid = grid;
        this.game = game;
    }

    /**
     * Initializes the snake with the given starting position.
     * @param startRow The row index of the starting position.
     * @param startCol The column index of the starting position.
     */
    public void init(int startRow, int startCol) {
        // Spawn snake
        CellPosition initialPos = new CellPosition(startRow, startCol);
        body = new LinkedList<>();
        body.add(initialPos);
        grid.set(initialPos, this);
        isInitialized = true;
        // Set the initial direction
        dx = 1;
        dy = 0;
    }

    /**
     * Returns the snakes body as a LinkedList of CellPosition objects.
     * @return The snakes body.
     */

    public LinkedList<CellPosition> getBody() {
        return body;
    }


    /**
     * Sets the snake's direction. The snake cannot change direction by 180 degrees.
     * @param x The horizontal direction (-1 for left, 0 for no change, 1 for right).
     * @param y The vertical direction (-1 for up, 0 for no change, 1 for down).
     */
    public void setDirection(int x, int y) {
        if ((Math.abs(x) != Math.abs(dx)) && (Math.abs(y) != Math.abs(dy))) {
            dx = x;
            dy = y;
        }
    }


    /**
     * Moves the snake one cell in its current direction. Detects collisions with the grid
     * boundaries, other snakes, and food.
     */
    public void move() {
        if (isDead) {
            return;
        }
        if (body == null || body.isEmpty()) {
            return;
        }
        CellPosition head = body.getFirst();
        CellPosition newHead = new CellPosition(head.row() + dy, head.col() + dx);

        if (!grid.positionIsOnGrid(newHead)) {
            game.gameOver(this);
            return;
        }

        if (grid.get(newHead) instanceof Snake) {
            game.gameOver(this);
            return;
        }
        boolean ateFood = false;
        for (Food food : game.getFoods()) {
            if (food.getPosition().equals(newHead)) {
                food.generate(); // Respawn food at a new random position
                grow(); // Make the snake grow
                ateFood = true;
                // Check if the eaten food is SuperFood
                if (food instanceof SuperFood) {
                    game.increaseScoreSnakeOne(2); // Double the score for SuperFood
                } else {
                    game.increaseScoreSnakeOne(1); // Regular score for Food
                }
                break;
            }
        }
        if (!ateFood) {
            CellPosition tail = body.removeLast();
            grid.set(tail, null);
        }
        body.addFirst(newHead);
        grid.set(newHead, this);
    }

    /**
     * Grows the snake by adding one cell at its tail.
     */
    public void grow() {
        CellPosition tail = body.getLast();
        CellPosition newTail = new CellPosition(tail.row() - dy, tail.col() - dx);
        if (grid.positionIsOnGrid(newTail)) {
            body.add(newTail);
        }
        game.increaseScore(1);
    }

    /**
     * @return True if the snake is initialized, false ifnot.
     */
    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     * Sets the speed multiplier of the snake.
     * @param multiplier The speed multiplier (e.g., 0.5 to slow down, 1.0 for normal speed, 2.0 to speed up).
     */
    public void setSpeed(double multiplier) {
        this.speed = multiplier;
    }

    /**
     * Gets the speed multiplier of the snake.
     * @return The speed multiplier.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Gets the position of the snake's head.
     * @return The position of the head as a CellPosition object.
     */
    public CellPosition getHead() {
        return body.getFirst();
    }

    /**
     * Gets the positions of the snake's tail (all cells except the head).
     * @return A list of CellPosition objects representing the positions of the tail cells.
     */
    public List<CellPosition> getTail() {
        return body.subList(1, body.size());
    }

    /**
     * Sets the snake's dead state.
     * @param dead Set to true if the snake is dead, false otherwise.
     */
    public void setDead(boolean dead) {
        this.isDead = dead;
    }

}
