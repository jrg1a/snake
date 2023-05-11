package no.uib.inf101.sem2.model.Consumables;

import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Snake;

public class SuperFood extends Food {

    private int lifespan; // in milliseconds
    private long spawnTime;
    private boolean isGenerated;

    /**
     * Creates a new instance of SuperFood.
     * @param grid The grid the SuperFood is placed on.
     * @param snake The snake that interacts with the SuperFood.
     * @param lifespan The lifespan of the SuperFood in milliseconds.
     */

    public SuperFood(IGrid<Object> grid, Snake snake, int lifespan) {
        super(grid, snake);
        this.lifespan = lifespan;
        this.isGenerated = false;
    }

    /**
     * Generates a new position for the SuperFood on the grid, ensuring that it does not overlap
     * with any existing objects, and sets the spawn time.
     */

    @Override
    public void generate() {
        super.generate();
        spawnTime = System.currentTimeMillis();
        isGenerated = true;
    }


    /**
     * Checks if the food object superfood has expired or not
     * @return true if the SuperFood has expired, false if not!
     */
    public boolean hasExpired() {
        if (!isGenerated) return false;
        return System.currentTimeMillis() - spawnTime >= lifespan;
    }


}
