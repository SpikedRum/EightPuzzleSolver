package algorithms.astar;

import java.util.*;

/**
 * OpenLinkedList implements an open list for the A-Star search algorithm using
 * a linked list as its core data structure. 
 * @author amcgoogan
 */
public class OpenLinkedList implements IOpenList {

    protected LinkedList list;
    
    public OpenLinkedList() {
        list = new LinkedList();
    }
    
    public AStarNode getNext() {
        AStarNode next;
        try {
            next = (AStarNode)list.getFirst();
            // list.removeFirst(); // need to remove next from list?
        } catch (NoSuchElementException e) {
           next = null;
        }
        return next;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int indexOf(AStarNode node) {
        for(int i=0; i<list.size(); i++) {
            if( ((AStarNode)list.get(i)).equals(node) )
                return i;
        }
        return -1;
    }
    
    public void add(AStarNode node) {
        boolean inserted = false;
        for(int i=0; i<list.size(); i++) {
            if( ((AStarNode)list.get(i)).f() > node.f() ) {
                list.add(i, node);
                inserted = true;
            }
        }
        if (!inserted) //Append to end of list.
            list.addLast(node);
    }
    
    public void replace(int index, AStarNode node) {
        list.remove(index);
        list.add(index, node);
    }
    
}
