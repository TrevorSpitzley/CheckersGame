package Checkers;

import java.util.ArrayList;

public class CheckersModel {
    private CheckersPiece[][] board, tempBoard;
    private CheckersPiece temp;
    private ArrayList<CheckersPiece[][]> boardList;
    private int numBoards, redScore, blackScore;

    public CheckersModel(){
        board = new CheckersPiece[8][8];
        tempBoard = new CheckersPiece[8][8];
        temp = new CheckersPiece(null, false, -1, -1);
        //Sets pieces in play
        setPieces();
        //Set score, and numBoards
        numBoards = 0;
        redScore = 0;
        blackScore = 0;
        //Save initial board face
        boardList = new ArrayList<>();
        saveBoard();
    }

    public int getRedScore() {
        return redScore;
    }

    public int getBlackScore() {
        return blackScore;
    }

//    protected void makeMove(Move m){
//        if (m.isValidMove()){
//            temp = board[m.getFromRow()][m.getFromCol()];
//            board[m.getFromRow()][m.getFromCol()] = null;
//            board[m.getToRow()][m.getToCol()] = new CheckersPiece(temp.getColor(), temp.isKinged(), temp.getRow(), temp.getCol());
//            board[m.getToRow()][m.getToCol()].updateInfo(m.getToRow(), m.getToCol());
//            saveBoard();
//        }
//    }

    protected void makeMove(Move m) {
        if (m.isValidMove()) {
            board[m.getToRow()][m.getToCol()] = board[m.getFromRow()][m.getFromCol()];
            board[m.getFromRow()][m.getFromCol()] = null;
            pieceAt(m.getToRow(), m.getToCol()).updateInfo(m.getToRow(), m.getToCol());
            saveBoard();
        }
    }

    private void setPieces(){
       //top pieces
        for (int c = 1; c < 8; c = c + 2)
            board[0][c] = new CheckersPiece("Black", false, 0, c);
        //bottom pieces
        for (int c = 0; c < 8; c = c + 2)
            board[7][c] = new CheckersPiece("Red", false, 7, c);
    }

    private void saveBoard(){
        tempBoard = board;
        boardList.add(numBoards, tempBoard);
        numBoards++;
    }

    protected void undoMove(){
        if (numBoards > 0) {

            tempBoard = boardList.get(numBoards);
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    board[r][c] = tempBoard[r][c];
                }
            }
            boardList.remove(numBoards);
            numBoards--;
        }
    }

    protected CheckersPiece pieceAt(int row, int col) {
        return board[row][col];
    }
}
