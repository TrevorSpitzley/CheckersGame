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
    private JLabel blackScore;
    private JLabel redScore;
    private JLabel separator;
    private JLabel separator2;
    private boolean firstHalfDone = false;
    private boolean secondHalfDone = false;
    private int fromRow;
    private int fromColumn;
    private int toRow;
    private int toColumn;
    private JPanel checkerPanel;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
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

        redLabel = new JLabel("Player 1");
        redScore = new JLabel("Score");
        blackLabel = new JLabel("Player 2");
        blackScore = new JLabel("Score");
        separator = new JLabel("__________");
        separator2 = new JLabel("__________");

        board = new JButton[8][8];
        listener = new listener();
        checkerPanel = new JPanel();
        mainPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        checkerPanel.setLayout(new GridLayout(8, 8, 1, 1));
        checkerPanel.setPreferredSize(new Dimension(600, 600));

        leftPanel.setLayout(new GridLayout(3, 1, 1, 1));
        leftPanel.add(blackLabel);
        leftPanel.add(separator);
        leftPanel.add(blackScore);

        rightPanel.setLayout(new GridLayout(3, 1, 1, 1));
        rightPanel.add(redLabel);
        rightPanel.add(separator2);
        rightPanel.add(redScore);


        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                board[r][c] = new JButton("", null);
                board[r][c].addActionListener(listener);
                checkerPanel.add(board[r][c]);
                setBackgroundColor(r, c);
            }

        mainPanel.add(leftPanel);
        mainPanel.add(checkerPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);
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
