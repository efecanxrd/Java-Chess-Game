public class Square {
    private int x;
    private int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Square fromAlgebraicNotation(String notation) {
        int x = notation.charAt(0) - 'a';
        int y = Integer.parseInt(notation.charAt(1) + "") - 1;
        return new Square(x, y);
    }

    public String toAlgebraicNotation() {
        char x = (char) ('a' + getX());
        int y = getY() + 1;
        return x + "" + y;
    }
}