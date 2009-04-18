package algorithms.astar;

import java.util.*;

/**
 *
 * @author amcgoogan
 */
public class AStarNode {
    
    private AStarNode parent;
    private IAStarGraphable nodeState;
    private int g;
    private Object move; 
    
    /**
     * Create a new instance of AStarNode.  This condtructor is used
     * to create an instance of root nodes.
     * @param graphable
     * @param g
     */
    public AStarNode(IAStarGraphable graphable, int g) {
        this(graphable, null, g);
    }
    
    /**
     * Create a new instance of AStarNode.
     * @param graphable
     * @param parent
     * @param g
     */
    public AStarNode(IAStarGraphable graphable, AStarNode parent, int g) {
        this.nodeState = graphable;
        this.parent = parent;
        this.g = g;
    }
    
    /**
     * The parent to this node.  The parent will be null for root node.
     * @return this.parent
     */
    public AStarNode getParent() {
        return parent;
    }
    
    /**
     * Returns the state path from the initial (root node) state to this
     * ASTarNode's state.
     * @return path
     */
    public List getPath() {
        LinkedList path = new LinkedList();
        AStarNode node = this;
        while( node != null ) {
            path.addFirst(node);
            node = node.getParent();
        }
        return path;
    }
    
    public IAStarGraphable getState() {
        return nodeState;
    }
    
    public Object getMove() {
        return move;
    }
    
    public boolean isStateEqual(IAStarGraphable state) {
        return nodeState.equals(state);
    }
        
    // f in f = g + h.
    public int f() {
        return 0;
    }

}
