package no.uib.inf101.sem2.TestGrid;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.IGrid;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    public void testGridCreation() {
        int rows = 5;
        int cols = 5;
        Grid<String> grid = new Grid<>(rows, cols);

        assertEquals(rows, grid.rows(), "Grid rows should be equal to the given value");
        assertEquals(cols, grid.cols(), "Grid cols should be equal to the given value");
    }

    @Test
    public void testGridSetAndGet() {
        int rows = 5;
        int cols = 5;
        Grid<String> grid = new Grid<>(rows, cols);
        CellPosition pos = new CellPosition(2, 3);
        String value = "Test value";

        grid.set(pos, value);
        assertEquals(value, grid.get(pos), "Grid get should return the previously set value");
    }

    @Test
    void gridSanityTest() {
        String defaultValue = "x";
        IGrid<String> grid = new Grid<>(3, 2, defaultValue);

        assertEquals(3, grid.rows());
        assertEquals(2, grid.cols());

        assertEquals("x", grid.get(new CellPosition(0, 0)));
        assertEquals("x", grid.get(new CellPosition(2, 1)));

        grid.set(new CellPosition(1, 1), "y");

        assertEquals("y", grid.get(new CellPosition(1, 1)));
        assertEquals("x", grid.get(new CellPosition(0, 1)));
        assertEquals("x", grid.get(new CellPosition(1, 0)));
        assertEquals("x", grid.get(new CellPosition(2, 1)));
    }

    @Test
    void gridCanHoldNull() {
        String defaultValue = "x";
        IGrid<String> grid = new Grid<>(3, 2, defaultValue);

        assertEquals("x", grid.get(new CellPosition(0, 0)));
        assertEquals("x", grid.get(new CellPosition(2, 1)));

        grid.set(new CellPosition(1, 1), null);

        assertEquals(null, grid.get(new CellPosition(1, 1)));
        assertEquals("x", grid.get(new CellPosition(0, 1)));
        assertEquals("x", grid.get(new CellPosition(1, 0)));
        assertEquals("x", grid.get(new CellPosition(2, 1)));
    }

    @Test
    void gridNullsInDefaultConstructor() {
        IGrid<String> grid = new Grid<>(3, 2);

        assertEquals(null, grid.get(new CellPosition(0, 0)));
        assertEquals(null, grid.get(new CellPosition(2, 1)));

        grid.set(new CellPosition(1, 1), "y");

        assertEquals("y", grid.get(new CellPosition(1, 1)));
        assertEquals(null, grid.get(new CellPosition(0, 1)));
        assertEquals(null, grid.get(new CellPosition(1, 0)));
        assertEquals(null, grid.get(new CellPosition(2, 1)));
    }

    @Test
    void coordinateIsOnGridTest() {
        IGrid<Double> grid = new Grid<>(3, 2, 0.9);

        assertTrue(grid.positionIsOnGrid(new CellPosition(2, 1)));
        assertFalse(grid.positionIsOnGrid(new CellPosition(3, 1)));
        assertFalse(grid.positionIsOnGrid(new CellPosition(2, 2)));

        assertTrue(grid.positionIsOnGrid(new CellPosition(0, 0)));
        assertFalse(grid.positionIsOnGrid(new CellPosition(-1, 0)));
        assertFalse(grid.positionIsOnGrid(new CellPosition(0, -1)));
    }

    @Test
    void throwsExceptionWhenCoordinateOffGrid() {
        IGrid<String> grid = new Grid<>(3, 2, "x");

        try {
            @SuppressWarnings("unused")
            String x = grid.get(new CellPosition(3, 1));
            fail();
        } catch (IndexOutOfBoundsException e) {
            // Test passed
        }
    }

    @Test
    void testIterator() {
        IGrid<String> grid = new Grid<>(3, 2, "x");
        grid.set(new CellPosition(0, 0), "a");
        grid.set(new CellPosition(1, 1), "b");
        grid.set(new CellPosition(2, 1), "c");

        List<GridCell<String>> items = new ArrayList<>();
        for (GridCell<String> coordinateItem : grid) {
            items.add(coordinateItem);
        }

        assertEquals(3 * 2, items.size());
        assertTrue(items.contains(new GridCell<String>(new CellPosition(0, 0), "a")));
        assertTrue(items.contains(new GridCell<String>(new CellPosition(1, 1), "b")));
        assertTrue(items.contains(new GridCell<String>(new CellPosition(2, 1), "c")));
        assertTrue(items.contains(new GridCell<String>(new CellPosition(0, 1), "x")));
    }




    @Test
    public void testPositionIsOnGrid() {
        int rows = 5;
        int cols = 5;
        Grid<String> grid = new Grid<>(rows, cols);

        assertTrue(grid.positionIsOnGrid(new CellPosition(0, 0)), "Position (0,0) should be on grid");
        assertTrue(grid.positionIsOnGrid(new CellPosition(4, 4)), "Position (4,4) should be on grid");
        assertFalse(grid.positionIsOnGrid(new CellPosition(-1, 0)), "Position (-1,0) should not be on grid");
        assertFalse(grid.positionIsOnGrid(new CellPosition(0, 5)), "Position (0,5) should not be on grid");
    }

    @Test
    public void testGridIterator() {
        int rows = 5;
        int cols = 5;
        Grid<String> grid = new Grid<>(rows, cols);
        CellPosition pos1 = new CellPosition(2, 3);
        CellPosition pos2 = new CellPosition(1, 1);
        String value1 = "Test value 1";
        String value2 = "Test value 2";

        grid.set(pos1, value1);
        grid.set(pos2, value2);

        int nonNullCells = 0;
        for (GridCell<String> cell : grid) {
            nonNullCells++;
            CellPosition cellPos = cell.pos();
            if (cellPos.equals(pos1)) {
                assertEquals(value1, cell.value(), "Grid iterator should return correct value for position 1");
            } else if (cellPos.equals(pos2)) {
                assertEquals(value2, cell.value(), "Grid iterator should return correct value for position 2");
            }
        }

        assertEquals(2, nonNullCells, "Grid iterator should iterate over 2 non-null cells");
    }

}