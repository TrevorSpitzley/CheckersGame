public class CheckersPiece {

    private String pieceColor;

    private boolean kinged;


    public CheckersPiece(String pieceColor) {
        this.pieceColor = pieceColor;

        this.kinged = false;
    }

    public boolean isKinged(){
        return this.kinged;
    }

    public void kingMe(){
        this.kinged = true;
    }

    public String getColor(){
        return this.pieceColor;
    }
}
