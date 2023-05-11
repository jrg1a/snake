package no.uib.inf101.sem2.model;


import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.IGrid;

import java.util.LinkedList;

public interface ISnake {

    /**
     * Initializes the snake with the specified starting row and column.
     * @param startRow The starting row for the snake.
     * @param startCol The starting column for the snake.
     */
    void init(int startRow, int startCol);

    /**
     * Returns the LinkedList of CellPosition objects that represent the body of the snake.
     * @return The body of the snake as a LinkedList of CellPosition objects.
     */

    LinkedList<CellPosition> getBody();

    /**
     * Changes the direction of the snake based on the given key code and whether the game is over.
     * @param x
     * @param y
     */

    void setDirection(int x, int y);


    /**
     * Moves the snake in its current direction.
     */
    void move();

    /**
     * Increases the length of the snake by one cell.
     */
    void grow();


    /**
     * Checks if the snake has been initialized.
     * @return true if the snake has been initialized, false otherwise.
     */
    boolean isInitialized();
}

