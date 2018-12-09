package e14extra.p2;

public class ChessKnight {
    private static String knightMoves(String pos) {
        pos = pos.toLowerCase();
        char col = pos.charAt(0);
        char row = pos.charAt(1);

        int[][] moves = { {-2, 1}, {-1, 2}, {1, 2}, {2 ,1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };

        boolean[] fM = new boolean[8];

        if(col - 1 < 'a') { fM[1] = true; fM[6] = true; }
        if(col - 2 < 'a') { fM[0] = true; fM[7] = true; }
        if(col + 1 > 'h') { fM[2] = true; fM[5] = true; }
        if(col + 2 > 'h') { fM[3] = true; fM[4] = true; }
        if(row - 1 < '1') { fM[4] = true; fM[7] = true; }
        if(row - 2 < '1') { fM[5] = true; fM[6] = true; }
        if(row + 1 > '8') { fM[0] = true; fM[3] = true; }
        if(row + 2 > '8') { fM[1] = true; fM[2] = true; }

        String[] stMoves = new String[fM.length];

        for(int i = 0; i < fM.length; ++i) {
            if(!fM[i]){
                StringBuilder sb = new StringBuilder();
                sb.append((char)(col + moves[i][0]));
                sb.append((char)(row + moves[i][1]));
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
