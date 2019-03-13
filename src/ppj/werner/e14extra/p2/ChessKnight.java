package ppj.werner.e14extra.p2;

public class ChessKnight {
    private static String knightMoves(String pos) {
        pos = pos.toLowerCase();
        char col = pos.charAt(0);
        char row = pos.charAt(1);

        int[][] moves = { {-2, 1}, {-1, 2}, {1, 2}, {2 ,1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };

        String[] stMoves = new String[moves.length];

        for(int i = 0; i < moves.length; ++i) {
            int moveCol = col + moves[i][0];
            int moveRow = row + moves[i][1];
            if (moveCol >= 'a' && moveCol <= 'h' && moveRow >= '1' && moveRow <= '8') {
                StringBuilder sb = new StringBuilder();
                sb.append((char) moveCol).append((char) moveRow);
                stMoves[i] = sb.toString();
            }
        }

        for (int i = 0; i < stMoves.length - 1; ++i) {
            for (int j = i + 1; j < stMoves.length; ++j) {
                if(stMoves[i] != null && stMoves[j] != null) {
                    if(stMoves[i].compareTo(stMoves[j]) > 0) {
                        String t = stMoves[i];
                        stMoves[i] = stMoves[j];
                        stMoves[j] = t;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stMoves) {
            if(str != null) sb.append(str + " ");
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        for (String s : new String[]{"A1","d5","g6","C8"})
            System.out.println(s + " -> " + knightMoves(s));
    }
}
