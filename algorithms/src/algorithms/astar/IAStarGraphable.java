package algorithms.astar;

/**
 *
 * @author amcgoogan
 */
public interface IAStarGraphable {
    
    /**
     * Retrieve a collection of options that can be used to expand the current
     * graph state.  The algorithms will keep the 
     * @return Expansion options for current state.
     */
     Object[] getMoves();
     
     /**
      * Returns an instance of an IAStarGraphable object that has the current 
      * IAStarGraphable state modified by the passed move.
      * the this graph in the passed direction. 
      * @param Move to be made on the current instances state.
      * @return An instance of an IAStarGraphable item with the passed move performed.
      */
     IAStarGraphable makeMove(Object move);
}
