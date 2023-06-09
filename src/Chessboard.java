public class Chessboard {
    private Piece[][] board;

    public Chessboard() {
        board = new Piece[8][8];

        // Initialize the board with the starting position
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true);
        }

        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);
        board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(false);
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void print() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i <8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(piece.toString() + " ");
                }
            }
            System.out.println(8 - i);
        }
        System.out.println("  a b c d e f g h");
    }

    public boolean move(Square start, Square end) {
        Piece piece = board[start.getY()][start.getX()];
        if (piece == null) {
            return false;
        }

        if (!piece.canMove(start, end, board)) {
            return false;
        }
        System.out.println(end.getY() + " " + end.getX());
        board[end.getX()][end.getY()] = piece;
        board[start.getY()][start.getX()] = null;
        return true;
    }

    public boolean isGameOver() {
        boolean whiteExists = false;
        boolean blackExists = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece instanceof King) {
                    if (piece.isWhite()) {
                        whiteExists = true;
                    } else {
                        blackExists = true;
                    }
                }
            }
        }

        return !whiteExists || !blackExists;
    }
}   