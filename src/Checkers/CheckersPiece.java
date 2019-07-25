package Checkers;

public class CheckersPiece {

    private String color;
    private boolean isKinged;
    private int row;
    private int col;
    private int boundUp = 1;
    private int boundDown = 1;
    private int boundLeft = 1;
    private int boundRight = 1;

    public CheckersPiece(String color, boolean isKinged, int row, int col){
        this.color = color;
        this.isKinged = isKinged;
        this.row = row;
        this.col = col;
    }

    public String getColor() {
        return color;
    }

    public boolean isKinged() {
        return isKinged;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
