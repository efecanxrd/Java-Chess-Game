public class Queen extends Piece {
    public Queen(boolean isWhite) {
    super(isWhite);
    }

    @Override
    public boolean canMove(Square start, Square end, Piece[][] board) {
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();
    
        if (deltaX == 0 && deltaY == 0) {
            // Queen cannot move to its current position
            return false;
        }
    
        if (deltaX == 0 || deltaY == 0 || Math.abs(deltaX) == Math.abs(deltaY)) {
    // Queen can move horizontally, vertically, or diagonally
    int xDir = deltaX == 0 ? 0 : deltaX / Math.abs(deltaX);
    int yDir = deltaY == 0 ? 0 : deltaY / Math.abs(deltaY);

            int currentX = start.getX() + xDir;
            int currentY = start.getY() + yDir;
            while (currentX != end.getX() || currentY != end.getY()) {
                if (board[currentY][currentX] != null) {
                    // Queen cannot jump over other pieces
                    return false;
                }
                currentX += xDir;
                currentY += yDir;
            }
    
            Piece endPiece = board[end.getY()][end.getX()];
            if (endPiece == null || endPiece.isWhite() != isWhite()) {
                return true;
            }
        }
    
        return false;
    }
    
    @Override
    public String toString() {
        return isWhite() ? "Q" : "q";
    }
}
    
    