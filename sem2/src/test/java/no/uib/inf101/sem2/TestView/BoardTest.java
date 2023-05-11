package no.uib.inf101.sem2.TestView;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.controller.Game;
import no.uib.inf101.sem2.model.Snake;
import no.uib.inf101.sem2.model.Snake_player_two;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.view.Board;
import no.uib.inf101.sem2.view.HighScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private IGrid<Object> grid;
    private Snake snake;
    private Snake_player_two snake2;
    private Game game;
    private ArrayList<Food> foods;
    private Board board;
    private static final int ROWS = 20;
    private static final int COLS = 20;
    private static final int CELL_SIZE = 20;

    @BeforeEach
    public void setUp() {
        grid = new Grid<>(ROWS, COLS);
        game = new Game(1);
        snake = new Snake(grid, game);
        snake.init(2, 2);
        snake2 = new Snake_player_two(grid, game);
        foods = new ArrayList<>();
        Food food = new Food(grid, snake);
        food.generate();
        foods.add(food);
        board = new Board(grid, snake, snake2, foods, CELL_SIZE, game, new HighScore());
    }

    @Test
    public void testBoardDimensions() {
        int boardWidth = board.getPreferredSize().width;
        int boardHeight = board.getPreferredSize().height;
        assertEquals(COLS * CELL_SIZE, boardWidth, "Board width does not match expected value");
        assertEquals(ROWS * CELL_SIZE, boardHeight, "Board height does not match expected value");
    }
}
