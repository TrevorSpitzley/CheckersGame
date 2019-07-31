package Checkers;

public class CheckersPiece {

    private String color;
    private boolean isKinged;
    private int row;
    private int col;
    private int boundUp = 2;
    private int boundDown = 2;
    private int boundLeft = 2;
    private int boundRight = 2;

    public CheckersPiece(String color, boolean isKinged, int row, int col){
        this.color = color;
        this.isKinged = isKinged;
        this.row = row;
        this.col = col;
    }

    protected void setBounds(int r, int c){
        //Rows
        if (this.getRow() == 0)
            this.boundUp = 0;
        if (this.getRow() == 1)
            this.boundUp = 1;
        if (this.getRow() == 6)
            this.boundDown = 1;
        if (this.getRow() == 7)
            this.boundDown = 0;
        //Columns
        if (this.getCol() == 0)
            this.boundLeft = 0;
        if (this.getCol() == 1)
            this.boundLeft = 1;
        if (this.getCol() == 6)
            this.boundRight = 1;
        if (this.getCol() == 7)
            this.boundRight = 0;
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
}
