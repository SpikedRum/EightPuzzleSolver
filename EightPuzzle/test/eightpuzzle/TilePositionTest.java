/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eightpuzzle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amcgoogan
 */
public class TilePositionTest {
    
   @Test
    public void testGetListPosition() {
        System.out.println("getListPosition");
        char[][] listPositionCorrespondence = {{0, 1, 2},
                                               {3, 4, 5},
                                               {6, 7, 8}};
        
        for (int row=0; row<3; row++)
            for(int col=0; col<3; col++) {
                TilePosition instance = new TilePosition(row, col);
                assertTrue(instance.getListPosition() == listPositionCorrespondence[row][col]);
            }
    }

}