package no.uib.inf101.sem2.TestController;


import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Snake;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.IGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.uib.inf101.sem2.controller.Game;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {
    private IGrid<Object> grid;
    private Snake snake;
    private Game game;
    private Food food;
    private static final int ROWS = 20;
    private static final int COLS = 20;

    @BeforeEach
    public void setUp() {
        grid = new Grid<>(ROWS, COLS);
        game = new Game(1);
        snake = new Snake(grid, game);
        snake.init(2, 2);
        food = new Food(grid, snake);
    }

    @Test
    public void testFoodGeneration() {
        food.generate();
        CellPosition foodPosition = food.getPosition();
        //Skjekker om food posisjonen er på gridden :D
        assertTrue(grid.positionIsOnGrid(foodPosition), "Food position is not on grid");
        //Skjekker at maten ikke r på slangen
        assertFalse(snake.getBody().contains(foodPosition), "Food is placed on the snake!");
        //Skjekker om maten er på grid
        assertEquals(food, grid.get(foodPosition), "Food is not placed on the grid");
    }
}

