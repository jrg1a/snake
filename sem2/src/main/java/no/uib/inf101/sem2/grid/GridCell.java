package no.uib.inf101.sem2.grid;


import java.util.Objects;

public class GridCell<E> {
    private final CellPosition pos;
    private final E value;

    public GridCell(CellPosition pos, E value) {
        this.pos = pos;
        this.value = value;
    }

    public CellPosition pos() {
        return pos;
    }

    public E value() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCell<?> gridCell = (GridCell<?>) o;
        return Objects.equals(pos, gridCell.pos) && Objects.equals(value, gridCell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, value);
    }



}
