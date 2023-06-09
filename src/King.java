public class King extends Piece {
    public King(boolean isWhite) {
    super(isWhite);
    }
    

    @Override
    public boolean canMove(Square start, Square end, Piece[][] board) {
        int deltaX = Math.abs(end.getX() - start.getX());
        int deltaY = Math.abs(end.getY() - start.getY());
    
        if (deltaX <= 1 && deltaY <= 1) {
            // King can move one square in any direction
            Piece endPiece = board[end.getY()][end.getX()];
            if (endPiece == null || endPiece.isWhite() != isWhite()) {
                return true;
            }
        }
    
        return false;
    }
    
    @Override
    public String toString() {
        return isWhite() ? "K" : "k";
    }
}