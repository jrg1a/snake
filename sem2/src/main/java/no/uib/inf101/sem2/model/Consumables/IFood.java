package no.uib.inf101.sem2.model.Consumables;



import no.uib.inf101.sem2.grid.CellPosition;

public interface IFood {

    /**
     * @return The CellPosition representing the position of the food object.
     */
    CellPosition getPosition();

    /**
     * Generates a new position for the food on the grid, ensuring that it does not overlap
     * with any existing objects.
     */
    void generate();
}

