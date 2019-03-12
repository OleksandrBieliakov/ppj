package ppj.e14extra.p1;

public class Password {

    private static boolean check(char[] arr) {

        boolean isOk = true;

        if (arr.length < 8) {
            System.out.println("Too short");
            isOk = false;
        }

        int difChar = 1;
        char[] charMet = new char[arr.length];
        charMet[0] = arr[0];
        MAIN_LOOP:
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < difChar; ++j) {
                if (arr[i] == charMet[j]) continue MAIN_LOOP;
            }
            charMet[difChar++] = arr[i];
        }
        if (difChar < 6) {
            System.out.println("Too few different characters");
            isOk = false;
        }

        boolean hasDigit = false;
        for (char ch : arr) {
            if (ch >= '0' && ch <= '9') {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            System.out.println("No digit");
            isOk = false;
        }

        boolean hasUCase = false;
        for (char ch : arr) {
            if (ch >= 'A' && ch <= 'Z') {
                hasUCase = true;
                break;
            }
        }
        if (!hasUCase) {
            System.out.println("No uppercase letter");
            isOk = false;
        }

        boolean hasLCase = false;
        for (char ch : arr) {
            if (ch >= 'a' && ch <= 'z') {
                hasLCase = true;
                break;
            }
        }
        if (!hasLCase) {
            System.out.println("No lower letter");
            isOk = false;
        }

        boolean hasSymb = false;
        for (char ch : arr) {
            if (ch < '0' || (ch > '9' && ch < 'A') || (ch > 'Z' && ch < 'a') || ch > 'z') {
                hasSymb = true;
                break;
            }
        }
        if (!hasSymb) {
            System.out.println("No non-alphanumeric character");
            isOk = false;
        }

        return isOk;

    }

    public static void main(String[] args) {

        char[][] passwords = {
                "AbcDe93".toCharArray(),
                "A1b:A1b>".toCharArray(),
                "Ab:Acb<".toCharArray(),
                "abc123><".toCharArray(),
                "Zorro@123".toCharArray()
        };
        for (char[] password : passwords) {
            System.out.print("checking " + new String(password));
            System.out.println();
            if (check(password)) System.out.println("OK");
            System.out.println();
        }

    }

}
