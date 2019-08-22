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
    private JMenuItem exitGame;
    private JMenuItem basicRules;
    private String theRules;
    private listener listener;
    private JLabel pieceLabel;
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
    private ImageIcon blackChecker;
    private ImageIcon blackKing;

    public CheckersPanel(){
        model = new CheckersModel();
        theRules = "1.) Rock, Paper, Scissors to see who goes first! \n" +
                "2.) Whoever wins the RPS, begins by moving any of their pieces from the front \n" +
                " row one space diagonally to the left or right towards the opposite player! \n" +
                "3.) Capturing may only be done diagonally with forward motion, unless King'd,\n" +
                " then you may capture forwards and backwards diagonally! \n" +
                "4.) As soon as one of your checkers reaches the first row of your opponents,\n" +
                "it becomes a King!\n" + "5.) Regardless of royalty, if all adjacent sides of your\n" +
                " piece are occupied by your opponent's pieces... You may not move that piece.\n" +
                " It has been locked, and cannot move until an adjacent side has been opened up. \n" +
                " 6.) If you absolutely must undo a move, simply chant, ''CandyMan.. CandyMan..CandyMan.." +
                "'' three times, then right click.";

        createMenuBar();
        createIcons();

        pieceLabel = new JLabel("Yeet");
        redLabel = new JLabel("Player 1");
        redScore = new JLabel("" + model.getRedScore());
        blackLabel = new JLabel("Player 2");
        blackScore = new JLabel("" + model.getBlackScore());
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

        mainPanel.add(leftPanel);
        mainPanel.add(checkerPanel);
        mainPanel.add(rightPanel);

        //Will remove later...
        leftPanel.add(pieceLabel);

        setButtons();

        add(mainPanel);
    }

    private void setButtons(){
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                board[r][c] = new JButton("", null);
                board[r][c].addActionListener(listener);
                checkerPanel.add(board[r][c]);
                setBackgroundColor(r, c);
                setIcons(r, c);
            }
    }

    protected JMenuBar createMenuBar(){
        menu = new JMenu("Menu");

        menuBar = new JMenuBar();

        exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(listener);
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(listener);
        basicRules = new JMenuItem("Quick Rules");
        basicRules.addActionListener(listener);

        menu.add(newGame);
        menu.add(basicRules);
        menu.add(exitGame);

        menuBar.add(menu);

        return menuBar;
    }

    private void setBackgroundColor(int r, int c){
        if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)){
            board[r][c].setBackground(Color.black);
        }
        if ((r % 2 == 1 && c % 2 == 0) || (r % 2 ==0 && c % 2 == 1)){
            board[r][c].setBackground(Color.white);
        }
    }

    private void createIcons(){
        redChecker = new ImageIcon("C:\\Users\\trevo\\IdeaProjects\\CheckersGame\\src\\Checkers\\Checker_Piece_Red.png");
        redKing = new ImageIcon("C:\\Users\\trevo\\IdeaProjects\\CheckersGame\\src\\Checkers\\redKingChecker.png");
        blackChecker = new ImageIcon("C:\\Users\\trevo\\IdeaProjects\\CheckersGame\\src\\Checkers\\CheckerBlackPiece.png");
        blackKing = new ImageIcon("C:\\Users\\trevo\\IdeaProjects\\CheckersGame\\src\\Checkers\\BlackCheckerKing.png");
    }

    private void setIcons(int r, int c){
            if (model.pieceAt(r, c) != null &&
                    model.pieceAt(r, c).getColor().equals("Red")
                    && !model.pieceAt(r, c).isKinged())
                board[r][c].setIcon(redChecker);

            if (model.pieceAt(r, c) != null &&
                    model.pieceAt(r, c).getColor().equals("Red")
                    && model.pieceAt(r, c).isKinged())
                board[r][c].setIcon(redKing);

            if (model.pieceAt(r, c) != null &&
                    model.pieceAt(r, c).getColor().equals("Black")
                    && !model.pieceAt(r, c).isKinged())
                board[r][c].setIcon(blackChecker);

            if (model.pieceAt(r, c) != null &&
                    model.pieceAt(r, c).getColor().equals("Black")
                    && model.pieceAt(r, c).isKinged())
                board[r][c].setIcon(blackKing);

            if (model.pieceAt(r, c) == null)
                board[r][c].setIcon(null);
    }

    private void updateScores(){
        redScore.setText("" + model.getRedScore());
        blackScore.setText("" + model.getBlackScore());

    }

    private class listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == basicRules){
                JOptionPane.showMessageDialog(null, theRules);
            }

            if (e.getSource() == exitGame){
                System.exit(0);
            }

            if (e.getSource() == newGame){
                model = new CheckersModel();
                for (int r = 0; r < 8; r++)
                    for (int c = 0; c < 8; c++) {
                        setIcons(r, c);
                    }
            }

            for (int r = 0; r < 8; r++)
                for (int c = 0; c < 8; c++) {
                    if (firstHalfDone == false) {
                        if (e.getSource() == board[r][c] && model.pieceAt(r, c) != null) {
                            fromRow = r;
                            fromColumn = c;
                            firstHalfDone = true;
                            pieceLabel.setText("" + model.pieceAt(r, c).toString());
                            return;
                        }
                    }
                    if (firstHalfDone == true) {
                        if (e.getSource() == board[r][c] && model.pieceAt(r, c) == null) {
                            toRow = r;
                            toColumn = c;
                            secondHalfDone = true;

                            Move m = new Move(fromRow, fromColumn, toRow, toColumn);
                            if (m.isValidMove()) {
                                model.makeMove(m);
                                setIcons(fromRow, fromColumn);
                                setIcons(toRow, toColumn);
                            }
                            firstHalfDone = false;
                            secondHalfDone = false;
                            return;
                        }
                    }
                }
            updateScores();
        }
    }

}
