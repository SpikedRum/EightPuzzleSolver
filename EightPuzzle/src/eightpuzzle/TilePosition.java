package eightpuzzle;

/**
 *
 * @author amcgoogan
 */
public class TilePosition {
    private int row;
    private int col;
    private int listPosition;
    
    public TilePosition(int listPosition) {
        this.listPosition = listPosition;
        this.row = listPosition / 3;
        this.col = listPosition % 3;
    }
    
    public TilePosition(int row, int col) {
        this.row = row;
        this.col = col;
        this.listPosition = (this.row * 3) + this.col;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public int getListPosition() {
        return listPosition;
    }
    
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        TilePosition temp = (TilePosition)obj;
        if(temp.getRow() == this.getRow() && temp.getCol() == this.getCol())
            return true;
        else
            return false;
    }
}