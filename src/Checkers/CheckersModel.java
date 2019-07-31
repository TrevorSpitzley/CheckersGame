package Checkers;

public class CheckersModel {
    private CheckersPiece[][] board;
    private int redScore, blackScore;

    public CheckersModel(){
        board = new CheckersPiece[8][8];
        //Sets pieces in play
        setPieces();
    }

    public int getRedScore() {
        return redScore;
    }

    public int getBlackScore() {
        return blackScore;
    }

    protected void makeMove(Move m){

    }

    protected boolean isValidMove(Move m){
        boolean isValid = false;

        if (board[m.getFromRow()][m.getFromCol()] != null){
           if (board[m.getToRow()][m.getToCol()] == null){

           }

        }

        return isValid;
    }

    private void setPieces(){
       //top pieces
        for (int c = 0; c < 8; c = c + 2)
            board[0][c] = new CheckersPiece("Black", false, 0, c);
        for (int c = 1; c < 8; c = c + 2)
            board[1][c] = new CheckersPiece("Black", false, 1, c);
        for (int c = 0; c < 8; c = c + 2)
            board[2][c] = new CheckersPiece("Black", false, 2, c);

        //bottom pieces
        for (int c = 0; c < 8; c = c + 2)
            board[5][c] = new CheckersPiece("Red", false, 5, c);
        for (int c = 1; c < 8; c = c + 2)
            board[6][c] = new CheckersPiece("Red", false, 6, c);
        for (int c = 0; c < 8; c = c + 2)
            board[7][c] = new CheckersPiece("Red", false, 7, c);

    }

    protected CheckersPiece pieceAt(int row, int col) {
        return board[row][col];
    }
}
