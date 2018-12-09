package e14extra.p2;

public class ChessKnight {
    public static String knightMoves(String pos) {

        char col = pos.charAt(0);
        char row = pos.charAt(1);





    }

    public static void main (String[] args) {
        for (String s : new String[]{"A1","d5","g6","C8"})
            System.out.println(s + " -> " + knightMoves(s));
    }
}
