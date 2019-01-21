package tutorial.keywords;

import java.io.FileInputStream;

public class Keywords {

    public static void main(String[] args) throws Exception {

        String[] arr = {
                "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean",
                "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public",
                "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
                "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"
        };

        int al = arr.length;
        int[] count = new int[al];

        FileInputStream fis = new FileInputStream("C:\\Projects\\java-tutorial1\\src\\tutorial\\keywords\\Keywords.java");
        StringBuilder sb = new StringBuilder();
        String st;
        int read;

        while ((read = fis.read()) != -1) {
            if((char)read >= 'a' && (char)read <= 'z')
                sb.append((char)read);
            else {
                st = sb.toString();
                for(int i = 0; i < al; ++i) {
                    if(st.equals(arr[i])) {
                        count[i]++;
                        break;
                    }
                }
                sb = new StringBuilder();
            }
        }

        for (int i = 0; i < al; ++i) {
            System.out.println(arr[i] + ": " + count[i]);
        }

    }

}
