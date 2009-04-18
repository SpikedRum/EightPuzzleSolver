package eightpuzzle;

import algorithms.astar.*;
import java.util.*;

/**
 * State is kept in Array form:
 *            
 *            Cols
 *              0    1     2
 *            ----------------
 *    Rows 0  |    |    |    |
 *            |    |    |    |
 *            ----------------
 *         1  |    |    |    |
 *            |    |    |    |
 *            ----------------
 *         2  |    |    |    |
 *            |    |    |    |
 *            ----------------
 *
 * @author amcgoogan
 */
public class EightPuzzleBoard extends Observable implements IEightPuzzleBoard, IAStarGraphable {
    private static final char[] VALID_BOARD_VALUES = {'1', '2', '3', '4', '5', '6', '7', '8', '-'};
    private char[][] currentState; 
    private TilePosition blankSlotPosition;

    public EightPuzzleBoard() throws EightPuzzleBoardException {
        this(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
    }
    
    public EightPuzzleBoard(char[][] state) throws EightPuzzleBoardException {
        setState(state);
    }
    
    /**
     * Randomizes the board by making 100 random moves. 
     * If require valid move is selected the random moves are
     * based around the empty slot.  Otherwise any two random
     * positions can be swapped. 
     */
    public void randomizeState() throws EightPuzzleBoardException {
        Random generator = new Random();
        for (int i = 0; i < 200; i++) {
            TilePosition[] neighborPositions = getNeighborPositions(blankSlotPosition);
            swapTilePositions(blankSlotPosition, neighborPositions[generator.nextInt(neighborPositions.length)]);
        }
        setChanged();
        EightPuzzleBoardEvent event = new EightPuzzleBoardEvent(this, BoardEvent.RANDOMIZED);
        notifyObservers(event);
    }
    
    /**
     * Move will take the TilePosition of a tile and swap it with the blank slot position.
     * @param position
     * @throws eightpuzzle.EightPuzzleBoardException
     */
    public void moveTileAt(TilePosition position) throws EightPuzzleBoardException {
       moveTileAt(position, true);
    }
    
    public void moveTileAt(TilePosition position, boolean enforceValidMoves) throws EightPuzzleBoardException {
        if(enforceValidMoves) {
            if(isValidMove(position)) {
                swapTilePositions(position, blankSlotPosition);
            }
            else {
                throw new EightPuzzleBoardException("Invalid move attempted to be made.");
            }
        } 
        else {
            swapTilePositions(position, blankSlotPosition);
        }
        setChanged();
        Object[] args = null; // TileMoveEvent; {state, theBoard};
        notifyObservers(args);
    }
    
    protected void swapTilePositions(TilePosition pos1, TilePosition pos2) {
        char temp = currentState[pos2.getRow()][pos2.getCol()];
        currentState[pos2.getRow()][pos2.getCol()] = currentState[pos1.getRow()][pos1.getCol()];
        currentState[pos1.getRow()][pos1.getCol()] = temp;
        if ( pos1.equals(blankSlotPosition) )
            blankSlotPosition = pos2;
        else if ( pos2.equals(blankSlotPosition) )
            blankSlotPosition = pos1;
    }
    
    public int getTilePosition(int tileValue) {
        return 0;
    }

   public char[][] getState() {
        return currentState;
   }
    
    public void setState(char[][] state) throws EightPuzzleBoardException {
        validateBoard(state);
        currentState = deepCopy(state);
        
        //Find the blank slot and reference its position.
        for (int row=0; row<3; row++)
            for(int col=0; col<3; col++)
                if (currentState[row][col] == '-')
                    blankSlotPosition = new TilePosition(row, col);
                    
        setChanged();
        EightPuzzleBoardEvent event = new EightPuzzleBoardEvent(this, BoardEvent.RESET);
        notifyObservers(event);
    }

    /**
     * Validates that there is one blank slot and the numbers 1-8
     * on the board.
     * @param board
     * @throws eightpuzzle.EightPuzzleBoardException
     */
    private void validateBoard(char[][] board) throws EightPuzzleBoardException {
    }
    
    // IAStarGraphable Methods.
    public Object[] getMoves() {
        return Moves.values();
    }
    
    // Returns null if expansion direction passed is not possible.
    public IAStarGraphable makeMove(Object move) {
        EightPuzzleBoard expandedBoard;
        try {
            expandedBoard = new EightPuzzleBoard(currentState);
            expandedBoard.moveTileAt((TilePosition)move, true);
        } catch (Exception ex) {
            expandedBoard = null;
        }
        return expandedBoard;
    }
    
    public boolean equals(Object obj) {
        if( obj == null || obj.getClass() != this.getClass())
            return false;
        char[][] tempState = ((EightPuzzleBoard)obj).getState();
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(tempState[i][j] != this.currentState[i][j])
                    return false;
        return true;
    }
    
    // Make private after unit testing.
    public static char[][] deepCopy(final char[][] original) {
        char[][] copy = new char[3][3];
        for (int i=0; i<3; i++)
            copy[i] = Arrays.copyOf(original[i], 3);
        return copy;
    }
    
    private static TilePosition[] getNeighborPositions(TilePosition position) throws EightPuzzleBoardException {
        ArrayList<TilePosition> list = new ArrayList<TilePosition>();
        if(position.getRow() < 0 || position.getRow() > 2 || position.getCol() < 0 || position.getCol() > 2)
            throw new EightPuzzleBoardException("Invalid row/column TilePosition values passed to retrieveNeighborPositions!");
        if( (position.getRow()-1) >= 0 )
            list.add(new TilePosition(position.getRow()-1, position.getCol()));
        if( (position.getRow()+1) <= 2 )
            list.add(new TilePosition(position.getRow()+1, position.getCol()));
        if( (position.getCol()-1) >= 0 )
            list.add(new TilePosition(position.getRow(), position.getCol()-1));
        if( (position.getCol()+1) <= 2 )
            list.add(new TilePosition(position.getRow(), position.getCol()+1));
        return list.toArray(new TilePosition[0]);
    }
    
     /**
     * A valid move would be a tile position that borders the blank slot position.
     * @param position
     * @return valid
     */
    public boolean isValidMove(TilePosition position) {
       return true;
    }
}




// All moves are based on the direction the empty slot is moving.
    /**
     * for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                protoDeck.add(new Card(rank, suit));

     */



//    public void move(Moves move) throws EightPuzzleBoardException {
//        if (state == BoardState.INVALID) {
//            throw new EightPuzzleBoardException("Board is in an invalid state!", state);
//        }
//        if (!isValidMove(move)) {
//            throw new EightPuzzleBoardException("Invalid move attempted!", state);
//        }
//        char[][] tempBoard = getBoardAfterMove(move);
//        if(tempBoard != null) {
//            theBoard = tempBoard;
//            // TODO:  Set blank slot position and Update UI!!!!
//        }
//        else {
//            state = BoardState.INVALID;
//            throw new EightPuzzleBoardException("An unknown exception occured will attempting to make move.", state);
//        }
//    }




 /**
  * Reset to board goal state.
  */
//    public void reset() throws EightPuzzleBoardException {
//        if (state == BoardState.INVALID) {
//            throw new EightPuzzleBoardException("Board is in an invalid state!", state);
//        }
//        for (int y = 0; y < 3; y++) {
//            for (int x = 0; x < 3; x++) {
//                theBoard[y][x] = goalBoard[y][x];
//            }
//        }
//        setBlankSlotPosition();
//        state = BoardState.RESET;
//        setChanged();
//        Object[] args = {state, theBoard};
//        notifyObservers(args);
//    }



//    private void setBlankSlotPosition() throws EightPuzzleBoardException { 
//        for (int y = 0; y < 3; y++) {
//            for (int x = 0; x < 3; x++) {
//                if ('-' == currentState[y][x]) {
//                    this.blankSlotPosition = new int[]{y, x};
//                    return;
//                }
//            }
//        }
//        throw new EightPuzzleBoardException("Eight Puzzle Board Missing Blank Slot!", state);
//    }