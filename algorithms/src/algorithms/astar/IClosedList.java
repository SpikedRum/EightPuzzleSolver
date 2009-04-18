package algorithms.astar;

/**
 *
 * @author amcgoogan
 */
public interface IClosedList {
    void add(AStarNode node);
    boolean contains(AStarNode node);
}
