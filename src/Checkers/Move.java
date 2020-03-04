package Checkers;

public class Move {

    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;
    private CheckersModel model = new CheckersModel();

    public Move(int fromRow, int fromCol, int toRow, int toCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    protected boolean isValidMove(){
        boolean isValid = false;
        if (model.pieceAt(this.fromRow, this.fromCol) != null && model.pieceAt(this.toRow, this.toCol) == null) {
            CheckersPiece temp = model.pieceAt(this.fromRow, this.fromCol);

            if (temp.isKinged()) {
                if (Math.abs(this.fromCol - this.toCol) <= 2 && Math.abs(this.fromRow - this.toRow) <= 2)
                    isValid = true;
            } else {
                if (temp.getColor().equals("Black"))
                    if ( (this.toRow > this.fromRow) && (this.toRow - this.fromRow == 1) && Math.abs(this.fromCol - this.toCol) == 1)
                        isValid = true;
                if (temp.getColor().equals("Red")){
                    if ( (this.toRow < this.fromRow) && (this.fromRow - this.toRow == 1) && Math.abs(this.fromCol - this.toCol) == 1)
                        isValid = true;
                }
            }
        }
        return isValid;
    }

    @Override
    public String toString(){
        return "Move: [" + this.fromRow + ", " + this.fromCol + "], to [" + this.toRow + ", " + this.toCol + "]";
    }

    //Complete getter's. All other methods belong above these for simplicity of reading
    public int getFromRow() {
        return fromRow;
    }

    public int getFromCol() {
        return fromCol;
    }

    public int getToRow() {
        return toRow;
    }

    public int getToCol() {
        return toCol;
    }
}
