package e14extra.p3;

public class DNA {

    private static int compare(String a, String b) {
        int deg = 0;
        int count = 0;
        for(int i = 0; i < a.length(); ++i) {
            if(a.charAt(i) == b.charAt(i))
                count++;
            else {
                deg += count * count;
                count = 0;
            }
        }
        return deg += count * count;
    }

    private static int simil(String a, String b) {
        String longer = a;
        String shorter = b;
        if(a.length() < b.length()){
            longer = b;
            shorter = a;
        }

        int maxD = 0;
        for (int i = 0; i <= longer.length() - shorter.length(); ++i) {
            int deg = compare(shorter, longer.substring(i, i + shorter.length()));
            if(maxD < deg) maxD = deg;
        }
        return maxD;
    }

    public static void main (String[] args) {
        String a = "AACTACGTC";
        String b = "ACGTA";
        System.out.println(a + " and " + b +
                " -> " + simil(a, b));
        String c = "GCGC";
        String d = "AGGGCA";
        System.out.println(c + " and " + d +
                " -> " + simil(c, d));
    }
}