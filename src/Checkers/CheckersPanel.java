package Checkers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CheckersPanel extends JPanel {

    private JButton[][] board;
    private CheckersModel model;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem newGame;
    private JMenuItem basicRules;
    private JButton undoMove;
    private String theRules;
    private listener listener;
    private JLabel blackLabel;
    private JLabel redLabel;
    private String blackScore;
    private String redScore;
    private boolean firstHalfDone = false;
    private boolean secondHalfDone = false;
    private int fromRow;
    private int fromColumn;
    private int toRow;
    private int toColumn;
    private JPanel checkerPanel;
    private JPanel mainPanel;
    private ImageIcon redChecker;
    private ImageIcon redKing;
    private ImageIcon blackchecker;
    private ImageIcon blackKing;

    public CheckersPanel(){

        theRules = "1.) Rock, Paper, Scissors to see who goes first! \n" +
                "2.) Whoever wins the RPS, begins by moving any of their pieces from the front \n" +
                " row one space diagonally to the left or right towards the opposite player! \n" +
                "3.) Capturing may only be done diagonally with forward motion, unless King'd,\n" +
                " then you may capture forwards and backwards diagonally! \n" +
                "4.) As soon as one of your checkers reaches the first row of your opponents,\n" +
                "it becomes a King!\n" + "5.) Regardless of royalty, if all adjacent sides of your\n" +
                " piece are occupied by your opponent's pieces... You may not move that piece.\n" +
                " It has been locked, and cannot move until an adjacent side has been opened up.";

        menu = new JMenu();
        menuBar = new JMenuBar();
        newGame = new JMenuItem();
        basicRules = new JMenuItem();

        redLabel = new JLabel("Name plus \n" + "score");
        blackLabel = new JLabel("Name plus \n" + "score");

        board = new JButton[8][8];
        listener = new listener();
        checkerPanel = new JPanel();
        mainPanel = new JPanel();

        checkerPanel.setLayout(new GridLayout(8, 8, 1, 1));
        checkerPanel.setPreferredSize(new Dimension(600, 600));

        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                board[r][c] = new JButton("", null);
                board[r][c].addActionListener(listener);
                checkerPanel.add(board[r][c]);
                setBackgroundColor(r, c);
            }

        mainPanel.add(blackLabel);
        mainPanel.add(checkerPanel);
        mainPanel.add(redLabel);

        add(mainPanel, BorderLayout.NORTH);
    }

    private void setBackgroundColor(int r, int c){
        if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)){
            board[r][c].setBackground(Color.red);
        }
        if ((r % 2 == 1 && c % 2 == 0) || (r % 2 ==0 && c % 2 == 1)){
            board[r][c].setBackground(Color.black);
        }
    }

    private void createIcons(){
        redChecker = new ImageIcon("/.src/Checkers/Checker_Piece_Red.png");
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
