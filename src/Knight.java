public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Square start, Square end, Piece[][] board) {
        int deltaX = Math.abs(end.getX() - start.getX());
        int deltaY = Math.abs(end.getY() - start.getY());

        if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) {
            // Knight can move in an L-shape
            Piece endPiece = board[end.getY()][end.getX()];
            if (endPiece == null || endPiece.isWhite() != isWhite()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "N" : "n";
    }
}