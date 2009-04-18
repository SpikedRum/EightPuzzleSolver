package eightpuzzle;

public class EightPuzzleTile extends javax.swing.JLabel implements ITile {
    private char value;
    
    public EightPuzzleTile(char pValue, javax.swing.ImageIcon pImageIcon)
    {
        super( pImageIcon );
        value = pValue;
    }
    
    public char getValue()
    {
        return value;
    }
    
}
