import java.util.Scanner;

public class Game {
private Chessboard board;
private boolean isWhiteTurn;


public Game() {
    board = new Chessboard();
    isWhiteTurn = true;
}

public void play() {
    try (Scanner scanner = new Scanner(System.in)) {
        while (!board.isGameOver()) {
            // Print the board
            board.print();

            // Get the player's move
            System.out.println((isWhiteTurn ? "White" : "Black") + " to move:");
            System.out.print("Enter start square (e.g. 'e2'): ");
            String startNotation = scanner.nextLine();
            Square start = Square.fromAlgebraicNotation(startNotation);
            System.out.print("Enter end square (e.g. 'e4'): ");
            String endNotation = scanner.nextLine();
            Square end = Square.fromAlgebraicNotation(endNotation);

            // Make the move
            if (board.move(start, end)) {
                isWhiteTurn = !isWhiteTurn;
            } else {
                System.out.println("Invalid move, try again.");
                continue; // Go back to the top of the loop
            }
        }
    }

    // Print the final board
    board.print();

    // Print the winner
    if (!isWhiteTurn) {
        System.out.println("White wins!");
    } else {
        System.out.println("Black wins!");
    }
}

public static void main(String[] args) {
    Game game = new Game();
    game.play();
}
}