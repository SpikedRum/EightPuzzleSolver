package eightpuzzle;

enum Moves {UP, DOWN, LEFT, RIGHT}; // Moves are based on the blank tile space's movement.

public interface IEightPuzzleBoard {    
    
    /**
     * Randomize the boards state.
     */
    void randomizeState() throws EightPuzzleBoardException;
    
    /**
     * Moves the tile in the passed position to the empty slot position.  If the
     * position passed as a parameter is the empty slot position or if the board 
     * state is INVALID then an EightPuzzleBoardException will be thrown. 
     */
    void moveTileAt(TilePosition position) throws EightPuzzleBoardException;
    
    
    /**
     * Moves the tile in the passed position to the empty slot position.  If the
     * position passed as a parameter is the empty slot position or if the board 
     * state is INVALID then an EightPuzzleBoardException will be thrown. 
     */
    void moveTileAt(TilePosition position, boolean enforceValidMoves) throws EightPuzzleBoardException;
    
    /**
     * Return whether the specified move of the blank tile is valid.
     */
    boolean isValidMove(TilePosition position);
    
    char[][] getState();
    
    void setState(char[][] defaultBoard) throws EightPuzzleBoardException;
  
}
