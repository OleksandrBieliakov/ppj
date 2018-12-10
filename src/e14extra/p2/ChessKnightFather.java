package e14extra.p2;

public class ChessKnightFather {
    private static String knightMoves(String pos) {
        pos = pos.toLowerCase();
        char col = pos.charAt(0);
        char row = pos.charAt(1);

        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        StringBuilder sb = new StringBuilder();
        for (int[] move : moves) {
            int moveCol = col + move[0];
            int moveRow = row + move[1];
            if (moveCol >= 'a' && moveCol <= 'h' && moveRow >= '1' && moveRow <= '8') {
                sb.append((char) moveCol).append((char) moveRow).append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (String s : new String[]{"A1", "d5", "g6", "C8"})
            System.out.println(s + " -> " + knightMoves(s));
    }
}
