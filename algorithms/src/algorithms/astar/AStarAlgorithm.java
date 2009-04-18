package algorithms.astar;

/**
 *
 * @author amcgoogan
 */
public class AStarAlgorithm {
    
    public static void solve(IAStarGraphable initialState, IAStarGraphable goalState, IHeuristic heuristic) {
        solve(initialState, goalState, heuristic, new OpenLinkedList(), new ClosedLinkedList());
    }
    
    /**
     * TODO: Have the lists be dynamic classes instantiated from the types passed as parameter?
     * @param initialState
     * @param goalState
     * @param heuristic
     * @param openList
     * @param closedList
     */
    public static void solve(IAStarGraphable initialState, IAStarGraphable goalState, IHeuristic heuristic, IOpenList openList, IClosedList closedList) {
       
        
        
    }

}
