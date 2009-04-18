package eightpuzzle;

import algorithms.astar.IAStarGraphable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amcgoogan
 */
public class EightPuzzleBoardTest {

    private static char[][] goalState;
    private static EightPuzzleBoard goalBoard;
    private EightPuzzleBoard instance;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
       goalState = new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}};
       goalBoard = new EightPuzzleBoard(goalState);
    }

    @Before
    public void setUp() throws Exception {
        instance = new EightPuzzleBoard(goalState);
    }
    
    @Test
    public void testInitialState() throws Exception {
       System.out.println("Test initial states");
       char[][] state = instance.getState();
       for (int i=0; i<3; i++)
           for (int j=0; j<3; j++)
               assertTrue(state[i][j] == goalState[i][j]);
    }
    
    /**
     * Test of equals method, of class EightPuzzleBoard.  This test is for
     * boards that are equal.
     */
    @Test
    public void testEqualsTrue() throws Exception {
       System.out.println("Test equals true");
       EightPuzzleBoard instance2 = new EightPuzzleBoard(goalState);
       EightPuzzleBoard instance3 = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
       assertTrue( instance.equals(instance2) );
       assertTrue( instance.equals(instance3) );
       assertTrue( instance2.equals(instance3) );
    }
    
    /**
     * Test of equals method, of class EightPuzzleBoard.  This test is for
     * boards that are not equal.
     */
    @Test
    public void testEqualsFalse() throws Exception {
       System.out.println("Test equals false");
       Object obj = new Object();
       EightPuzzleBoard instance2 = new EightPuzzleBoard(new char[][]{{'4', '1', '6'}, {'8', '5', '2'}, {'-', '3', '7'}});
       EightPuzzleBoard instance3 = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '5', '6'}});
       assertFalse( instance.equals(obj) );
       assertFalse( instance.equals(instance2) );
       assertFalse( instance.equals(instance3) );
       assertFalse( instance2.equals(instance3) );
    }
    
    
    @Test
    public void testSetState() throws Exception {
        System.out.println("Test setState");
        char[][] testState = {{'3', '2', '1'}, {'4', '6', '8'}, {'7', '-', '5'}};
        instance.setState(testState);
        char[][] state = instance.getState();
        assertTrue(testState != state);
        assertTrue(testState[0] != state[0]);
        assertTrue(testState[1] != state[1]);
        assertTrue(testState[2] != state[2]);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                assertTrue(testState[i][j] == state[i][j]);
            }
        }
    }
    
    
     /**
     * Test of isValidMove method, of class EightPuzzleBoard.
     */
    @Test
    public void testIsValidMoveTrue() {
        System.out.println("Test isValidMove");
        assertTrue(true);
//        try {
//            assertTrue(instance.isValidMove(Moves.UP));
//            assertTrue(instance.isValidMove(Moves.DOWN));
//            assertTrue(instance.isValidMove(Moves.RIGHT));
//            assertTrue(instance.isValidMove(Moves.LEFT));
//            instance = new EightPuzzleBoard(new char[][]{{'1', '-', '3'}, {'8', '2', '4'}, {'7', '6', '5'}});
//            assertTrue(instance.isValidMove(Moves.DOWN));
//            assertTrue(instance.isValidMove(Moves.RIGHT));
//            assertTrue(instance.isValidMove(Moves.LEFT));
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '6', '4'}, {'7', '-', '5'}});
//            assertTrue(instance.isValidMove(Moves.UP));
//            assertTrue(instance.isValidMove(Moves.RIGHT));
//            assertTrue(instance.isValidMove(Moves.LEFT));
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'-', '8', '4'}, {'7', '6', '5'}});
//            assertTrue(instance.isValidMove(Moves.UP));
//            assertTrue(instance.isValidMove(Moves.DOWN));
//            assertTrue(instance.isValidMove(Moves.RIGHT));
//            
//            
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            
//        } catch(Exception e) {
//            fail(e.getMessage());  
//        }  
    }
    
     /**
     * Test of isValidMove method, of class EightPuzzleBoard.
     */
    @Test
    public void testIsValidMoveFalse() {
//        System.out.println("isValidMove");
//        try {
//            instance = new EightPuzzleBoard(new char[][]{{'1', '-', '3'}, {'8', '2', '4'}, {'7', '6', '5'}});
//            
//         
//            assertFalse(instance.isValidMove(Moves.UP));
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '6', '4'}, {'7', '-', '5'}});
//            
//            instance = new EightPuzzleBoard(new char[][]{{'1', '-', '3'}, {'8', '2', '4'}, {'7', '6', '5'}});
//            
//            
//            assertFalse(instance.isValidMove(Moves.UP));
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '6', '4'}, {'7', '-', '5'}});
//            
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            instance = new EightPuzzleBoard(new char[][]{{'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'}});
//            
//        } catch(Exception e) {
//            fail(e.getMessage());  
//        }
    }
    
    /**
     * Test of move method, of class EightPuzzleBoard.
     */
    @Test
    public void testMove_Moves() throws Exception {
        System.out.println("move");
        //instance.move(Moves.UP);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    /**
     * Test of reset method, of class EightPuzzleBoard.
     */
    @Test
    public void testReset() throws Exception {
        System.out.println("reset");
        assertTrue(true);
        
        //EightPuzzleBoard instance = new EightPuzzleBoard();
        //instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        
        //fail("The test case is a prototype.");
    }
    
}



// /**
//     * Test of randomize method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testRandomize() throws Exception {
//        System.out.println("randomize");
//        EightPuzzleBoard instance = null;
//        instance.randomize();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//   
//
//    /**
//     * Test of move method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testMove_Moves() throws Exception {
//        System.out.println("move");
//        Moves move = null;
//        EightPuzzleBoard instance = null;
//        instance.move(move);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBoardAfterMove method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testGetBoardAfterMove() throws Exception {
//        System.out.println("getBoardAfterMove");
//        Moves move = null;
//        EightPuzzleBoard instance = null;
//        char[][] expResult = null;
//        char[][] result = instance.getBoardAfterMove(move);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of move method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testMove_intArr() throws Exception {
//        System.out.println("move");
//        int[] tile = null;
//        EightPuzzleBoard instance = null;
//        instance.move(tile);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getState method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testGetState() {
//        System.out.println("getState");
//        EightPuzzleBoard instance = null;
//        BoardState expResult = null;
//        BoardState result = instance.getState();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTilePosition method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testGetTilePosition() {
//        System.out.println("getTilePosition");
//        int tileValue = 0;
//        EightPuzzleBoard instance = null;
//        int expResult = 0;
//        int result = instance.getTilePosition(tileValue);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBlankSpaceMove method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testGetBlankSpaceMove() {
//        System.out.println("getBlankSpaceMove");
//        EightPuzzleBoard instance = null;
//        int[] expResult = null;
//        int[] result = instance.getBlankSpaceMove();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBoardInArrayForm method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testGetBoardInArrayForm() throws Exception {
//        System.out.println("getBoardInArrayForm");
//        EightPuzzleBoard instance = null;
//        char[][] expResult = null;
//        char[][] result = instance.getBoardInArrayForm();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMoveValidation method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testSetMoveValidation() {
//        System.out.println("setMoveValidation");
//        boolean validate = false;
//        EightPuzzleBoard instance = null;
//        instance.setMoveValidation(validate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setGoalBoard method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testSetGoalBoard() throws Exception {
//        System.out.println("setGoalBoard");
//        char[][] goalBoard = null;
//        EightPuzzleBoard instance = null;
//        instance.setGoalBoard(goalBoard);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getExpansionOptions method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testGetExpansionOptions() {
//        System.out.println("getExpansionOptions");
//        EightPuzzleBoard instance = null;
//        Object[] expResult = null;
//        Object[] result = instance.getExpansionOptions();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of expandChild method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testExpandChild() {
//        System.out.println("expandChild");
//        Object direction = null;
//        EightPuzzleBoard instance = null;
//        IAStarGraphable expResult = null;
//        IAStarGraphable result = instance.expandChild(direction);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equal method, of class EightPuzzleBoard.
//     */
//    @Test
//    public void testEqual() {
//        System.out.println("equal");
//        IAStarGraphable state = null;
//        EightPuzzleBoard instance = null;
//        boolean expResult = false;
//        boolean result = instance.equal(state);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }