/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eightpuzzle;

/**
 *
 * @author amcgoogan
 */
public class TileMoveEvent extends EightPuzzleBoardEvent {
    private int[] tilePosition;
    
    public TileMoveEvent(Object source, BoardEvent event, int[] tilePosition) {
        super(source, event);
        this.tilePosition = tilePosition;
    }
    
    public int[] getTilePosition() {
        return new int[2];
    }
}
