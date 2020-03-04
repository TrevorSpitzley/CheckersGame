package Checkers;

public class CheckersPiece {

    private String color;
    private boolean isKinged;
    private int row;
    private int col;

    public CheckersPiece(String color, boolean isKinged, int row, int col){
        this.color = color;
        this.isKinged = isKinged;
        this.row = row;
        this.col = col;
    }

    public CheckersPiece (CheckersPiece p) {
        this.color = p.getColor();
        this.isKinged = p.isKinged();
        this.row = p.getRow();
        this.col = p.getCol();
    }

    protected void updateInfo(int r, int c){
        this.row = r;
        this.col = c;
    }

    protected String getColor() {
        return color;
    }

    protected boolean isKinged() {
        return isKinged;
    }

    protected void setKinged(boolean isKinged){
        this.isKinged = isKinged;
    }

    protected int getRow() {
        return row;
    }

    protected int getCol() {
        return col;
    }

    @Override
    public String toString(){
        return "" + this.getColor() + ", " + this.isKinged() + ", [" + this.getRow() + ", " + this.getCol() + "]";
    }
}
