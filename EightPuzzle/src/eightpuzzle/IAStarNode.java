// Need To Crate and algorithms package and move in there


package eightpuzzle;


// Use a priority  open list????
// lowest weighed nodes takes priority?


// EightPuzzleBoard should implement this??
// interface IAStarGraphable { }
// public IAStarGraphable[] expandChildren();
// public boolean isGoalState();
// Dont want to repeat a previous state. Check each node against the closed list before adding to the open list.
// boolean isEqualState(IAStarGraphable o);

// IHeuristic
// h in f = g + h.
// public int getHeuristicWeight(IHeuristic heuristic) { return heuristic.weigh( this.getArrayForm() ); };


// Interface IHeuristic {
//     int weigh(Object o);
// }


// class AStarSolution
// path
// executiuon time
// total board states investigated
// other stats??

// Need to use open and closed lists.


/**
 *
 * 
 * Or a different object that can keep track of the moves?
 * 
 * 
 * no interface needed, just make a class???
 * g is depth in f = g + h.
 * public class AStarNode(IAStarGraphable graphable, AStarNode parent, int g)
 */

public interface IAStarNode {

    public IAStarNode getParent();
    public boolean isGoalState();
    // f in f = g + h.
    public int f(); 
}
