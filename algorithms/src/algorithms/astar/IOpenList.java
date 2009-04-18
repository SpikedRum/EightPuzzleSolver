package algorithms.astar;

/**
 *
 * @author amcgoogan
 */
public interface IOpenList {

    /**
     * Returns the next element of the OpenList or null
     * if the list is empty.
     * @return next AStarNode
     */
    AStarNode getNext();
    
    
    boolean isEmpty();
    
    int indexOf(AStarNode node);
    
    /**
     * Add the node into the OpenList.
     * @param node
     */
    void add(AStarNode node);
    
    /**
     * Replace the Node at the specified position.
     * @param index
     * @param node
     */
    void replace(int index, AStarNode node);
    
}
