package algorithms.astar;

import java.util.*;

/**
 *
 * @author amcgoogan
 */
public class ClosedLinkedList implements IClosedList {
    
    protected LinkedList<AStarNode> list;
    
    public ClosedLinkedList() {
        list = new LinkedList<AStarNode>();
    }

    public void add(AStarNode node) {
        list.add(node);
    }
    
    public boolean contains(AStarNode node) {
        return true;
    }
    
}