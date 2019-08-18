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
        setStats(row, col);
    }

    protected void setBooleanLimits(int r, int c){

    }

    protected void setStats(int r, int c){
        setRowAndCol(r, c);
        setBooleanLimits(r, c);
    }

    protected void setRowAndCol(int r, int c){
        this.row = r;
        this.col = c;
    }

    public String getColor() {
        return color;
    }

    public boolean isKinged() {
        return isKinged;
    }

    public void setKinged(boolean isKinged){
        this.isKinged = isKinged;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString(){
        return "" + this.getColor() + ", " + this.isKinged() + ", [" + this.getRow() + ", " + this.getCol() + "]";
    }
}
