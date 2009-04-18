package algorithms.astar;

/**
 *
 * @author amcgoogan
 */
public interface IHeuristic {

    int score(Object o, Object[] args);
    
}
