import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CheckersPanel extends JPanel {

    private JButton[][] board;
    private CheckersModel model;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuItem resetGame;
    private JButton undoMove;
    private JButton basicRules;
    private String theRules;
    private listener listener;
    private boolean firstHalfDone = false;
    private boolean secondHalfDone = false;
    private int fromRow;
    private int fromColumn;
    private int toRow;
    private int toColumn;
    private JPanel checkerPanel;
    private JPanel buttonPanel;

    public CheckersPanel(){

        undoMove = new JButton("Undo last move!");
        basicRules = new JButton("Click here for a short rules update!");
        theRules = "1.) Rock, Paper, Scissors to see who goes first! \n" +
                "2.) Whoever wins the RPS, begins by moving any of their pieces from the front \n" +
                " row one space diagonally to the left or right towards the opposite player! \n" +
                "3.) Capturing may only be done diagonally with forward motion, unless King'd,\n" +
                " then you may capture forwards and backwards diagonally! \n" +
                "4.) As soon as one of your checkers reaches the first row of your opponents,\n" +
                "it becomes a King!\n" + "5.) Regardless of royalty, if all adjacent sides of your\n" +
                " piece are occupied by your opponent's pieces... You may not move that piece.\n" +
                " It has been locked, and cannot move until an adjacent side has been opened up.";

        board = new JButton[8][8];
        listener = new listener();
        checkerPanel = new JPanel();
        buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setSize(new Dimension(150, 150));
        undoMove.setPreferredSize(new Dimension(150, 40));
        basicRules.setPreferredSize(new Dimension(230, 40));

        add(undoMove, buttonPanel);
        add(basicRules, buttonPanel);
        checkerPanel.setLayout(new GridLayout
                (8, 8, 1, 1));
        checkerPanel.setSize(new Dimension(400, 400));

        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                board[r][c] = new JButton("", null);
                board[r][c].addActionListener(listener);
                checkerPanel.add(board[r][c]);
                board[r][c].setPreferredSize(new Dimension(75, 75));
                setBackgroundColor(r, c);
            }

        GridBagConstraints position = new GridBagConstraints();
        position.insets = new Insets(5, 1, 3, 1);

        position.gridy = 1;
        buttonPanel.add(undoMove, position);
        undoMove.addActionListener(listener);

        position.gridy = 2;
        buttonPanel.add(basicRules, position);
        basicRules.addActionListener(listener);

        add(buttonPanel, BorderLayout.WEST);
        add(checkerPanel, BorderLayout.EAST);
    }

    private void setBackgroundColor(int r, int c){
        if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)){
            board[r][c].setBackground(Color.RED);
        }
        if ((r % 2 == 1 && c % 2 == 0) || (r % 2 ==0 && c % 2 == 1)){
            board[r][c].setBackground(Color.black);
        }
    }

    private class listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == basicRules){
                JOptionPane.showMessageDialog(null, theRules);
            }
        }
    }
}
