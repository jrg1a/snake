package no.uib.inf101.sem2.model.Consumables;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.IFood;
import no.uib.inf101.sem2.model.Snake;

import java.util.Random;

public class Food implements IFood {
    private final IGrid<Object> grid;
    private final Snake snake;
    private CellPosition position;
    private final Random random;

    /**
     * Constructs a new Food object/instanc with the specified grid and snake.
     * @param grid  The game grid.
     * @param snake The snake that will interact with this food.
     */
    public Food(IGrid<Object> grid, Snake snake) {
        this.grid = grid;
        this.snake = snake;
        random = new Random();
    }

    /**
     * @return The CellPosition of this food (on the grid).
     */
    public CellPosition getPosition() {
        return position;
    }

    /**
     * Generate a new position for Food object, checking that it does
     * not spawn on any other food objects on the grid. :)
     */
    public void generate() {
        int row, col;
        do {
            row = random.nextInt(grid.rows());
            col = random.nextInt(grid.cols());
        } while (grid.get(new CellPosition(row, col)) != null);
        position = new CellPosition(row, col);
        grid.set(position, this);
    }
}
