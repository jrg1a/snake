package no.uib.inf101.sem2.grid;



public class CellPosition {
    private int row;
    private int col;

    public CellPosition(int row, int col) {
        this.row = row;
        this.col = col;

    }
    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CellPosition)) {
            return false;
        }
        CellPosition other = (CellPosition) obj;
        return this.row == other.row && this.col == other.col;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }

}

