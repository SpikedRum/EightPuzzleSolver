package eightpuzzle;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/** 
 * @author Andrew McGoogan
 * @date   September 1, 2008
 * 
 * User Interface to an eight puzzle board with drag and drop tiles.
 */
public class EightPuzzleBoardUI extends JLayeredPane implements Observer {

    private IEightPuzzleBoard theBoard;
    private JPanel boardPanel;
    private JLabel selectedTile;
    private JPanel selectedTileParent;
    private JPanel emptySlot;
    private int xAdjustment;
    private int yAdjustment;
    private char[][] goalState;

    public EightPuzzleBoardUI() {
        super();
        initializeUI();
        setListeners();
        
        // Need to read from preferences...
        goalState = new char[][]{ {'1', '2', '3'}, {'8', '-', '4'}, {'7', '6', '5'} };
        
        try {
            theBoard = new EightPuzzleBoard( goalState );
            ((Observable)theBoard).addObserver(this);
            theBoard.setState(goalState);
        } catch (Exception e) {
            handleException(e);
        }
    }

    protected void initializeUI() {
        Dimension boardSize = new Dimension(300, 300);
        setPreferredSize(boardSize);

        boardPanel = new JPanel();
        add(boardPanel);
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setPreferredSize(boardSize);
        boardPanel.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 9; i++) {
            JPanel square = new JPanel(new BorderLayout());
            boardPanel.add(square);
            square.setBackground(Color.black);
        }

        // Add game tiles
        JPanel panel = (JPanel) boardPanel.getComponent(0);
        panel.add(new EightPuzzleTile('1', new javax.swing.ImageIcon(getClass().getResource("/images/tile_one.gif"))));
        panel = (JPanel) boardPanel.getComponent(1);
        panel.add(new EightPuzzleTile('2', new javax.swing.ImageIcon(getClass().getResource("/images/tile_two.gif"))));
        panel = (JPanel) boardPanel.getComponent(2);
        panel.add(new EightPuzzleTile('3', new javax.swing.ImageIcon(getClass().getResource("/images/tile_three.gif"))));
        panel = (JPanel) boardPanel.getComponent(5);
        panel.add(new EightPuzzleTile('4', new javax.swing.ImageIcon(getClass().getResource("/images/tile_four.gif"))));
        panel = (JPanel) boardPanel.getComponent(8);
        panel.add(new EightPuzzleTile('5', new javax.swing.ImageIcon(getClass().getResource("/images/tile_five.gif"))));
        panel = (JPanel) boardPanel.getComponent(7);
        panel.add(new EightPuzzleTile('6', new javax.swing.ImageIcon(getClass().getResource("/images/tile_six.gif"))));
        panel = (JPanel) boardPanel.getComponent(6);
        panel.add(new EightPuzzleTile('7', new javax.swing.ImageIcon(getClass().getResource("/images/tile_seven.gif"))));
        panel = (JPanel) boardPanel.getComponent(3);
        panel.add(new EightPuzzleTile('8', new javax.swing.ImageIcon(getClass().getResource("/images/tile_eight.gif"))));
        emptySlot = (JPanel) boardPanel.getComponent(4);
    }

    /**
     * Add listeners for tile drag and drop.
     */
    protected void setListeners() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boardMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

            public void mouseDragged(java.awt.event.MouseEvent evt) {
                boardMouseDragged(evt);
            }
        });
    }

    protected void boardMousePressed(java.awt.event.MouseEvent evt) {
        selectedTile = null;
        Component c = findComponentAt(evt.getX(), evt.getY());

        if (c instanceof JPanel) {
            return;
        }
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - evt.getX();
        yAdjustment = parentLocation.y - evt.getY();
        selectedTile = (JLabel) c;
        selectedTileParent = (JPanel) selectedTile.getParent();
        selectedTile.setLocation(evt.getX() + xAdjustment, evt.getY() + yAdjustment);
        selectedTile.setSize(selectedTile.getWidth(), selectedTile.getHeight());
        add(selectedTile, JLayeredPane.DRAG_LAYER);
    }

    protected void boardMouseDragged(java.awt.event.MouseEvent evt) {
        if (selectedTile == null) {
            return;
        }
        selectedTile.setLocation(evt.getX() + xAdjustment, evt.getY() + yAdjustment);
    }

    protected void boardMouseReleased(java.awt.event.MouseEvent evt) {
        if (selectedTile == null) {
            return;
        }
        Component c = boardPanel.findComponentAt(evt.getX(), evt.getY());
        selectedTile.setVisible(false);

        if (c instanceof JPanel && c == emptySlot) {
            Container parent = (Container) c;
            parent.add(selectedTile);
            emptySlot = selectedTileParent;
        } else {
            selectedTileParent.add(selectedTile);
        }
        selectedTile.setVisible(true);
    }
    
    public void reset() {
        try {
            theBoard.setState(goalState);
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void randomize() {
        try {
            theBoard.randomizeState();
        } catch (Exception e) {
            handleException(e);
        }
    }
    
    public void update(Observable o, Object arg) {
        if (o == theBoard) {
            EightPuzzleBoardEvent boardEvent = ((EightPuzzleBoardEvent)arg);
            if (boardEvent.getEvent() == BoardEvent.RESET || boardEvent.getEvent() == BoardEvent.RANDOMIZED) {
                setBoard( ((EightPuzzleBoard)o).getState() );
            }
            else if(boardEvent.getEvent() == BoardEvent.TILE_MOVED) {
                
            }
        }
    }
    
    protected void setBoard(char[][] board) {
        for(int i=0; i<9; i++) {
            char tileValue = board[(i/3)][(i%3)];
            
            // Ignore Blank Space.
            if (tileValue == '-')
                continue;
            
            int tilePosition = findTilePosition(tileValue);
            
            JLabel tile1 = (JLabel)((JPanel)boardPanel.getComponent(tilePosition)).getComponent(0);
            JLabel tile2 = null;
            if( (JPanel)boardPanel.getComponent(i) != emptySlot )
                tile2 = (JLabel)((JPanel)boardPanel.getComponent(i)).getComponent(0);
                
            ((JPanel)boardPanel.getComponent(tilePosition)).removeAll();
            ((JPanel)boardPanel.getComponent(i)).removeAll();
            
            if(tile2 != null)
                ((JPanel)boardPanel.getComponent(tilePosition)).add(tile2);
            else
                emptySlot = (JPanel)boardPanel.getComponent(tilePosition);
            ((JPanel)boardPanel.getComponent(i)).add(tile1);    
        }
        boardPanel.updateUI();
    }
    
    protected int findTilePosition(char tileValue) {
        int tilePosition = -1;
        for(int i=0; i<9; i++) {
            JPanel panel = (JPanel) boardPanel.getComponent(i);
            if (emptySlot == panel && tileValue == '-') {
                 tilePosition = i;
                 break;
            }
            else if (emptySlot == panel) {
                continue;
            }
            else {
                ITile tile = (ITile)panel.getComponent(0);
                if (tile.getValue() == tileValue) {
                    tilePosition = i;
                    break;
                }
            }
        }
        return tilePosition;
    }
    
    protected void handleException(Exception e) {
        
    }
}
