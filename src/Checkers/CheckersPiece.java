package Checkers;

public class CheckersPiece {

    private String color;
    private boolean isKinged;
    private int row = 0;
    private int col = 0;
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

}
