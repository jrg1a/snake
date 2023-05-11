package no.uib.inf101.sem2.TestModel;

import no.uib.inf101.sem2.controller.Game;
import no.uib.inf101.sem2.model.Snake;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.IGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {
    private IGrid<Object> grid;
    private Snake snake;
    private Game game;
    private final int ROWS = 20;
    private final int COLS = 20;


    @BeforeEach
    public void setUp() {
        grid = new Grid<>(ROWS, COLS);
        game = new Game(1);
        snake = new Snake(grid, game);
        snake.init(10, 10);
    }

    @Test
    public void testSnakeInitialization() {
        CellPosition initialPos = new CellPosition(10, 10);
        assertEquals(1, snake.getBody().size(), "Snake initial size is not correct");
        assertEquals(initialPos, snake.getBody().getFirst(), "Snake initial position is not correct");
        assertEquals(snake, grid.get(initialPos), "Snake is not placed on the grid");
    }

    @Test
    public void testSnakeMovement() {
        snake.setDirection(0, -1);
        snake.move();
        CellPosition newPos = new CellPosition(9, 10);
        assertEquals(newPos, snake.getBody().getFirst(), "Snake did not move to the correct position");
        assertNull(grid.get(new CellPosition(10, 10)), "Old snake position is not empty");
        assertEquals(snake, grid.get(newPos), "Snake is not placed on the grid after moving");
    }

    @Test
    public void testSnakeGrowth() {
        int initialSize = snake.getBody().size();
        snake.grow();
        int newSize = snake.getBody().size();
        assertEquals(initialSize + 1, newSize, "Snake size did not increase after growing");
    }
}
