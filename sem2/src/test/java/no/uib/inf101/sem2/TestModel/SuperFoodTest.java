package no.uib.inf101.sem2.TestModel;

import no.uib.inf101.sem2.controller.Game;
import no.uib.inf101.sem2.model.Snake;
import no.uib.inf101.sem2.model.Consumables.SuperFood;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.IGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperFoodTest {
    private IGrid<Object> grid;
    private Snake snake;
    private Game game;
    private SuperFood superFood;

    @BeforeEach
    void setUp() {
        game = new Game(1);
        grid = new Grid<>(game.getRows(), game.getCols());
        snake = new Snake(grid, game);
        superFood = new SuperFood(grid, snake, 1000);
    }


    @Test
    void testLifespan() throws InterruptedException {
        IGrid<Object> grid = new Grid<>(40, 40);
        Snake snake = new Snake(grid, new Game(1));
        SuperFood testSuperFood = new SuperFood(grid, snake, 1000); // 1 second lifespan
        assertFalse(testSuperFood.hasExpired());
        testSuperFood.generate();
        Thread.sleep(1100); // Sleep for 1.1 seconds
        assertTrue(testSuperFood.hasExpired());
    }



    @Test
    void testScoreIncrease() {

    }

    @Test
    void testSuperFoodGeneration() {
        superFood.generate();
        CellPosition position = superFood.getPosition();
        assertEquals(superFood, grid.get(position));
    }
    @Test
    void testSuperFoodNotInSnake() {
        snake.init(10, 10);
        superFood.generate();
        CellPosition position = superFood.getPosition();
        assertNotEquals(snake.getHead(), position, "SuperFood should not be generated on the Snake's head");
        assertFalse(snake.getTail().contains(position), "SuperFood should not be generated on the Snake's tail");
    }

    @Test
    void testSuperFoodRegenerationAfterExpiration() throws InterruptedException {
        superFood.generate();
        Thread.sleep(1100); // Sleep for 1.1 seconds
        assertTrue(superFood.hasExpired(), "SuperFood should expire after 1.1 seconds");
        superFood.generate();
        assertFalse(superFood.hasExpired(), "SuperFood should not be expired after regeneration");
    }
}
