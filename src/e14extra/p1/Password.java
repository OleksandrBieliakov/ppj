package e14extra.p1;

public class Password {

    public static boolean che1 (char[] arr) {
        if(arr.length < 8) {
            System.out.println("");
        }
        return arr.length >= 8 ? true : false;
    }

    public static boolean check (char[] arr) {
        boolean isOk = true;


        int count = 1;
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if(arr[i] != arr[j]) count++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] passwords = {
                "AbcDe93".toCharArray(),
                "A1b:A1b>".toCharArray(),
                "Ab:Acb<".toCharArray(),
                "abc123><".toCharArray(),
                "Zorro@123".toCharArray()
        };

        for (int i = 0; i < passwords.length; ++i) {

            char[] password = new char[passwords[i].length];
            for (int j = 0; j < password.length; ++j) {
                password[j] = passwords[i][j];
            }

            System.out.print("checking ");
            for (char ch : password) {
                System.out.print(ch);
            }
            System.out.println();

            if (check(password))
                System.out.println("OK");

            System.out.println();

        }

    }

}
