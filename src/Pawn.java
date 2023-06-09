public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Square start, Square end, Piece[][] board) {
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();

        if (deltaX == 0 && deltaY == 0) {
            // Pawn cannot move to its current position
            return false;
        }

        int directionOfMovement = isWhite() ? -1 : 1;

        if (deltaX == 0) {
            // Pawn can move forward
            if (deltaY == directionOfMovement) {
                // Move one square forward
                Piece endPiece = board[end.getY()][end.getX()];
                if (endPiece == null) {
                    return true;
                }
            } else if (deltaY == 2 * directionOfMovement && start.getY() == (isWhite() ? 6 : 1)) {
                // Move two squares forward from starting position
                Piece endPiece = board[end.getY()][end.getX()];
                Piece intermediatePiece = board[start.getY() + directionOfMovement][start.getX()];
                if (endPiece == null && intermediatePiece == null) {
                    return true;
                }
            }
        } else if (Math.abs(deltaX) == 1 && deltaY == directionOfMovement) {
            // Pawn can capture diagonally
            Piece endPiece = board[end.getY()][end.getX()];
            if (endPiece != null && endPiece.isWhite() != isWhite()) {
                return true;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return isWhite() ? "P" : "p";
    }
}