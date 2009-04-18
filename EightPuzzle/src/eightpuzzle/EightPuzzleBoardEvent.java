package eightpuzzle;

import java.util.EventObject;

enum BoardEvent { RESET, RANDOMIZED, TILE_MOVED };
/**
 *
 * @author amcgoogan
 */
public class EightPuzzleBoardEvent extends EventObject {
    private BoardEvent theEvent;
    
    public EightPuzzleBoardEvent(Object source, BoardEvent event) {
        super(source);
        theEvent = event;
    }
    
    public BoardEvent getEvent() {
        return theEvent;
    }
    
}
