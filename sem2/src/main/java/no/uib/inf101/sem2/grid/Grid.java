package no.uib.inf101.sem2.grid;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<E> implements IGrid<E>{

    private List<List<E>> grid;


    public Grid(int rows, int cols) {
        this.grid = new ArrayList<>();
        for (int i = 0; i < rows ; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                grid.get(i).add(null);
            }
        }
    }

    public Grid(int rows, int cols, E defaultValue) {
        this.grid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                if (defaultValue == null) {
                    grid.get(i).add(null);
                } else {
                    grid.get(i).add(defaultValue);
                }
            }
        }
    }


    @Override
    public void set(CellPosition pos, E value) {
        grid.get(pos.row()).set(pos.col(), value);
    }

    @Override
    public E get(CellPosition pos) {
        return grid.get(pos.row()).get(pos.col());
    }

    @Override
    public boolean positionIsOnGrid(CellPosition pos) {
        int row = pos.row();
        int col = pos.col();
        return col >= 0 && col < cols() && row >= 0 && row < rows();
    }

    @Override
    public Iterator<GridCell<E>> iterator() {
        List<GridCell<E>> flattenedList = new ArrayList<>();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                E value = get(new CellPosition(i, j));
                if (value != null) {
                    flattenedList.add(new GridCell<>(new CellPosition(i, j), value));
                }
            }
        }
        return flattenedList.iterator();
    }


    @Override
    public int rows() {
        return grid.size();
    }

    @Override
    public int cols() {
        return grid.get(0).size();
    }
}

