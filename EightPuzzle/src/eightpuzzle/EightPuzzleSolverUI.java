/**
 * @author  Andrew McGoogan
 * @date    September 1, 2008
 * 
 * Eight Puzzle Solver:
 * Implements a graphical user interface and algorithm for solving the
 * eight puzzle game.....
 */

package eightpuzzle;

import javax.swing.*;
import java.io.*;

public class EightPuzzleSolverUI extends javax.swing.JFrame {
    
    /** Creates new form EightPuzzleUI */
    public EightPuzzleSolverUI() 
    {
        initComponents();
        
        //Set game log as uneditable.
        this.txtGameLog.setEditable(false);
        //Set initial show log state to false.
        this.setSize(formWidth, formHeightHideLog);
        pGameLog.setVisible(false);
        
        String s = System.getProperty("user.dir");
        this.txtGameLog.setText(s);
        
        fc.setDialogTitle("Select the file information to save game log to.");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pGameLog = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGameLog = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnClearStats = new javax.swing.JButton();
        theBoardUI = new eightpuzzle.EightPuzzleBoardUI();
        cbEnforceValidMoves = new javax.swing.JCheckBox();
        btnSolve = new javax.swing.JButton();
        btnRandomize = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnToggleLog = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        mbMainMenu = new javax.swing.JMenuBar();
        jmMenu = new javax.swing.JMenu();
        miResetBoard = new javax.swing.JMenuItem();
        miSaveLog = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        miClose = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eight Puzzle Solver");

        pGameLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Game Log:"));

        txtGameLog.setColumns(20);
        txtGameLog.setRows(5);
        txtGameLog.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(txtGameLog);

        javax.swing.GroupLayout pGameLogLayout = new javax.swing.GroupLayout(pGameLog);
        pGameLog.setLayout(pGameLogLayout);
        pGameLogLayout.setHorizontalGroup(
            pGameLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGameLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        pGameLogLayout.setVerticalGroup(
            pGameLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGameLogLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistics"));

        btnClearStats.setText("Clear");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(btnClearStats)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addComponent(btnClearStats)
                .addContainerGap())
        );

        theBoardUI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbEnforceValidMoves.setText("Enforce valid user moves");

        btnSolve.setText("Solve");

        btnRandomize.setText("Randomize");
        btnRandomize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomizeMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Nimbus Mono L", 1, 36));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Eight Puzzle Solver");

        btnToggleLog.setBackground(javax.swing.UIManager.getDefaults().getColor("controlHighlight"));
        btnToggleLog.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.foreground"));
        btnToggleLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-down.jpg"))); // NOI18N
        btnToggleLog.setText(" Show Log");
        btnToggleLog.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnToggleLog.setIconTextGap(10);
        btnToggleLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleLogActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        jmMenu.setText("Menu");

        miResetBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Undo-16x16.png"))); // NOI18N
        miResetBoard.setText("Reset Board");
        miResetBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                miResetBoardMousePressed(evt);
            }
        });
        jmMenu.add(miResetBoard);

        miSaveLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Floppy-16x16.png"))); // NOI18N
        miSaveLog.setText("Save Log");
        miSaveLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                miSaveLogMousePressed(evt);
            }
        });
        jmMenu.add(miSaveLog);
        jmMenu.add(jSeparator1);

        miClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Close-16x16.png"))); // NOI18N
        miClose.setText("Close");
        miClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                miCloseMousePressed(evt);
            }
        });
        jmMenu.add(miClose);

        mbMainMenu.add(jmMenu);

        jmEdit.setText("Edit");

        jMenuItem5.setText("Goal Board");
        jmEdit.add(jMenuItem5);

        jMenuItem4.setText("Delay");
        jmEdit.add(jMenuItem4);

        mbMainMenu.add(jmEdit);

        jmHelp.setText("Help");

        jMenuItem7.setText("Help");
        jmHelp.add(jMenuItem7);

        jMenuItem6.setText("About");
        jmHelp.add(jMenuItem6);

        mbMainMenu.add(jmHelp);

        setJMenuBar(mbMainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbEnforceValidMoves)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReset))
                                    .addComponent(theBoardUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnRandomize, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pGameLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnToggleLog, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(theBoardUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEnforceValidMoves)
                            .addComponent(btnReset))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRandomize)
                    .addComponent(btnSolve))
                .addGap(30, 30, 30)
                .addComponent(btnToggleLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pGameLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnToggleLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleLogActionPerformed
    boolean showLog = !pGameLog.isVisible();
    this.setSize(formWidth, (showLog ? formHeightShowLog : formHeightHideLog));
    pGameLog.setVisible(showLog);
    btnToggleLog.setText(showLog ? "Hide Log" : "Show Log");
    btnToggleLog.setIcon(new javax.swing.ImageIcon( this.getClass().getResource(showLog ? "/images/arrow-up.jpg" : "/images/arrow-down.jpg") ));
}//GEN-LAST:event_btnToggleLogActionPerformed

private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
    if ( theBoardUI != null)
        theBoardUI.reset();
}//GEN-LAST:event_btnResetMouseClicked

private void btnRandomizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomizeMouseClicked
    if ( theBoardUI != null)
        theBoardUI.randomize();
}//GEN-LAST:event_btnRandomizeMouseClicked

/**
 * Exit the eight puzzle application.
 * @param evt
 */
private void miCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miCloseMousePressed
    System.exit(0);
}//GEN-LAST:event_miCloseMousePressed

/**
 * 
 * @param evt
 */
private void miSaveLogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miSaveLogMousePressed
    fc.setSelectedFile(new File("EightPuzzle.log")); //Set default filename and location.
    int returnVal = fc.showSaveDialog(jmMenu);
    if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
        FileWriter out = null;
        try {
            File f = fc.getSelectedFile();
            out = new FileWriter(f);
            out.write(this.txtGameLog.getText());
        } catch (IOException ioe) {
            // TODO: If error logging enabled log.
        } catch (Exception ex) {
            // TODO: If error logging enabled log.
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException ioe) {
                // TODO: If error logging enabled log.
                ioe.printStackTrace();
            }
        }
    }
}//GEN-LAST:event_miSaveLogMousePressed

private void miResetBoardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miResetBoardMousePressed
    if ( theBoardUI != null)
        theBoardUI.reset();
}//GEN-LAST:event_miResetBoardMousePressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final JFrame frm = new EightPuzzleSolverUI(); 
                
                //TODO: Way to center frame on screen.
                
                frm.setVisible(true);
            }
        });
    }
    
    
    private static final int formWidth = 750;
    private static final int formHeightShowLog = 910;
    private static final int formHeightHideLog = 615;
    private final javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearStats;
    private javax.swing.JButton btnRandomize;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSolve;
    private javax.swing.JButton btnToggleLog;
    private javax.swing.JCheckBox cbEnforceValidMoves;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmMenu;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar mbMainMenu;
    private javax.swing.JMenuItem miClose;
    private javax.swing.JMenuItem miResetBoard;
    private javax.swing.JMenuItem miSaveLog;
    private javax.swing.JPanel pGameLog;
    protected eightpuzzle.EightPuzzleBoardUI theBoardUI;
    private javax.swing.JTextArea txtGameLog;
    // End of variables declaration//GEN-END:variables

}